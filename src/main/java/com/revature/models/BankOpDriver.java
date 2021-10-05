package com.revature.models;

import java.util.Scanner;
import com.revature.functions.UserFunctions;

public class BankOpDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Returning or New User?");
		
		User logStatus = null;
		
		while (logStatus == null) {
			System.out.println("Enter 1 to LOGIN / Enter 2 to SignUp");
			int option = Integer.parseInt(input.nextLine());
				if (option == 1) {
					System.out.println("Enter USERNAME");
					String username = input.nextLine();
					System.out.println("Enter PASSWORD");
					String password = input.nextLine();
					
					System.out.println(username+" "+password);
				}
				else if(option == 2) {
					System.out.println("Option 2 working correctly");
				}
				else {
					System.out.println("Please enter a valid option");
				}
		}
		
	}
}

/*	This is how you set and read from the User class

User tester = new User("tester","password123");
System.out.println(tester);
*/	