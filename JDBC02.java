import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC02 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "somesh";
		String password = "somesh";
		try {
			//Step 2 : Load & Register the driver.
			//cj : connector jar
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Step 3 : Connect to mysql
			Connection conn = DriverManager.getConnection(url,user,password);
			
			//Step 4 :  Create SQL queries
			Statement stmt = conn.createStatement();
			String createTable = "CREATE TABLE rcoem_student (" +
		             "std_no NUMBER PRIMARY KEY, " +
		             "std_name VARCHAR2(100), " +
		             "std_salary BINARY_DOUBLE)";			
			
			//herbernet is next version of database
			//Step 5 : execute the SQL queries
			stmt.executeUpdate(createTable);
			
			//Step 6 : Result
			System.out.println("Table created successfully : rcoem_student");
			
			
			//Step 4 :  Create SQL queries
			//Insert the data into table
			String insertData = "INSERT INTO rcoem_student (std_no,std_name,std_salary) VALUES (?,?,?)";
			
			PreparedStatement pst = conn.prepareStatement(insertData);
			
			//Insert first student data
			pst.setInt(1, 201);
			pst.setString(2, "Rasika");
			pst.setDouble(3, 12345.55);
			
			pst.executeLargeUpdate();
			
			//Step 6 : Result
			System.out.println("Data inserted successfully 1");
			
			//Insert second student data
			pst.setInt(1, 202);
			pst.setString(2, "Diya");
			pst.setDouble(3, 12885.55);
			
			pst.executeLargeUpdate();
			
			//Step 6 : Result
			System.out.println("Data inserted successfully 2");
			
			//Insert 3 student data
			pst.setInt(1, 203);
			pst.setString(2, "Ekta");
			pst.setDouble(3, 167345.55);
			
			pst.executeLargeUpdate();
			
			//Step 6 : Result
			System.out.println("Data inserted successfully 3");
			
			//Insert 4 student data
			pst.setInt(1, 204);
			pst.setString(2, "Meena");
			pst.setDouble(3, 16685.55);
			
			pst.executeLargeUpdate();
			
			//Step 6 : Result
			System.out.println("Data inserted successfully 4");
			
			//Insert 5 student data
			pst.setInt(1, 205);
			pst.setString(2, "Priya");
			pst.setDouble(3, 16775.55);
			
			pst.executeLargeUpdate();
			
			//Step 6 : Result
			System.out.println("Data inserted successfully 5");
			
			//Step 7 : Close the connection
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
