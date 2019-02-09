package com.app;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    new Thread(() -> {
            System.out.println("Printing from the Runnable");
            System.out.println("Line 2");
            System.out.println("This is line 3");
        }).start();

	    Employee john = new Employee("John Doe", 30);
	    Employee tim = new Employee("Tim Buchalka", 21);
	    Employee jack = new Employee("Jack Hill", 40);
	    Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        // effectively final employee for each iteration
//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
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

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
          // with an anonymous class
//        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is " + getClass().getSimpleName());
//                return s1.toUpperCase() + " " + s2.toUpperCase();
//            }
//        }, "String 1", "String 2");

        // must be effectively final if used in a lambda
         int i = 0;

        // with a lambda
        System.out.println("AnotherClass class's name is " + getClass().getSimpleName());
        return Main.doStringStuff((s1, s2) -> {
            // lambda has the same name because it is treated like it has the same scope that a nested block of code would
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            System.out.println("i in the lambda = " + i);
            return s1.toUpperCase() + " " + s2.toUpperCase();
        }, "String 1", "String 2");





        // needs to be final because anonymous classes that get passed around can't reference a variable that may change (won't see the change).
        // think of it like java doesn't have closures (it actually does but needs specific conditions)
//        final int i = 0;

//        // nested block example without a lambda
//        {
//            UpperConcat uc = new UpperConcat() {
//                @Override
//                public String upperAndConcat(String s1, String s2) {
//                    System.out.println("i within anonymous class = " + i);
//                    return s1.toUpperCase() + " " + s2.toUpperCase();
//                }
//            };
//            // i++;
//            System.out.println("i = " + i);
//            System.out.println("Another class's name is " + getClass().getSimpleName());
//            return Main.doStringStuff(uc, "String 1", "String 2");
//        }

    }

    public void printValue() {
        // effectively final so that lambda can grab onto the final and execute with it once it runs
        int number = 25;
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the value is " + number);
        };

        new Thread(r).start();
    }
}