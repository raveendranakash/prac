package com.java.collections;

public class Employee {

	private String name;
	private Integer empId;
	private Long salary;
	
	public Employee(String name, Integer id, Long salary) {
		this.empId = id;
		this.salary = salary;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
}
