package com.employeePayrollSystems;

import java.util.ArrayList;
import java.util.List;

abstract class Employee{
	private String name;
	private int id;
	
	public Employee(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract double calculateSalary();

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id= "+ id +", salary= "+calculateSalary() + "]";
	}
}

//create child class FullTimeEmployee that inherit parent Employee class 

class FullTimeEmployee extends Employee{
	private double monthlySalary;
	
	public FullTimeEmployee(int id,String name,double monthlySalary) {
		super(id,name);
		this.monthlySalary=monthlySalary;
	}
	
	@Override
	public double calculateSalary() {
		return monthlySalary;
	}
}

// create child class PartTimeEmployee that inherit parent Employee class 
class PartTimeEmployee extends Employee{
	private int workTime;
	private int hourlyRate;
	
	public PartTimeEmployee(int id,String name,int workTime, int hourlyRate) {
		super(id,name);
		this.workTime=workTime;
		this.hourlyRate=hourlyRate;
	}
	
	
	@Override
	public double calculateSalary() {
		return workTime * hourlyRate;
	}
}

// Payroll system
class PayRollSystem{
	private List<Employee> empList;
	
	public PayRollSystem() {
		empList= new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		empList.add(employee);
	}
	public void removeEmployee(int id) {
		Employee empRemove=null;
		for(Employee employee : empList) {
			if(employee.getId() == id) {
				empRemove=employee;
				break;
			}
		}
		if(empRemove != null) {
			empList.remove(empRemove);
		}
	}
	
	public void displayEmployee() {
		for(Employee employee : empList) {
			System.out.println(employee);
		}
	}
}

public class Main {

	public static void main(String[] args) {

		PayRollSystem payRollSystem=new PayRollSystem();
		
		FullTimeEmployee emp1 = new FullTimeEmployee(1, "John Doe", 50000.0);
		PartTimeEmployee emp2 = new PartTimeEmployee(2, "Jane Smith", 30, 150);
		
		payRollSystem.addEmployee(emp1);
		payRollSystem.addEmployee(emp2);
		
		System.out.println("Initial Employee Details.");
		payRollSystem.displayEmployee();
		
		System.out.println("\nRemoving Employee.");
		payRollSystem.removeEmployee(2);
		
		System.out.println("\nRemaining Employee.");
		payRollSystem.displayEmployee();
		
	}

}
