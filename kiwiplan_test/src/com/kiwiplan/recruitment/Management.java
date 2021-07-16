package com.kiwiplan.recruitment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author Aaron Li 
 * @classs Management
 * @method: 
        addEmployee(Employee)
 *      sortRelationship()
 *      displayManagementTree()
 *      checkManager()
 * @date: 11/03/2021
 */
public class Management {

	private List<Employee> employeeList = new ArrayList<Employee>();
	private HashMap<Integer, Employee> list = new HashMap<Integer, Employee>();
	private boolean sorted = false;
	private int rootid;

	/**
	 *  New the Management add the sorted status
	 * @param sorted
	 */
	public Management(boolean sorted) {
		this.sorted = sorted;
	}
    /**
     * Add employee to employlist
     * @param employee
     * @return
     */
	public boolean addEmployee(Employee employee) {
		if (!this.list.containsKey(employee.getId())) {
			employee.setSort(this.sorted);
			this.employeeList.add(employee);
			this.list.put(employee.getId(), employee);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Sort the employeeList
	 */
	private void sortRelationship() {
		if (this.sorted) {
			this.employeeList.sort(Comparator.comparing(Employee::getManagerId).reversed());
		}

		for (Employee p : this.employeeList) {
			if (!p.isRoot()) {
				if (this.list.containsKey(p.getManagerId())) {
					this.list.get(p.getManagerId()).addEmployee(this.list.get(p.getId()));
				}
			} else {
				this.rootid = p.getId();
			}
		}
	}

	  /**
	   * Displays employees in a logical tree.
	   */
	public void displayManagementTree() {
		this.sortRelationship();
	    System.out.println("Print ManagementTree:::");
		System.out.println("============================");
		this.checkManager("->", this.list.get(this.rootid));
		System.out.println("============================\n");
	}

/**
 * Check the employee is the manager role
 * @param arrow
 * @param employee
 */
	private void checkManager(String arrow, Employee employee) {
		if (employee.isManager()) {
			System.out.println(arrow + employee.getName());
			for (Employee e1 : employee.getList()) {
				this.checkManager(arrow + "->", e1);
			}
		} else {
			System.out.println(arrow + employee.getName());
		}
	}
	
	public static void main(String[] args) {
		Management management = new Management(true);
		management.addEmployee(new Employee(10, 0, "Tom"));
		management.addEmployee(new Employee(2, 10, "Mickey"));
		management.addEmployee(new Employee(3, 10, "Jerry"));
		management.addEmployee(new Employee(7, 2, "John"));
		management.addEmployee(new Employee(5, 10, "Sarah"));
		management.displayManagementTree();
	}
}
