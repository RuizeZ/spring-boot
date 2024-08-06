package com.zeze.springboot.dao;

import com.zeze.springboot.entity.EmployeeMVC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMVCRepository extends JpaRepository<EmployeeMVC, Integer> {

}
