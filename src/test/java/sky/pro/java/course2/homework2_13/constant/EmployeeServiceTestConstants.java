package sky.pro.java.course2.homework2_13.constant;

import sky.pro.java.course2.homework2_13.data.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeServiceTestConstants {
    public static final Map<String, Employee> STAFF_OF_EMPLOYEE_TEST = new HashMap<>(Map.of(
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

    public static final Employee EMPLOYEE_TEST = new Employee("Петров", "Юрий",
            200_000f, 0);
    public static final String LAST_NAME_TEST = "Петров";
    public static final String FIRST_NAME_TEST = "Юрий";
}
