package com.example.bhagy.myapplication;

import java.util.Comparator;

/**
 * Created by bhagy on 5/30/2018.
 */

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee, Employee t1) {
        return employee.getEmployee().compareToIgnoreCase(t1.getEmployee());
    }
}
