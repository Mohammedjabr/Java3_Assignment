/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass1;

import java.util.Scanner;

/**
 *
 * @author MOH
 */
public class Main_Scanner {
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Employee employees[] = new Employee[2];
        readByScanner(employees);
        sortBySalary(employees);
        addBonusToAll(employees, 2);
        showInCommandLine(employees);
    }
    
    /////////////////////////////////////////////////////////////////
     private static void sortBySalary(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                if (employees[j].getSalary() > employees[i].getSalary()) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }
   ////////////////////////////////////////////////////////////////////
    private static void sortByName(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                int compare = employees[j].getName().compareTo(employees[i].getName());
                if (compare < 0) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }
    
    //////////////////////////////////////////////////////////////////
     private static void readByScanner(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter Data...");
            Employee emp = new Employee();

            //name input
            System.out.print("Enter the name : ");
            emp.setName(s.nextLine());
            //departnment input
            System.out.print("Enter the Department : ");
            emp.setDepartment(s.nextLine());
            //salary input
            System.out.print("Enter hte salary : ");
            emp.setSalary(Integer.parseInt(s.nextLine()));

            employees[i] = emp;
        }
}
     //////////////////////////////////////////////////////////////
      private static void showInCommandLine(Employee[] employees) {
        System.out.println("==================");
        System.out.printf("%-9s%-15s%-13s\n", "Name", "Department", "Salary");
        for (Employee employee : employees) {
            System.out.printf("%-9s%-15s%-10.2f\n",
                    employee.getName(),
                    employee.getDepartment(),
                    employee.getSalary());
        }
        System.out.println("Number Of Employee is : " + Employee.count);
    }
      ////////////////////////////////////////////////////////////////
      private static void addBonusToAll(Employee[] employees, double bonus) {
        for (int i = 0; i < employees.length; i++) {
            double salary = employees[i].getSalary();
            employees[i].setSalary(salary, bonus);
        }
}
}