package com.zeze.springboot.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": addAccount");
    }

    @Override
    public void doWork() {
        System.out.println(getClass() + ": doWork");
    }
}
