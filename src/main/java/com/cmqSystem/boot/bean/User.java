package com.cmqSystem.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author key
 * @description
 * @create: 2022-10-15 16:59
 */
@Data
//@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {

    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;

    private Long id;
    private String name;
//    private Integer age;

//    private Pet pet;
//
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
