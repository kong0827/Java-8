package com.kxj.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author xiangjin.kong
 * @date 2021/6/7 15:30
 */
@Data
@ToString
@AllArgsConstructor
public class Dish {
    private String name;
    // 卡路里
    private Double calories;
    // 是否含素食
    private boolean vegetarian;

    public Dish(String name, Double calories) {
        this.name = name;
        this.calories = calories;
    }
}
