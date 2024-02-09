package JavaFiles;
import java.lang.invoke.StringConcatFactory;

import org.json.JSONObject;

public class CookieHandler {
	public JSONObject createCookie(String name,String password) {
		JSONObject json= new JSONObject();
		json.put("name", name);
		json.put("password", password);
		return json;
	}
}
