package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sunxian
 * @version 2022-06-17 11:19
 */
@TableName("sys_user")
@Data
public class User implements Animal {
    private Long id;
    private String name;
    private String username ;
}
