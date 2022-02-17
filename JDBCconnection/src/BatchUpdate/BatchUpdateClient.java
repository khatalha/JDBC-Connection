package BatchUpdate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import UsingStatement.DBUtil1;

public class BatchUpdateClient {

	public static void main(String[] args) throws SQLException {
		Connection connection = DBUtil1.getConnection();
		if(connection != null)
			System.out.println("JDBC:connection is taken..");
		
		  Statement st=(Statement) connection.createStatement();
		  
		  String sql1="INSERT INTO mydata(id,name,age,gender,phone,city)"+
					 "VALUES(6,'Sajid','23','M','225545','USA')";
			  
			  st.addBatch(sql1);
			  
			  String sql2="update mydata set name='Abhishek' where id=2";
			  st.addBatch(sql2);
			  
			String sql3="delete from mydata where id=3"; 
			st.addBatch(sql3);
			
			int i[]=st.executeBatch();
			for(int j=0;j<i.length;j++)
			{
				System.out.println(j);
			}
			
			try { 
				  connection.close(); 
				  st.close(); } 
			  catch(Exception e) {
			  System.out.println(e); }

	}

}
