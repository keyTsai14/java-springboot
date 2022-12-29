package com.cmqSystem.boot.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author key
 * @description 分页插件
 * @create: 2022-12-29 15:16
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //设置清求的页面大于最大页后操作，true调回到首页，false继续清求默认false
        //paginationInterceptor.setoverflow(false);
        //设置最大单页限制数量，默认5©0条，-1不受限制
        //paginationInterceptor.setLimit(500);
        //开启count的join优化，只针对部分Left join

        //这是分页拦截器
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setOverflow(true);
        paginationInnerInterceptor.setMaxLimit(500L);
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mybatisPlusInterceptor;
    }
}
