

import java.util.Scanner;

import com.revature.dao.UserDaoDatabase;
import com.revature.dao.UserDataAccessObject;
import com.revature.models.User;
import com.revature.services.UserService;

public class BankOpDriver {
	
	private static UserDataAccessObject uDAO = new UserDaoDatabase();
	private static UserService uServ = new UserService(uDAO);


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Returning or New User?");
		
		User logStatus = null;
		User u = null;
		
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
					System.out.println("Enter your desired USERNAME");
					String username = input.nextLine();
					System.out.println("Enter your desired PASSWORD");
					String password = input.nextLine();
					System.out.println("How much money will you deposit?(Only two decimal values are allowed)\nEnter Amount: ");
					double accountBalance = Double.parseDouble(input.nextLine());
					System.out.println("Please enter your full name: ");
					String personalInformation = input.nextLine();
					
					try {
						u = uServ.signUp(username, password, accountBalance, personalInformation);
						System.out.println("The account for the user: "+username+" was successfully created");
					}
					catch(Exception e){
						e.printStackTrace();
						System.out.println("This username already exists");
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