package com.cmqSystem.boot;

import com.cmqSystem.boot.bean.User;
import com.cmqSystem.boot.mapper.UserMapper;
import com.cmqSystem.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

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

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;


    @Test
    void contextLoads() {

        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        log.info("记录总数：{}",aLong);

        log.info("数据源类型：{}",dataSource.getClass());
    }

    @Test
    void testUserMapper() {
        User user = userMapper.selectById(1L);

        List<User> list = userService.list();

        log.info("用户信息：{}",user);
        log.info("用户信息s：{}",list);
    }
}
