package JavaFiles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.lookup.MethodScope;

public class UserDao {
	private PreparedStatement statement;
	private ResultSet rSet;
	Connector connector=new Connector();
	private Connection con=connector.getConnection();
	
	
//	methods for signup starts here
	
	
	public String checkValidUser(String name,String password){
		con=Connector.getConnection();
        PreparedStatement statement;
		try {
			statement = con.prepareStatement("SELECT * FROM users WHERE username = ?");
			statement.setString(1,name);
	        ResultSet rSet=statement.executeQuery();
	        if (rSet.next()) {
	        	return "user already exist";
	        }
	        else {
	        	
	        	return dataUploader(name, password);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
	public String dataUploader(String name,String password){
	     try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        PreparedStatement statement;
		    String queryString="insert into tablename(name,password) values (?,?); ";
		    statement=con.prepareStatement(queryString);
		    statement.setString(1,name);
		    statement.setString(2, password);
		    statement.executeUpdate();
		    return "Records added successfully";
	     } 
	     catch (Exception e) {
	        e.printStackTrace();
	        return "Exception: MySQL JDBC Driver not found.";
	      }
	      
	  
	 }
	
//	Methods for signup ends here
	
	
	
//Methods for signin starts here
	
	public  String userAuthentication(String name,String password) {
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("SELECT * FROM users WHERE username = ?");
			statement.setString(1,name);
	        ResultSet rSet=statement.executeQuery();
	        if (rSet.next()) {
	        	return validateUserRecord(name,password)+"";
	        	
	        }
	        else {
	        	return "user already exist";
	        }
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
	
	
	public boolean validateUserRecord(String name,String password) throws SQLException {
		PreparedStatement statement;
		statement=con.prepareStatement("select password from user where username=? ;");
		statement.setString(1,name);
		ResultSet rSet=statement.executeQuery();
		if(rSet.next()) {
			return true;
			
		}
		else {
			return false;
 
		}
	}
	
}
