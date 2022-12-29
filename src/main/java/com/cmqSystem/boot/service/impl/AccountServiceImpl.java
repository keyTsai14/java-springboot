package com.cmqSystem.boot.service.impl;

import com.cmqSystem.boot.bean.Account;
import com.cmqSystem.boot.mapper.AccountMapper;
import com.cmqSystem.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author key
 * @description
 * @create: 2022-12-28 23:09
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Account getAcct(Long id) {
        return accountMapper.getAcct(id);
    }
}
