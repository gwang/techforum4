package com.gwang.techforum4.models;

/**
 * Created with IntelliJ IDEA.
 * User: gwang2
 * Date: 11/1/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private String name;
    private int    age;
    private int    candy;

    public Person(String name, int age, int candy)
    {
        this.name  = name;
        this.age   = age;
        this.candy = candy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCandy() {
        return candy;
    }

    public void setCandy(int candy) {
        this.candy = candy;
    }
}
