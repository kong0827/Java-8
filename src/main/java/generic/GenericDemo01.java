package generic;

import generic.entity.Animal;
import generic.entity.Dog;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangjin.kong
 * @date 2021/1/27 10:33
 * @desc 泛型
 */
public class GenericDemo01 {

    static int countLegs(List<? extends Animal> animals) {
        int value = 0;
        for (Animal animal : animals) {
            value += animal.countLegs();
        }
        return value;
    }

    static int countLegs1(List<Animal> animals) {
        int value = 0;
        for (Animal animal : animals) {
            value += animal.countLegs();
        }
        return value;
    }

    public static void main(String[] args) {
        /**
         * 对于不确定或者不关心实际要操作的类型，可以使用无限制通配符（尖括号里一个问号，即 <?> ），
         * 表示可以持有任何类型。像 countLegs 方法中，限定了上届，但是不关心具体类型是什么，
         * 所以对于传入的 Animal 的所有子类都可以支持，并且不会报错。而 countLegs1 就不行。
         */
        List<Dog> dogs = new ArrayList<>();
        // 不会报错
        countLegs( dogs );
        // 编译报错
//        countLegs1(dogs);
    }
}
