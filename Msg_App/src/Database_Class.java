import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.microsoft.sqlserver.jdbc.*;


public class Database_Class {
	private static Connection con;
	static Statement stm = null;
	public void OpenConnection(){
		
		String connect_string = "jdbc:sqlserver://localhost:1433;" +
		"databaseName=testdb;integratedSecurity=true";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connect_string);
			stm = con.createStatement();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		System.out.println(con);
		
		
	}
	
	public void insert_message(String from,String to,String time,String msg){
		try {
			String insert = "INSERT INTO message_table " + "VALUES (" + '\'' + from + '\''+ ","+ '\'' +to +'\''+ "," +'\''+ time+ '\''+ "," + '\''+ msg + '\''+ ")";
			System.out.println(insert);
			System.out.println(stm);
			stm.executeUpdate(insert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	int id = 2;
	public String get_message(){
		String msg = "";
		ResultSet rs =null;
		ResultSet nick =null;
		
		try {
			rs = stm.executeQuery("SELECT from_m,message FROM message_table");
			while (rs.next()) {
				  String lastName = rs.getString("from_m");
				  String message = rs.getString("message");
				  System.out.println(lastName + "\n");
				  msg = msg + "\n"+lastName + ": " + message;
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(id);
		id = id + 1;
		return msg;
	}
	

}
