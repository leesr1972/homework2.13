package sky.pro.java.course2.homework2_13.service;

import sky.pro.java.course2.homework2_13.data.Employee;

import java.util.Map;

public interface EmployeeService {

    Map<String, Employee> getStaffOfEmployee();
    Employee addEmployee(String lastName, String firstName, Float salary, Integer departmentId);
    Employee dismissEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    String getAllStaff();
    String calculateAllSalaries();

}
