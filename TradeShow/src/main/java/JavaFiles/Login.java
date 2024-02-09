package JavaFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import javax.servlet.http.Cookie;

public class Login extends HttpServlet{
	Connector connector=new Connector();
	Connection con=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        con=Connector.getConnection();
		if(uDao.userAuthentication(name,password)=="true") {
			System.out.println("login successful");
			CookieHandler ckHandler=new CookieHandler();
			String cookieData=(ckHandler.createCookie(name, password)).toString();
			Cookie cookie = new Cookie("UserData", cookieData);
			cookie.setMaxAge(24 * 60 * 60); 
			response.addCookie(cookie);
;
		}
		else {
			System.out.println(uDao.userAuthentication(name,password));
		}
        
         
        
}
	
}
