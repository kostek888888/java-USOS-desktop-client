import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class UsosMarksManager {
	
	static protected String MARKS_URL = "https://usosweb.tu.kielce.pl/kontroler.php?_action=dla_stud/studia/oceny/index";
	
	protected String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
	
	
	public void getMarks(Map<String, String> cookies) throws IOException {
		
		
		Document marksDocument = Jsoup.connect("https://usosweb.tu.kielce.pl/kontroler.php?_action=katalog2/index")
		.cookies(cookies)
		//.referrer("")
		.followRedirects(false)
		.userAgent(this.userAgent)
		.header("Host", "usosweb.tu.kielce.pl")
		.header("Upgrade-Insecure-Requests", "1")
		.get();
		
		//System.out.println(marksDocument.toString());
		
	}
	
}
