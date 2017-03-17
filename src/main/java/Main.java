import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		UsosLoginManager usosLoginManager = new UsosLoginManager();
		usosLoginManager.login("94070910750", "qwertyqwerty");
		
		
		
		
	}

}
