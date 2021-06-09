package com.kxj.stream;

import lombok.Data;

/**
 * @author xiangjin.kong
 * @date 2021/6/9 16:13
 */
@Data
public class Tuple {
    // 是否含素食
    private final boolean vegetarian;
    // 卡路里
    private final Double calories;
}
