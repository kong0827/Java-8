package generic.entity;

/**
 * @author xiangjin.kong
 * @date 2021/1/27 10:34
 */
public class Dog implements Animal {
    @Override
    public int countLegs() {
        return 4;
    }
}
