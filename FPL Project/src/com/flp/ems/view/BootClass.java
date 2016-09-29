package com.flp.ems.view;

import java.util.Scanner;

public class BootClass {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
				
		System.out.println("Employee Management System");
		System.out.println("1.Add Employee\n2.Modify Employee\n3.Remove Employee\n4.Search Employee\n5.Display all Employee");
		System.out.println("Enter choice: ");
		int choice = input.nextInt();
		
		switch(choice){
			case 1 : UserInteraction.addEmployee();
					 break;
			case 2 : UserInteraction.modifyEmployee();
			 		 break;
			case 3 : UserInteraction.removeEmployee();
	 		 		 break;
			case 4 : UserInteraction.searchEmployee();
	 		 		 break;
			case 5 : UserInteraction.getAllEmployee();
					 break;
			default : System.out.println("Inavlid choice.");
		}
	}
}
