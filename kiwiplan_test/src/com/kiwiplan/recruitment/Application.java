package com.kiwiplan.recruitment;

import java.util.Scanner;

/**
 * @author Aaron Li The main class for the employment management tree exercise
 * 
 * input the employees information and print the employees tree
 * input  ID  ManagerID name
 * end id empty input
 * @date: 11/03/2021
 */
public class Application {

	private static Scanner reader;

	public static void main(String[] args) {
		System.out.println("===========================");
		System.out.println("Please Input employee data like:\nID Name ManagerId\nEnd with empty input");
		System.out.println("===========================");
		
		reader = new Scanner(System.in);
		Management management = new Management(true);
		String input = reader.nextLine();
		String[] param = null;

		while (!input.equals("")) {
			param = input.split(" ");
			if (param.length == 3) {
				if (!management.addEmployee(new Employee(Integer.parseInt(param[0]), Integer.parseInt(param[2]), param[1]))) {
					   System.out.println("Duplicate id input!");
				}
			} else {
				      System.out.println("Error input!");
			}
			input = reader.nextLine();
		}

		System.out.println("***************************");
		System.out.println("The result of the input by alphabet order ");
		System.out.println("***************************");
		management.displayManagementTree();
		System.out.println("***************************");
		System.out.println("Aaron finished the test, thank you");
		System.out.println("***************************");

	}
}
