package com.cmqSystem.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 **/
@ToString
@Data
@Component // 加入容器中
@ConfigurationProperties(prefix = "mycar") // 属性绑定
public class Car {

    private String brand;
    private Integer price;
}
