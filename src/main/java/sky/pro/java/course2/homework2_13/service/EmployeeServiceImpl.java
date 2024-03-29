package sky.pro.java.course2.homework2_13.service;

import org.springframework.stereotype.Service;
import sky.pro.java.course2.homework2_13.data.Employee;
import sky.pro.java.course2.homework2_13.exceptions.BadRequest;
import sky.pro.java.course2.homework2_13.exceptions.NotFound;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static Map<String, Employee> staffOfEmployee = new HashMap<>(Map.of(
            "ПетровЮрий", new Employee("Петров", "Юрий", 200_000f, 0),
            "ЯкобсонИосиф", new Employee("Якобсон", "Иосиф", 180_000f, 0),
            "СтивенДжексон", new Employee("Стивен", "Джексон", 180_000f, 1),
            "КимМария", new Employee("Ким", "Мария", 150_000f, 1),
            "МансуроваАмира", new Employee("Мансурова", "Амира", 150_000f, 2),
            "ШевченкоИрина", new Employee("Шевченко", "Ирина", 120_000f, 2),
            "ЯцехироАнимото", new Employee("Яцехиро", "Анимото", 180_000f, 3),
            "ДорошенкоМатвей", new Employee("Дорошенко", "Матвей", 150_000f, 3),
            "АбдуллаевБахром", new Employee("Абдуллаев", "Бахром", 100_000f, 3)
    ));

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        Employee employee = staffOfEmployee.get(lastName + firstName);
        if (staffOfEmployee.containsKey(lastName + firstName)) {
            return employee;
        } else {
            throw new BadRequest();
        }
    }

    @Override
    public Employee addEmployee(String lastName, String firstName, Float salary, Integer departmentId) {
        Employee newEmployee = new Employee(lastName, firstName, salary, departmentId);
        if (staffOfEmployee.containsKey(lastName + firstName)) {
            throw new BadRequest();
        } else {
            staffOfEmployee.put(lastName + firstName, newEmployee);
            return newEmployee;
        }
    }

    @Override
    public Employee dismissEmployee(String lastName, String firstName) {
        Employee dismissedEmployee = staffOfEmployee.get(lastName + firstName);
        if (staffOfEmployee.containsKey(lastName + firstName)) {
            staffOfEmployee.remove(lastName + firstName, dismissedEmployee);
            return dismissedEmployee;
        } else {
            throw new NotFound();
        }
    }

    @Override
    public String getAllStaff() {
        if (staffOfEmployee.size() == 0) {
            throw new NotFound();
        }
        List<String> allStaff = staffOfEmployee.values().stream().
                map(employee -> employee.getLastName() + " " + employee.getFirstName()).
                collect(Collectors.toList());
        return "Список сотрудников: " + allStaff;
    }

    @Override
    public String calculateAllSalaries() {
        List<Float> listOfSalaries = staffOfEmployee.values().stream()
                .map(e -> e.getSalary())
                .collect(Collectors.toList());
        double wageFund = listOfSalaries.stream().mapToDouble(e->e).sum();
        return "Фонд оплаты труда составляет " + wageFund + " руб.";
    }

    @Override
    public Map<String, Employee> getStaffOfEmployee() {
        return staffOfEmployee;
    }
}
