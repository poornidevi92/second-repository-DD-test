package A1_DBtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class A1_DBtest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		validateMobile("select * from Student2", "222222222");
	}
	
	public static void validateMobile(String Query, String data) throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");

		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/batch253", "postgres", "PUNJABpeas@28");

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(Query);
		//System.out.println(rs);
	
		while(rs.next()){
		//	System.out.println(rs.getString(2)+"---"+rs.getString(3)+"---"+rs.getString(4));
		
			String record=rs.getString(3);
			if(record.equals(data)){
				System.out.println("Yes data exits");
			}
		}
	}
}



