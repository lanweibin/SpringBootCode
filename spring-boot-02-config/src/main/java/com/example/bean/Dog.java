package com.example.bean;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2019-11-21 22:00
 **/
public class Dog {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
