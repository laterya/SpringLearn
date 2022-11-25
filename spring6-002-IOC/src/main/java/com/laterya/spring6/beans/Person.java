package com.laterya.spring6.beans;

import java.util.Arrays;

public class Person {
    private String[] foods;

    public void setFoods(String[] foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Person{" +
                "foods=" + Arrays.toString(foods) +
                '}';
    }
}
