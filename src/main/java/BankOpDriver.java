

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
		Scanner account = new Scanner(System.in);
		
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
					System.out.println("Enter USERNAME");
					String username = input.nextLine();
					System.out.println("Enter PASSWORD");
					String password = input.nextLine();
					System.out.println("Please select Account Type");
					System.out.println("Enter 1 for Savings / Enter 2 for Checking");
					int option2 = Integer.parseInt(account.nextLine());
						if (option == 1) {
							System.out.println("Savings Account");
						}
						else if (option == 2) {
							System.out.println("Checking Account");
						}
						else {
							System.out.println("Invalid Input");
						}
					System.out.println("After option2 loop");
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