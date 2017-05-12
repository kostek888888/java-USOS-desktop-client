import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

import usos.LoginInvalidCredentialsException;
import usos.LogoutException;
import usos.UsosManager;

public class Main {

	public static void main(String[] args) throws IOException, SQLException, LogoutException {

		UsosManager usosManager = new UsosManager();

		try {
			usosManager.login("94070910750", "qwerty");
			System.out.println("Zalogowano");
			
			usosManager.checkChangesInMarks();
		} catch (LoginInvalidCredentialsException e) {
			System.out.println("Niepoprawne dane logowania");
		} finally {
			usosManager.logout();
		}
		
		
	}

}
