package com.cmqSystem.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author BananaKey14
 */
@Component
@ConfigurationProperties("person")
public interface Employee {

    String getName();

}
