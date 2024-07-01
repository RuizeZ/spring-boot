package com.zeze.springboot.rest.recurity.dao;

import com.zeze.springboot.rest.recurity.entity.EmployeeSecurity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSecurityRepository extends JpaRepository<EmployeeSecurity, Integer> {
}
