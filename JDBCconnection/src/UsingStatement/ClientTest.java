package UsingStatement;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientTest {

	public static void main(String[] args) throws SQLException {
		Connection connection = DBUtil1.getConnection();
        if (connection != null){
            System.out.println("JDBC:connection is taken..");

            Statement st = connection.createStatement();
            String sql = "select * from mytable";//mytable is table
            ResultSet rs = st.executeQuery(sql);

//            while (rs.next()){// fatch the data from database
//                System.out.println(rs.getInt(1));
//                System.out.println(rs.getString(2));
//                System.out.println(rs.getInt(3));
//                System.out.println(rs.getString(4));
//            }
            String sqlu="insert into mytable(ID," +
                    "Name,Age,Division) values(9,'kajal','23','B')" ;
            int n=st.executeUpdate(sqlu);//Add data in database table
            System.out.println(n + "row"+ "afftected");
            try{
                connection.close();
                st.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}


