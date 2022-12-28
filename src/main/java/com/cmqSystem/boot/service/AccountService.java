package com.cmqSystem.boot.service;

import com.cmqSystem.boot.bean.Account;
import com.cmqSystem.boot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author key
 * @description
 * @create: 2022-12-28 23:09
 */
@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcct(Long id) {
        return accountMapper.getAcct(id);
    }
}
