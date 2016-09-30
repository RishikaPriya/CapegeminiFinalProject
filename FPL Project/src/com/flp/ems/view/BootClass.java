package com.flp.ems.view;

import java.text.ParseException;
import java.util.Scanner;

public class BootClass {
	public static void main(String[] args) throws ParseException {
		
		Scanner input = new Scanner(System.in);
		UserInteraction userInteraction = new UserInteraction();
		
		int choice;
		char ch;
		
		System.out.println("Employee Management System");
		
		do{
			System.out.println("1.Add Employee\n2.Modify Employee\n3.Remove Employee\n4.Search Employee\n5.Display all Employee");
			System.out.println("Enter choice: ");
			choice = input.nextInt();

			switch(choice){
				case 1 : userInteraction.addEmployee();
						 break;
				case 2 : userInteraction.modifyEmployee();
						 break;
				case 3 : userInteraction.removeEmployee();
						 break;
				case 4 : userInteraction.searchEmployee();
						 break;
				case 5 : userInteraction.getAllEmployee();
						 break;
				default : System.out.println("Inavlid choice.");
			}
			System.out.println("Do you want to perform more operation (y/n): ");
			ch = (char) input.next().charAt(0);
		}while(ch=='y' || ch=='Y');
	}
}
