package szaq.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NestedCollectionsFiltering {

    @Test
    public void shouldAnswerWithTrue() {
        List<Employee> empList1 = List.of(
            new Employee("John Doe", 60000),
            new Employee("Jane Smith", 75000)
        );
        List<Employee> empList2 = List.of(
            new Employee("Jack White", 50000),
            new Employee("Jill Green", 90000)
        );

        List<Department> departments = List.of(
            new Department("HR", empList1),
            new Department("IT", empList2)
        );

        double salaryThreshold = 65000;

        departments.stream()
            .flatMap(department -> department.getEmployees().stream())
            .filter(employee -> employee.getSalary() > salaryThreshold)
            .forEach(System.out::println);
    }

    @AllArgsConstructor
    @Getter
    @ToString
    private static class Employee {
        private String name;
        private double salary;
    }

    @AllArgsConstructor
    @Getter
    @ToString
    private static class Department {
        private String name;
        private List<Employee> employees;
    }
}
