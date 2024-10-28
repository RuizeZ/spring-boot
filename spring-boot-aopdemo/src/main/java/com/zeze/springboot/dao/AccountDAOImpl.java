package com.zeze.springboot.dao;

import com.zeze.springboot.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": addAccount");
    }

    @Override
    public void doWork() {
        System.out.println(getClass() + ": doWork");
    }

}
