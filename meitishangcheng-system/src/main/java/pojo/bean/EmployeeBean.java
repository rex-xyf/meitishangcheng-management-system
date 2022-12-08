package pojo.bean;

import pojo.Employee;

import java.util.List;

public class EmployeeBean {
    private List<Employee> employees;
    private int count;

    public EmployeeBean() {
    }

    public EmployeeBean(List<Employee> employees, int count) {
        this.employees = employees;
        this.count = count;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "employees=" + employees +
                ", count=" + count +
                '}';
    }
}
