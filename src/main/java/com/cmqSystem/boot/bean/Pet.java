package com.cmqSystem.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author key
 * @description
 * @create: 2022-10-15 16:59
 */
@Data
@ToString
@NoArgsConstructor // 无参构造器
@AllArgsConstructor // 有参构造器
public class Pet {

    private String name;
}
