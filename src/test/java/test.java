import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author xiangjin.kong
 * @date 2020/12/21 10:56
 */
public class test {

    @Test
    public void test1() {
        BigDecimal productPrice = new BigDecimal(1);
        BigDecimal bigDecimal = productPrice.setScale(2, BigDecimal.ROUND_DOWN);

        System.out.println(bigDecimal);
    }

}
