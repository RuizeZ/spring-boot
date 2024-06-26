package com.zeze.springboot.dao;

import com.zeze.springboot.entity.EmployeeJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPARepository extends JpaRepository<EmployeeJPA, Integer> {

}
