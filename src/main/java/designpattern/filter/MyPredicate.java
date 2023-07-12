package designpattern.filter;

/**
 * @author kxj
 * @date 2022/9/13 15:39
 * @desc
 */
public interface MyPredicate<T> {

    /**
     * 对传递过来的T类型的数据进行过滤
     * 符合规则返回true, 不符合规则返回false
     * @param t
     * @return
     */
    boolean filter(T t);
}
