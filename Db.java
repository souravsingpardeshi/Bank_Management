package Bank;
import java.sql.Connection;
import java.sql.DriverManager;
public class Db {
	static Connection con=null;
	public static Connection getConnection() {
		if(con!=null) return con;
		String url="jdbc:oracle:thin:@localhost:1521/orcl.iiht.tech";
		String userName="scott";
		String password="tiger";
		return getConnection(url,userName,password);
	}
	private static Connection getConnection(String url,String userName,String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,userName,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
