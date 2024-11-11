package com.zeze.springboot.dao;

import com.zeze.springboot.Account;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + ": getName");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(getClass());
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass());
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        findAccounts(false);
        return null;
    }

    @Override
    public void findAccounts(boolean tripWire) {
        if (tripWire){
            throw new RuntimeException("haha");
        }
        List<Account> myAccount = new ArrayList<>();
        Account temp1 = new Account("Ruize", "1");
        Account temp2 = new Account("Zeze", "2");
        Account temp3 = new Account("Zhang", "3");
        myAccount.add(temp1);
        myAccount.add(temp2);
        myAccount.add(temp3);
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": addAccount");
    }

    @Override
    public void doWork() {
        System.out.println(getClass() + ": doWork");
    }

}
