package UsingCallableStatement;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;


public class Client2 {
	static CallableStatement cs=null;
	static Statement st=null;
	public static void main(String[] args) throws SQLException {

		Connection connection = DbUtil2.getConnection();
		
		if(connection != null)
			System.out.println("JDBC:connection is taken..");
		try {
			String sql="CREATE DEFINER=`root`@`localhost` PROCEDURE `p1`()\r\n"
					+ "BEGIN\r\n"
					+ "INSERT INTO `details`.`procedure`(`id`,`name`,`age`,`gender`,`phone`,`city`)\r\n"
					+ "VALUES(1,'Sharath','13','F','202222','Mumbai');\r\n"
					+ "INSERT INTO `details`.`procedure`(`id`,`name`,`age`,`gender`,`phone`,`city`)\r\n"
					+ "VALUES(2,'Banana','32','M','402222','Pakistan');\r\n"
					+ "INSERT INTO `details`.`procedure`(`id`,`name`,`age`,`gender`,`phone`,`city`)\r\n"
					+ "VALUES(3,'Apple','53','F','302222','India');\r\n"
					+ "END";
			
			  st=(Statement) connection.createStatement();
			  int i=((java.sql.Statement) st).executeUpdate(sql);
			 
			cs=(CallableStatement) connection.prepareCall("{call p1()}");
			int i1=cs.executeUpdate();
			System.out.println(i1);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try { 
			  connection.close(); 
			  cs.close(); 
			  } 
		  catch(Exception e) {
		  System.out.println(e); 
		  }
	}
}
