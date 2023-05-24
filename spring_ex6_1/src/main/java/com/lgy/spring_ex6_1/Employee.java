package com.lgy.spring_ex6_1;

import java.util.ArrayList;

public class Employee {
	private String name;
	private int salary;
	private ArrayList<String> license;

	public Employee(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public ArrayList<String> getLicense() {
		return license;
	}
	public void setLicense(ArrayList<String> license) {
		this.license = license;
	}
}
