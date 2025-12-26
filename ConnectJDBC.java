import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class ConnectJDBC {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "somesh";
		String password = "somesh";
		
		String dbName = "RCOEM_CSE";
		try {
			//Step 2 : Load & Register the driver.
			//cj : connector jar
			Class.forName("oracle.jdbc.driver.OracleDriver");

			
			//Step 3 : Connect to mysql
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.print("Database connection Successfully");
			
			//Step 4 :  Create SQL queries
			Statement stmt = conn.createStatement();
			String sql = "create table rcoem (rno int)";
			
			//Step 5 : execute the SQL queries
			stmt.executeUpdate(sql);
			
			//Step 6 : Result
			System.out.println("table created successfully : " + dbName);
//			
//			//Step 7 : Close the connection
			conn.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
