package com.zeze.springboot.dao;

import com.zeze.springboot.entity.EmployeeRest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employeeRests")
//@Repository
public interface EmployeeRestRepository extends JpaRepository<EmployeeRest, Integer> {

}
