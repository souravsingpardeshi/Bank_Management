package Bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Connection;
public class CreateAc{
	void CreateAccount() throws SQLException {
		//regex for pin and balance validation
		String regex = "[0-9]+";
		Pattern pt = Pattern.compile(regex);
		//scanner for taking input
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to new account Creation....\nPlease enter your name:");
		String Name= sc.nextLine();
		System.out.println("Please enter initial deposit ammount (Minumum 500):");
		String blns = sc.nextLine();
		Matcher mb = pt.matcher(blns);
		String statb=String.valueOf(mb.matches());
		//checking if deposit is less than 500 and is enterd value numeric
		while(statb.equals("false") || Integer.parseInt(blns)<500) {
			System.out.println("Please enter amount greater than 500Rs..");
			blns= sc.nextLine();
			mb = pt.matcher(blns);
			statb=String.valueOf(mb.matches());
		}
		System.out.println("Please enter Pin");
		String pin = sc.nextLine();
		Matcher m = pt.matcher(pin);
		String stat=String.valueOf(m.matches());
		//checking if pin is less than 4 digit or not numeric
		while(stat.equals("false") || pin.length()!=4) {
			System.out.println("pin should only contain numeric value and can only have 4 values ...!");
			pin  = sc.nextLine();
			 m = pt.matcher(pin);
			stat=String.valueOf(m.matches());
		}
		int p = Integer.parseInt(pin);
		Connection con = Db.getConnection();
		Statement st=con.createStatement();
		st.executeQuery("insert into customer values(SEQ_AC_NO.nextval,'"+Name+"','"+blns+"','"+p+"')");
		ResultSet s=st.executeQuery("select ac_no from(select * from customer order by ac_no desc)where ROWNUM=1");
		while(s.next()) {
		System.out.println("Account Created successfully for user "+Name+" and your account numebr is "+s.getString(1));
	}
		}
}
