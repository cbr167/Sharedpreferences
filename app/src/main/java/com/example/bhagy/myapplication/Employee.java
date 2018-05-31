package com.example.bhagy.myapplication;

/**
 * Created by bhagy on 5/30/2018.
 */

public class Employee {

    private String employee;
    private int salary;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String employee, int salary) {
        this.employee = employee;
        this.salary = salary;


    }
}
