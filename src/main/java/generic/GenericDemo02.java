package generic;

import generic.entity.Animal;
import generic.entity.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangjin.kong
 * @date 2021/1/27 10:33
 * @desc 泛型
 */
public class GenericDemo02 {

    /**
     * dst 类型 “大于等于” src 的类型，这里的“大于等于”是指 dst
     * 表示的范围比 src 要大，因此装得下 dst 的容器也就能装 src 。
     * @param dst
     * @param src
     * @param <T>
     */
    static <T> void test(List<? super T> dst, List<T> src) {
        for (T t : src) {
            dst.add(t);
        }
    }


    static <T extends Animal> T test2(T animal) {
        return animal;
    }


    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        test(animals, dogs);

        Dog dog = new Dog();
        Dog test2 = test2(dog);
        System.out.println(test2.countLegs());

        Animal animal = () -> 2;

        Animal animal1 = test2(animal);
        System.out.println(animal1.countLegs());
    }
}
