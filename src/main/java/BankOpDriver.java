

import java.util.Scanner;

import com.revature.dao.UserDaoDatabase;
import com.revature.dao.UserDataAccessObject;
import com.revature.exceptions.NegativeAmountException;
import com.revature.exceptions.OverdrawnException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.UserService;

public class BankOpDriver {
	
	private static UserDataAccessObject uDAO = new UserDaoDatabase();
	private static UserService uServ = new UserService(uDAO);

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Returning or New User?");
		
		boolean logStatus = false;
		User u = null;
		double amount = 0.0;
		
		while (logStatus == false) {
			System.out.println("Enter 1 to LOGIN / Enter 2 to SignUp");
			int option = Integer.parseInt(input.nextLine());
				if (option == 1) {
					System.out.println("Enter USERNAME");
					String username = input.nextLine();
					System.out.println("Enter PASSWORD");
					String password = input.nextLine();
					
					try {
						u = uServ.signIn(username, password);
						logStatus = true;
						break;
					}
					catch(Exception e){
						e.printStackTrace();
						System.out.println("The username or password was incorrect");
					}
				}
				else if(option == 2) {
					System.out.println("Enter your desired USERNAME");
					String username = input.nextLine();
					System.out.println("Enter your desired PASSWORD");
					String password = input.nextLine();
					System.out.println("Please enter your email: ");
					String personalInformation = input.nextLine();
					System.out.println("Enter your initial deposit amount:\n(Only 2 decimal values allowed) ");
					Double balance = Double.parseDouble(input.nextLine());
					
					try {
						u = uServ.signUp(username, password, personalInformation, balance);
						System.out.println("The account for the user "+username+" was successfully created");
					}
					catch(Exception e){
						e.printStackTrace();
						System.out.println("This username already exists");
					}
					
				}
				else {
					System.out.println("Please enter a valid option");
				}		
		}
		
			while (logStatus == true) {
				System.out.println("You are now logged in as "+u.getUsername());
				System.out.println("Would you like to WITHDRAW(1) , DEPOSIT(2) , TRANSFER(3) , LOGOUT(4)");
				int option = Integer.parseInt(input.nextLine());
				if (option == 1) {
					System.out.println("Enter the amount you would like to withdraw");
					try {
						amount = Double.parseDouble(input.nextLine());
						u = uServ.withdraw(u.getUsername(),amount);
						System.out.println("$"+u.getBalance()+" remains in your account");
					}
					catch(Exception e){
						e.printStackTrace();
						System.out.println("You can NOT take more than what you own");
					}
				}
				else if (option == 2) {
					System.out.println("Enter the amount you would like to deposit");
				
							amount = Double.parseDouble(input.nextLine());
							u = uServ.deposit(u.getUsername(), amount);
							System.out.println("$"+u.getBalance()+" is now in your account");
					
				}
				else if (option == 3) {
					System.out.println("Enter the account username you would like to transefer to: ");
					String username;
					
					try {
						username = input.nextLine();
						u = uServ.transfer(u.getUsername());
						System.out.println("$"+u.getBalance()+" was removed from your account and sent to "+u.getUsername());
					}
					catch(UserNotFoundException e){
						e.printStackTrace();
						System.out.println("You can NOT take more than what you own");
					}
					
					System.out.println("Enter the amount you would like transfer: ");
					amount = Double.parseDouble(input.nextLine());
				}
				else if (option == 4) {
					System.out.println("Goodbye");
					logStatus = false;
				}
				else {
					System.out.println("Please enter a valid number");
				}
			}
	}
}
					
					/*										OLD CODE
					System.out.println("Enter USERNAME");
					String username = input.nextLine();
					System.out.println("Enter PASSWORD");
					String password = input.nextLine();
					System.out.println("Please select Account Type");
					System.out.println("Enter 1 for Savings / Enter 2 for Checking");
					int option2 = Integer.parseInt(account.nextLine());
						if (option2 == 1) {
							accountInfo  = "Savings Account";
							System.out.println("Savings Account");
						}
						else if (option2 == 2) {
							accountInfo  = "Checking Account";
						}
						else {
							System.out.println("Please Enter a valid number");
							continue;
						}
					System.out.println("How much money will you deposit?(Only two decimal values are allowed)\nEnter Amount: ");
					double balance = Double.parseDouble(input.nextLine());
					System.out.println("Current Balance: $"+balance);
					
					System.out.println("Please enter your full name: ");
					String personalInformation = input.nextLine();
					
					System.out.println("The Following account was created successfully: "+username+","+password+","+accountInfo+","+balance+","+personalInformation);
					*/

/*	This is how you set and read from the User class

User tester = new User("tester","password123");
System.out.println(tester);
*/	
























