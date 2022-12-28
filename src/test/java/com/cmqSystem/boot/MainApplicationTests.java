package com.cmqSystem.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author key
 * @description
 * @create: 2022-12-28 11:20
 */

@Slf4j
@SpringBootTest
public class MainApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    void contextLoads() {

        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        log.info("记录总数：{}",aLong);
    }
}
