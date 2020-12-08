package com.example.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class RunAtStart {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public RunAtStart(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        super();
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @PostConstruct
    public void runAtStart(){

        Department department = new Department();
        department.setDeptName("Sales");
        department.setJob("Manager");
        departmentRepository.save(department);

        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setFirstName("Jan");
        employee.setLastName("Kowalski");
        employee.setSalary(new BigDecimal("3000"));
        employee.setEmploymentDate(LocalDate.of(2019, 05, 8));

        employeeRepository.save(employee);

        //Iterable<Employee> jans = employeeRepository.findByFirstName("Jan");
//        Iterable<Employee> em = employeeRepository.findAllWhereName("K%");
//        for (Employee e: em){
//            System.out.println(e);
//        }
        Iterable<Department> emDept = departmentRepository.findByDept("Sales");
        for (Department d: emDept){
            System.out.println(d);
        }

//        for (Employee e: jans) {
//            System.out.println("Janek: " + e);
//        }
//
//        Iterable<Employee> allEmployees = employeeRepository.findAll();
//        for (Employee e: allEmployees){
//            System.out.println("Employee: " + e);
//        }
    }
}
