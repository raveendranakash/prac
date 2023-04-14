package com.java.collections;

import java.util.Comparator;

public class CompareEmployee implements Comparable<CompareEmployee> {

	private String name;
	private Integer empId;
	private Long salary;
	
	public CompareEmployee(String name, Integer id, Long salary) {
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

	public int compareTo(CompareEmployee o) {
		return (this.empId - o.empId);
	}
	
	@Override
	public String toString() {
		 return "[id=" + this.empId + ", name=" + this.name +", salary=" + this.salary + "]";
	}
	
	public static Comparator<CompareEmployee> SalaryComparator = new Comparator<CompareEmployee>() {

        public int compare(CompareEmployee e1, CompareEmployee e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };
    
    public static Comparator<CompareEmployee> NameComparator = new Comparator<CompareEmployee>() {

        public int compare(CompareEmployee e1, CompareEmployee e2) {
            return (e1.getName().compareTo(e2.getName()));
        }
    };
    
}
