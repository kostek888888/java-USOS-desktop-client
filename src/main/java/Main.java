import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Response res = Jsoup.connect("https://cas.usos.tu.kielce.pl/cas/login").execute();
		
		String jSessionIdCookie = res.cookie("JSESSIONID");
		
		Document logStartDocument = res.parse();
		
		
		
		String logFormEventId = logStartDocument.select("[name='_eventId']").attr("value");
		String logFormLt = logStartDocument.select("[name='lt']").attr("value");
		String logFormExecution = logStartDocument.select("[name='execution']").attr("value");
		String logFormSubmit = "ZALOGUJ";
		
		System.out.println(logFormEventId);
		System.out.println(logFormLt);
		System.out.println(logFormExecution);
		System.out.println(logFormSubmit);
		
		
		Response resLogowanie = Jsoup.connect("https://cas.usos.tu.kielce.pl/cas/login;jsessionid="+jSessionIdCookie)
		.userAgent("Mozilla")
		.cookie("JSESSIONID", jSessionIdCookie)
		.data("username", "94070910750", 
				"password", "qwertyqwerty",
				"_eventId", logFormEventId,
				"lt", logFormLt,
				"execution", logFormExecution,
				"submit", logFormSubmit
				)
		.timeout(3000)
		.execute();
		
		String castgcCookie = resLogowanie.cookie("CASTGC");

		Document docLogWynik = resLogowanie.parse();

		System.out.println("CASTGC: "+castgcCookie);
		
		
		
		Document docOceny = Jsoup.connect("https://usosweb.tu.kielce.pl/kontroler.php?_action=dla_stud/studia/oceny/index")
				.cookie("JSESSIONID", jSessionIdCookie)
				.cookie("CASTGC", castgcCookie)
				.timeout(3000)
				.get();
		
		
		//Elements newsHeadlines = doc.select("#mp-itn b a");
		//System.out.println(docLogWynik.html());
		System.out.println(docOceny.html());
		//System.out.println(doc.);
		
	}

}
