package pojo.bean;

import pojo.Employee;

public class EmployeeInformationBean {
    private Employee employee;
    private String email;

    public EmployeeInformationBean() {
    }

    public EmployeeInformationBean(Employee employee, String email) {
        this.employee = employee;
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployeeInformationBean{" +
                "employee=" + employee +
                ", email='" + email + '\'' +
                '}';
    }
}
