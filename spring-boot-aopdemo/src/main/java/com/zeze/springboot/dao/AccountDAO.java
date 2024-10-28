package com.zeze.springboot.dao;

import com.zeze.springboot.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);
    void doWork();
}
