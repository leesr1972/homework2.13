package sky.pro.java.course2.homework2_13.service;

import org.springframework.stereotype.Service;
import sky.pro.java.course2.homework2_13.data.Employee;
import sky.pro.java.course2.homework2_13.exceptions.BadRequest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    private final List<String> departments = new ArrayList<>(List.of("Руководство", "Бухгалтерия",
            "Отдел кадров", "Технический отдел"));


    @Override
    public String maxSalaryofDepartment(Integer departmentId) {
        if (departmentId < 0 || departmentId > departments.size() - 1) {
            throw new BadRequest();
        }
        Optional<Employee> employeesWithMaxSalary = employeeService.getStaffOfEmployee().values().stream().
                filter(e -> e.getDepartmentId() == departmentId).
                max(Comparator.comparingDouble(employee -> employee.getSalary()));
        return "В отделе " + departments.get(departmentId) + " самую высокую зарплату получает "
                + employeesWithMaxSalary.map(Employee::toString) + ".";
    }

    @Override
    public String minSalaryofDepartment(Integer departmentId) {
        if (departmentId < 0 || departmentId > departments.size() - 1) {
            throw new BadRequest();
        }
        Optional<Employee> employeesWithMinSalary = employeeService.getStaffOfEmployee().values().stream().
                filter(e -> e.getDepartmentId() == departmentId).
                min(Comparator.comparingDouble(employee -> employee.getSalary()));
        return "В отделе " + departments.get(departmentId) + " самую низкую зарплату получает "
                + employeesWithMinSalary.map(Employee::toString) + ".";
    }

    @Override
    public String printStaffOfDepartment(Integer departmentId) {
        if (departmentId < 0 || departmentId > departments.size() - 1) {
            throw new BadRequest();
        }
        List<String> staffOfDepartment = employeeService.getStaffOfEmployee().values().stream().
                filter(e -> e.getDepartmentId() == departmentId).
                map(employee -> employee.getLastName() + " " + employee.getFirstName()).
                collect(Collectors.toList());
        return "В отделе " + departments.get(departmentId) + " работают следующие сотрудники: "
                + staffOfDepartment + ".";
    }

    @Override
    public String printAllStaff() {
        String allStaff = "Список всех сотрудников: ";
        for (int i = 0; i < departments.size(); i++) {
            allStaff = allStaff + printStaffOfDepartment(i);
        }
        return allStaff;
    }
}
