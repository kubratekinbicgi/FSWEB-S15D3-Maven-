package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicatedEmployess;

    public static void main(String[] args) {

        LinkedList<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(1, "Kübra", "Tekin Biçgi"));
        employeeList.add(new Employee(1, "Kübra", "Tekin Biçgi"));
        employeeList.add(new Employee(2, "Doruk", "Biçgi"));
        employeeList.add(new Employee(3, "Ege", "Biçgi"));
        employeeList.add(new Employee(3, "Ege", "Biçgi"));
        employeeList.add(new Employee(4, "Hatice", "Tekin"));
        employeeList.add(new Employee(5, "Süleyman", "Tekin"));
        employeeList.add(new Employee(6, "Çiğdem", "Biçgi"));
        employeeList.add(new Employee(7, "Okan", "Biçgi"));
        employeeList.add(new Employee(8, "Buket", "Tekin"));

        System.out.println(findDuplicates(employeeList));
        System.out.println(findUniques(employeeList));
        System.out.println(removeDuplicates(employeeList));

        System.out.println("************************");

        System.out.println(WordCounter.calculatedWord());

    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        employeeMap = new HashMap<>();
        duplicatedEmployess = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())) {
                duplicatedEmployess.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }

        return duplicatedEmployess;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put((employee.getId()), employee);
            }
        }
            return  employeeMap;
    }
    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates =   findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }

}

