### 概述
`MapStruct` 是一个注解处理器，用于生成类型安全，高性能的无依赖的 `Java Bean`，可以实现两个JavaBean之间的互相映射

### 常见的动态映射
1. Apache BeanUtils
1. Spring BeanUtils
1. cglib.BeanCopier

### 使用
在使用MapStruct时，只需要定义一个映射器接口，接口中声明任何映射方法。在编译期间，`MapStruct` 将生成此接口的实现。此实现使用纯 Java 方法调用来映射源对象和目标对象，即没有反射。
#### 1、添加依赖
```xml
<properties>
    <org.mapstruct.version>1.4.2.Final</org.mapstruct.version>
</properties>
...
<dependencies>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>${org.mapstruct.version}</version>
    </dependency>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>${org.mapstruct.version}</version>
    </dependency>
</dependencies>
```

#### 2、数据准备
```java
@Data
@ToString
@AllArgsConstructor
public class PersonDTO {

    private String name;

    private String sex;

    private Integer age;
}

@Data
@ToString
public class PersonVO {

    private String name;

    private String sex;
}
```

#### 3、定义映射器
现在需要将Dto装为vo，需要定义映射器
```java
@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonVO dtoToVo(PersonDTO dto);
}
```

#### 4、测试
```java
 PersonDTO dto = new PersonDTO("阿劲", "男", 24);
 PersonVO vo = PersonMapper.INSTANCE.dtoToVo(dto);
 System.out.println(vo);
```
![image.png](https://gitee.com/kongxiangjin/images/raw/master/img/db546a48832b4bebaf615d663af4d879~tplv-k3u1fbpfcp-watermark.image)



#### 5、映射不同字段名的字段

MapStruct 能够自动映射我们的 bean，因为它们具有相同的字段名称。那么，如果我们要映射的 bean 具有不同的字段名称怎么办？

```数据
public class StudentDTO {

    private String nickname;
    
    private String sex;
    
}
@Data
@ToString
public class StudentVO {

    private String name;
    
     private String sex; 
}
```

定义映射器

当映射不同的字段名称时，我们需要将其源字段配置为其目标字段，为此，我们需要添加*@Mappings*注释。这个注解接受一个*@Mapping*注解的数组，我们将使用它来添加目标和源属性

```java
@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "voName", source = "nickname")  // 属性名不一致
    @Mapping(target = "sex", ignore = true)         // 排除
    StudentVO dtoToVo(StudentDTO dto);
}
```



#### 6、具有多个源参数的映射方法

`MapStruct` 支持具有多个源参数的映射方法。例如，将多个实体组合成一个数据传输对象

1. 数据

   ```java
   @Data
   @AllArgsConstructor
   public class ClassDTO {
   
       private String name;
   
       private Integer count;
   
   }
   
   @Data
   @ToString
   @AllArgsConstructor
   public class StudentDTO {
   
       private String name;
   
       private String sex;
   
       private Integer age;
   }
   
   @Data
   @ToString
   public class StudentVO {
   
       private String studentName;
   
       private String sex;
   
       private Integer age;
   
       private String className;
   }
   ```

2. 定义映射器

   ```java
   @Mapper
   public interface StudentMapper {
   
       StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
   
   
       @Mapping(source = "studentDTO.name", target = "studentName")
       @Mapping(source = "classDTO.name", target = "className")
       StudentVO dtoToVo(StudentDTO studentDTO, ClassDTO classDTO);
   
   }
   ```

3. 测试

   ```java
   public class Test {
       public static void main(String[] args) {
           StudentDTO studentDTO = new StudentDTO("阿劲", "男", 24);
           ClassDTO classDTO = new ClassDTO("非师一班", 80);
           StudentVO vo = StudentMapper.INSTANCE.dtoToVo(studentDTO, classDTO);
           System.out.println(vo);
       }
   }
   ```

   ![image-20210613162815100](https://gitee.com/kongxiangjin/images/raw/master/img/image-20210613162815100.png)



#### 7、更多用法

https://mapstruct.org/documentation/stable/reference/html



### 原理

MapStruct 生成的代码， 类似于自己写的一样，不过是编译器自动生成，生成的代码可以在编译后看到, 在 target/generated-sources/annotations 下。 同时真正在代码包执行的可以在target/classes包中看到。

![image-20210613164228581](https://gitee.com/kongxiangjin/images/raw/master/img/image-20210613164228581.png)



### 总结

MapStruct主要用来解决对象拷贝，它区别与BeanUtils是通过反射进行属性赋值转换，他是通过编译器生成常规的方法，因此相对于反射，速度更快，效率更高，同时提供了多种配置进行字段名不同映射，多个数据源映射，自定义方法等等。