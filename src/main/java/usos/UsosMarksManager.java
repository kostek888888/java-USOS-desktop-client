package usos;
import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

public class UsosMarksManager {
	
	static protected String MARKS_URL = "https://usosweb.tu.kielce.pl/kontroler.php?_action=dla_stud/studia/oceny/index";
	
	protected String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
	
	
	
	public void getMarks(String sessionId) throws IOException {
		Document markDocument = this.getMarksDocument(sessionId);
		
	}
	
	private Document getMarksDocument(String sessionId) throws IOException {
		
		Response oceny = Jsoup.connect("https://usosweb.tu.kielce.pl/kontroler.php?_action=dla_stud/studia/oceny/index")
				.userAgent(this.userAgent)
				.header("Host", "usosweb.tu.kielce.pl")
				.header("Upgrade-Insecure-Requests", "1")
				.cookie("PHPSESSID", sessionId)
				.followRedirects(false) 
				.execute();
		
		return oceny.parse();
	}
	
	private void parseMarksDocument(Document markDocument) {
		
	}
	
}
