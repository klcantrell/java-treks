package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Riding Hood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employees 30 and under", employee -> employee.getAge() <= 30);
        printEmployeesByAge(employees, "Employees under 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        //specifically typed predicate
        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a + 5));

        // chaining predicates
        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));

        // supplier
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

        Function<Employee, String> getLastName = employee -> employee.getName().split(" ")[1];
        String testGetLastName = getLastName.apply(employees.get(2));

        Function<Employee, String> getFirstName = employee -> employee.getName().split(" ")[0];

        employees.forEach(employee -> {
            String lastName = employee.getName().split(" ")[1];
            System.out.println("Last name is: " + lastName);
        });

        Random anotherRandom = new Random();
        for (Employee employee : employees) {
            if (anotherRandom.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        System.out.println("\nFunction composition");
        // function composition
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> extractFirstName = name -> name.split(" ")[0];
        Function<Employee, String> getUpperCasedFirstName = upperCase.andThen(extractFirstName);
        System.out.println(getUpperCasedFirstName.apply(employees.get(4)));

        BiFunction<String, Employee, String> concatAge = (name, employee) -> name.concat(" " + employee.getAge());
        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        // unary operator (specific function interfaces) that take in and return the same type
        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("=================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
