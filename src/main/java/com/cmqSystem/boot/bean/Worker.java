package com.cmqSystem.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author key
 * @description
 * @create: 2022-12-30 16:15
 */
@Profile("test")
@Data
@Component
@ConfigurationProperties("person")
public class Worker implements Employee{
    private String name;
}
