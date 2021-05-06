## Optional

1. `Optional(T value),empty(),of(T value),ofNullable(T value)`

   `Optional(T value)`，即构造函数，它是`private`权限的，不能由外部调用的。其余三个函数是public权限，供我们所调用。

   那么，`Optional` 的本质，就是内部储存了一个真实的值，在构造的时候，就直接判断其值是否为空。

   

   **源码解析**

   ```java
   private Optional(T value) {
       this.value = Objects.requireNonNull(value);
   }
   ```

   ```java
   private Optional(T value) {
       this.value = Objects.requireNonNull(value);
   }
   ```

   也就是说`of(T value)`函数内部调用了构造函数。根据构造函数的源码我们可以得出两个结论:

   - 通过`of(T value)`函数所构造出的`Optional`对象，当Value值为空时，依然会报`NullPointerException`
   - 通过`of(T value)`函数所构造出的`Optional`对象，当Value值不为空时，能正常构造`Optional`对象

   除此之外呢，Optional类内部还维护一个value为null的对象

   ```java
   private static final Optional<?> EMPTY = new Optional<>();
   
   private Optional() {
       this.value = null;
   }
   
   public static<T> Optional<T> empty() {
       @SuppressWarnings("unchecked")
       Optional<T> t = (Optional<T>) EMPTY;
       return t;
   }
   ```

   `empty()`的作用就是返回`EMPTY`对象

   

   `ofNullable(T value)`

   ```java
   public static <T> Optional<T> ofNullable(T value) {
       return value == null ? empty() : of(value);
   }
   ```

   相比较`of(T value)`的区别就是，当`value`值为`null`时，`of(T value)`会报`NullPointerException`异常；

   `ofNullable(T value)`不会`throw Exception`，`ofNullable(T value)`直接返回一个 `EMPTY` 对象

   那是不是意味着，我们在项目中只用`ofNullable`函数而不用of函数呢?

   不是的，一个东西存在那么自然有存在的价值。当我们在运行过程中，不想隐藏`NullPointerException`。而是要立即报告，这种情况下就用`Of`函数。但是不得不承认，这样的场景真的很少

   

2. `orElse(T other)，orElseGet(Supplier<? extends T> other)和orElseThrow(Supplier<? extends X> exceptionSupplier)`

   ```java
   @Test
   public void test() {
       Employee employee = null;
       Employee employee1 = Optional.ofNullable(employee).orElse(createEmployee());
       Employee employee2 = Optional.ofNullable(employee).orElseGet(() -> createEmployee());
       System.out.println(employee1);
       System.out.println(employee2);
   
       /*
        * employee值不为null时，orElse函数依然会执行createEmployee()方法，但是不会改变值
        * ，而orElseGet函数并不会执行createEmployee()方法
        */
       employee = Employee.builder().firstName("李").age(20).build();
       Employee employee3 = Optional.ofNullable(employee).orElse(createEmployee());
       Employee employee4 = Optional.ofNullable(employee).orElseGet(this::createEmployee);
       System.out.println(employee3);
       System.out.println(employee4);
       
        employee = null;
        Optional.ofNullable(employee).orElseThrow(() -> new Exception("空"));
   }
   ```

   这两个函数的区别：`employee`值不为`null`时，`orElse`函数依然会执行`createEmployee()`方法，但是不会改变值。而`orElseGet`函数并不会执行`createEmployee()`方法

   `orElseThrow`，就是`value`值为`null`时,直接抛一个异常出去

   

3. `map(Function<? super T, ? extends U> mapper)和flatMap(Function<? super T, Optional<U>> mapper)`

   ```java
   public<U> Optional<U> map(Function<? super T, ? extends U> mapper) {
       Objects.requireNonNull(mapper);
       if (!isPresent())
           return empty();
       else {
           return Optional.ofNullable(mapper.apply(value));
       }
   }
   public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) {
       Objects.requireNonNull(mapper);
       if (!isPresent())
       	return empty();
       else {
       	return Objects.requireNonNull(mapper.apply(value));
       }
   }
   ```

   这两个函数，在函数体上没什么区别。唯一区别的就是入参，`map`函数所接受的入参类型为`Function<? super T, ? extends U>`，而`flapMap`的入参类型为`Function<? super T, Optional<U>>`

4. `isPresent()`和`ifPresent(Consumer<? super T> consumer)`

   ```java
   public boolean isPresent() {
       return value != null;
   }
   
   public void ifPresent(Consumer<? super T> consumer) {
       if (value != null)
           consumer.accept(value);
   }
   ```

   `isPresent`即判断value值是否为空，而`ifPresent`就是在value值不为空时，做一些操作。

5. `filter`

   ```java
   public Optional<T> filter(Predicate<? super T> predicate) {
       Objects.requireNonNull(predicate);
       if (!isPresent())
           return this;
       else
           return predicate.test(value) ? this : empty();
   }
   ```

   filter 方法接受一个 Predicate 来对 Optional 中包含的值进行过滤，如果包含的值满足条件，那么还是返回这个 Optional；否则返回 Optional.empty。