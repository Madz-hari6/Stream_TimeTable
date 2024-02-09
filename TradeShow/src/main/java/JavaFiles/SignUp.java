package JavaFiles;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        StringBuilder sb = new StringBuilder();
	        UserDao uDao=new UserDao();
	        BufferedReader reader = request.getReader();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }
	        
	        JSONObject jsonObject = new JSONObject(sb.toString());
	        String name = jsonObject.getString("name");
	        String password = jsonObject.getString("Password");
	        System.out.println(uDao.checkValidUser(name, password));
	        
	        
	        
	        
	        
	        
}
	  
}
