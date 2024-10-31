package com.zeze.springboot.dao;

import com.zeze.springboot.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);
    void doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
