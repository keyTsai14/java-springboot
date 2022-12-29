package com.cmqSystem.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmqSystem.boot.bean.User;
import com.cmqSystem.boot.mapper.UserMapper;
import com.cmqSystem.boot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author key
 * @description
 * @create: 2022-12-29 12:07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
