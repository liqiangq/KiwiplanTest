package com.kiwiplan.recruitment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Aaron Li 
 * 
 * @classs Employee  Entity
 * @field: 
 *   int id 
 *   int managerId 
 *   String name
 * @date: 11/03/2021
 */

public class Employee {
	private int id;
	private int managerId;
	private String name;
	private boolean sorted = false;
	private List<Employee> managerList = new ArrayList<Employee>();

	public Employee(int id, int managerId, String name) {
		this.id = id;
		this.managerId = managerId;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public int getManagerId() {
		return this.managerId;
	}

	public String getName() {
		return this.name;
	}

	public boolean isRoot() {
		if (this.managerId == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isManager() {
		if (this.managerList.size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void addEmployee(Employee p) {
		this.managerList.add(p);
	}

	public void setSort(boolean sorted) {
		this.sorted = sorted;
	}

	private void sort() {
		this.managerList.sort(Comparator.comparing(Employee::getName));
	}

	public List<Employee> getList() {
		if (this.sorted) {
			this.sort();
		}
		return this.managerList;
	}

}
