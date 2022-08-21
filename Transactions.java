package Bank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Transactions extends CreateAc {
	void deposit() throws SQLException {
		Connection con = Db.getConnection();
		Statement st=con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter you account no to deposit money:");
		String ac_no= sc.nextLine();
		String ch="n";
		System.out.println("please check your account number: "+ac_no+"\n enter y if account no is correct else enter n to re-enter the account number ");
		ch=sc.nextLine();
		while(ch.equals("n")) {
			System.out.println("please re-enter the correct account number");
			ac_no=sc.nextLine();
			System.out.println("please check your account number: "+ac_no+"\n enter y if account no is correct else enter n to re-enter the account number ");
			ch=sc.nextLine();
		}
		System.out.println("Please enter the amount to deposit");
		float deposit= sc.nextFloat();
		ResultSet rt = st.executeQuery("select balance from customer where ac_no='"+ac_no+"'");
		while(rt.next()) {
		deposit=deposit+Float.parseFloat(rt.getString(1));
		st.executeQuery("update customer set balance='"+deposit+"' where ac_no='"+ac_no+"'");
		System.out.println("Money deposited current balance : "+deposit);
		}
		
	}
}
