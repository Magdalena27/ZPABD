package com.example.lab1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

    @Query ("SELECT d FROM Department d WHERE d.deptName LIKE ?1")
    Iterable<Department> findByDept(String deptName);
}
