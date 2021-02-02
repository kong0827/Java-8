package Guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.Hashtable;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author xiangjin.kong
 * @date 2021/2/2 17:27
 * @desc 多个key rowKey,columnKey,value
 */
public class TableTest {

    @Test
    public void test() {
        Table<String, String, Integer> table = HashBasedTable.create();

        table.put("张三", "数学", 30);
        table.put("张三", "语文", 90);
        table.put("张三", "英语", 70);

        table.put("李四", "数学", 80);
        table.put("李四", "语文", 60);
        table.put("李四", "英语", 70);

        Map<String, Integer> map = table.row("张三");
        System.out.println(map);

        System.out.println("---------------");
        for (String s : table.rowKeySet()) {
            System.out.println(s);
        }
        System.out.println("---------");


        for (String s : table.columnKeySet()) {
            System.out.println(s);
        }
    }
}
