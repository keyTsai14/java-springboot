package com.cmqSystem.boot;

import com.cmqSystem.boot.bean.Pet;
import com.cmqSystem.boot.bean.User;
import com.cmqSystem.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author key
 * @description @SpringBootApplication：这个是一个SpringBoot应用
 * */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        // 1. 返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 2. 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        // 3、从容器中获取组件,注册的是组件默认是单实例
        Pet tom = run.getBean("tom", Pet.class);
        Pet tom01 = tom;
        Pet tom02 = tom;

        // 验证单实例
        System.out.println("组件："+(tom01==tom02));

        // 容器获取配置类 com.cmqSystem.boot.config.MyConfig$$EnhancerBySpringCGLIB$$7b93b59@2c7106d9
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        // @Configuration(proxyBeanMethods = true) 代理对象调用方法。springboot总会检查这个组件是否在容器中存在
        // 保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();

        System.out.println(user==user1);

        User user01 = run.getBean("user01", User.class);
        System.out.println("用户的宠物："+(tom== user01.getPet()));


    }
}
