package com.en.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Users
 * @Description some description
 * @Author Jason
 * @Date 2023/1/12 9:48
 */
@Data
public class Users implements Serializable {

    private String name;

    private int age;

    private String sex;

}
