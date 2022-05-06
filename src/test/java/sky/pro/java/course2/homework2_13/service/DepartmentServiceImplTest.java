package sky.pro.java.course2.homework2_13.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.java.course2.homework2_13.exceptions.BadRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static sky.pro.java.course2.homework2_13.constant.EmployeeServiceTestConstants.STAFF_OF_EMPLOYEE_TEST;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldThrowExceptionWhenDepartmentIdIsIncorrect() {
        assertThrows(BadRequest.class, () -> out.maxSalaryofDepartment(8));
    }

    @Test
    public void shouldReturnEmployeeWithMaxSalaryOfDepartment() {
        when(employeeServiceMock.getStaffOfEmployee()).thenReturn(STAFF_OF_EMPLOYEE_TEST);
        assertEquals("В отделе Руководство самую высокую зарплату получает " +
                "Optional[Петров Юрий, отдел: 0, заработная плата - 200000.0 руб.].",
                out.maxSalaryofDepartment(0));
    }

    @Test
    public void shouldReturnEmployeeWithMinSalaryOfDepartment() {
        when(employeeServiceMock.getStaffOfEmployee()).thenReturn(STAFF_OF_EMPLOYEE_TEST);
        assertEquals("В отделе Бухгалтерия самую низкую зарплату получает " +
                        "Optional[Ким Мария, отдел: 1, заработная плата - 150000.0 руб.].",
                out.minSalaryofDepartment(1));
    }

    @Test
    public void shouldPrintStaffOfDepartment() {
        when(employeeServiceMock.getStaffOfEmployee()).thenReturn(STAFF_OF_EMPLOYEE_TEST);
        assertEquals("В отделе Отдел кадров работают следующие " +
                        "сотрудники: [Мансурова Амира, Шевченко Ирина].",
                out.printStaffOfDepartment(2));
    }

    @Test
    public void shouldPrintAllStaffByDepartments() {
        when(employeeServiceMock.getStaffOfEmployee()).thenReturn(STAFF_OF_EMPLOYEE_TEST);
        assertEquals("Список всех сотрудников: В отделе Руководство работают следующие " +
                        "сотрудники: [Петров Юрий, Якобсон Иосиф].В отделе Бухгалтерия работают " +
                        "следующие сотрудники: [Стивен Джексон, Ким Мария].В отделе Отдел кадров " +
                        "работают следующие сотрудники: [Мансурова Амира, Шевченко Ирина]." +
                        "В отделе Технический отдел работают следующие сотрудники: " +
                        "[Дорошенко Матвей, Абдуллаев Бахром, Яцехиро Анимото].",
                out.printAllStaff());
    }
}