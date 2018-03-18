package com.treesetLogic;

public class Employee {

	private String FirstName;
	private String LastName;
	private int Age;
	
	public Employee(String FirstName, String LastName,int Age)
	{
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Age = Age;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	public String toString(){
        return "FirstName: "+this.FirstName+" -- Last Name: "+this.LastName + " -- Age: "+this.Age;
    }
}
