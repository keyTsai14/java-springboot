package com.cmqSystem.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/12/14
 **/
//@ConfigurationProperties(prefix = "person")
@Component
@ToString
@Data
public class Person {

    private String userName;
//    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
//    private String[]interests;
//    private List<String> animal;
//    private Map<String,Object> score;
//    private Set<Double> salarys;
//    private Map<String,List<Pet>>allPets;
}
