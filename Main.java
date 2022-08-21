package Bank;

import java.sql.SQLException;
import java.util.Scanner;

public class Main extends Transactions {
	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		Main m = new Main();
		System.out.println("@@@@@@ Welcome to amdocs payments bank @@@@@@@");
		Scanner sc = new Scanner(System.in);
		int ch=-1;
		do{
			System.out.print("Please enter your choice\n1.Create Account\n2.Deposit money\n3.Withdraw money\n\tChoice:");
			sc.hasNextLine();
			ch=sc.nextInt();
			switch(ch) {
			case 1:
				m.CreateAccount();
				break;
			case 2:
				m.deposit();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Invalid choice...");
			}
			
		}while(ch<4);
		
	}
}
