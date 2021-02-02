package Guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import org.junit.Test;

/**
 * @author xiangjin.kong
 * @date 2021/2/2 17:01
 * @desc 无序可以重复的Set集合
 */
public class MultisetTest {

    @Test
    public void test() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("b");
        multiset.add("a");
        multiset.add("c");
        multiset.add("d");
        multiset.add("b");
        multiset.add("f");

        for (String s : multiset) {
            System.out.println(s);
        }

        int count = multiset.count("b");
        System.out.println("b对象的数量:" + count);

        System.out.println();
        TreeMultiset<Integer> multiset1 = TreeMultiset.create() ;
        multiset1.add(4);
        multiset1.add(1);
        multiset1.add(6);
        multiset1.add(7);
        multiset1.add(2);
        for (Integer integer : multiset1) {
            System.out.println(integer);
        }
    }
}
