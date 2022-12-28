package com.cmqSystem.boot.mapper;

import com.cmqSystem.boot.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface AccountMapper {

    Account getAcct(Long id);
}
