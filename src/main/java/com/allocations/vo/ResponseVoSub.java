package com.allocations.vo;

import com.allocations.model.Employee;
import com.allocations.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVoSub {
    // Single Project with Multiple Employees
    private Project project;
    private String employeeDetails;
    private Set<Employee> employees;
}