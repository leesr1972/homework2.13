package sky.pro.java.course2.homework2_13.service;

import org.junit.jupiter.api.Test;
import sky.pro.java.course2.homework2_13.data.Employee;
import sky.pro.java.course2.homework2_13.exceptions.BadRequest;
import sky.pro.java.course2.homework2_13.exceptions.NotFound;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

import static sky.pro.java.course2.homework2_13.constant.EmployeeServiceTestConstants.*;

class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void shouldFindEmployee() {
        assertEquals(EMPLOYEE_TEST, out.findEmployee(LAST_NAME_TEST, FIRST_NAME_TEST));
    }

    @Test
    public void shouldThrowExceptionWhenEmployeeNotFound() {
        assertThrows(BadRequest.class, () -> out.findEmployee("Иванов", "Иван"));
    }

    @Test
    public void shouldReturnAddedEmployee() {
        Employee addedEmployee = new Employee("Иванов", "Иван",
                200_000f, 0);
        assertEquals(addedEmployee, out.addEmployee("Иванов", "Иван",
                200_000f, 0));
    }

    @Test
    public void shouldThrowExceptionWhenAddedEmployeeAlreadyExist() {
        assertThrows(BadRequest.class, () -> out.addEmployee("Петров", "Юрий",
                200_000f, 0));
    }

    @Test
    public void shouldReturnDismissedEmployee() {
        assertEquals(EMPLOYEE_TEST, out.dismissEmployee(LAST_NAME_TEST, FIRST_NAME_TEST));
    }

    @Test
    public void shouldThrowExceptionWhenDismissedEmployeeNotFound() {
        assertThrows(NotFound.class, ()->out.dismissEmployee("Иванов", "Иван"));
    }

    @Test
    public void shouldReturnAllEmployees() {
        assertEquals("Список сотрудников: " + STAFF_OF_EMPLOYEE_TEST.values().stream().
                map(employee -> employee.getLastName() + " " + employee.getFirstName()).
                collect(Collectors.toList()), out.getAllStaff());
    }

    @Test
    public void shouldcalculateAllSalaries() {
        assertEquals("Фонд оплаты труда составляет 1410000.0 руб.", out.calculateAllSalaries());
    }
}