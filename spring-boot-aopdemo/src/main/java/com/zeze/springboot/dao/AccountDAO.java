package com.zeze.springboot.dao;

import com.zeze.springboot.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);
    void doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    List<Account> findAccounts();

    void findAccounts(boolean tripWire);
}
