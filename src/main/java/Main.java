import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import usos.LoginInvalidCredentialsException;
import usos.UsosManager;

public class Main {

	public static void main(String[] args) throws IOException {
		
		UsosManager usosManager = new UsosManager();


		try {
			usosManager.login("94070910750", "qwertyqwerty");
			usosManager.getMarks();
		} catch (LoginInvalidCredentialsException e) {
			System.out.println("Niepoprawne dane logowania");
		}
		

		
		
		
		
	}

}
