package com.example.demo.patternDesign.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author sunxian
 * @version 2022-07-01 10:52
 */
@Data
@AllArgsConstructor
public class Man implements Cloneable{


    private String name;
    private String age;
    private String hobby;
    private Date createTime;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Man(String name, String age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }
}
