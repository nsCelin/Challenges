package com.treesetLogic;

import java.util.TreeSet;

/*Details of Employee*/
public class EmployeeDetails {

	public static void main(String[] args) {
		
        System.out.println("Age Comparison of the employees");
        
		TreeSet<Employee> lastNameComp = new TreeSet<Employee>(new AgeComparator());
		lastNameComp.add(new Employee("John","Paul", 27));
		lastNameComp.add(new Employee("Francis","Pierce", 34));
		lastNameComp.add(new Employee("Crish","Thomson", 36));
		lastNameComp.add(new Employee("Tom","Brooke",29));
        for(Employee e:lastNameComp){
            System.out.println(e);
        }

        System.out.println("===========================");
        System.out.println("Last Name Comparison of the employees");
        
        TreeSet<Employee> ageComp = new TreeSet<Employee>(new LastNameComparator());
        ageComp.add(new Employee("John","Paul", 27));
        ageComp.add(new Employee("Francis","Pierce", 34));
        ageComp.add(new Employee("Crish","Thomson", 36));
        ageComp.add(new Employee("Tom","Brooke",29));
        for(Employee e:ageComp){
            System.out.println(e);
        }

	}

}
