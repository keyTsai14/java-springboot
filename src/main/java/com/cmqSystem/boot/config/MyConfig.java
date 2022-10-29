package com.cmqSystem.boot.config;

import ch.qos.logback.classic.db.DBHelper;
import com.cmqSystem.boot.bean.Pet;
import com.cmqSystem.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author key
 * @description
 * @create: 2022-10-15 16:56
 */


/**
 * 1 配置类里面使用@Bean标注在方法上给的容器注册组件，默认也是单实例的
 * 2 配置类本身也是组件
 * 3 proxyBeanMethods：代理Bean的方法
 *      Full(proxyBeanMethods = true)【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *
 * 4 @Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 **/
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false) // 告诉SpringBoot这是一个配置类 == 配置文件
public class MyConfig {


    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例
     **/
    @Bean // 给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型。返回值，就是组件在容器中的事例
    public User user01() {
        User abby = new User("Abby", 18);
        // user 组件依赖了Pet组件
        abby.setPet(tomcatPet());
        return abby;
    }

    @Bean("tom")
    public Pet tomcatPet() {

        return new Pet("tomcat");
    }

}
