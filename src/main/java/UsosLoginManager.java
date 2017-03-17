import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class UsosLoginManager {
	
	protected String jSessionIdCookie;
	protected String castgcCookie;
	protected String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
	
	protected void openPageWithRedirect(String url, Map<String, String> cookies, String ref) throws IOException
	{
		System.out.println("Otwieram: "+ url);
		
		Response respose = Jsoup.connect(url)
				.userAgent(this.userAgent)
				.cookies(cookies)
				.followRedirects(false)
				.referrer(ref)
				.execute();
		
		System.out.println("status code: "+respose.statusCode());
		System.out.println(respose.parse().toString());
		System.out.println("reffers: "+ respose.header("Location"));
		
		
	}
	
	
	public void login(String login, String pass) throws IOException {
		
				Response res = Jsoup.connect("https://cas.usos.tu.kielce.pl/cas/login?service=https%3A%2F%2Fusosweb.tu.kielce.pl%2Fkontroler.php%3F_action%3Dlogowaniecas%2Findex&locale=pl")
						.userAgent(this.userAgent)
						.execute();
				
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
				
				
				Response resLogowanie = Jsoup.connect("https://cas.usos.tu.kielce.pl/cas/login?service=https%3A%2F%2Fusosweb.tu.kielce.pl%2Fkontroler.php%3F_action%3Dlogowaniecas%2Findex&locale=pl")
				.userAgent(this.userAgent)
				.cookie("JSESSIONID", jSessionIdCookie)
				.data("username", login, 
						"password", pass,
						"_eventId", logFormEventId,
						"lt", logFormLt,
						"execution", logFormExecution,
						"submit", logFormSubmit
						)
				.header("Host", "cas.usos.tu.kielce.pl")
				.header("Upgrade-Insecure-Requests", "1")
				.referrer("https://cas.usos.tu.kielce.pl/cas/login")
				
				
				.timeout(3000)
				.execute();
				
				System.out.println("Status html: "+resLogowanie.statusCode());
				System.out.println("jSessionIdCookie: "+ jSessionIdCookie);

				String castgcCookie = resLogowanie.cookie("CASTGC");

				
				
				Document docLogWynik = resLogowanie.parse();
				System.out.println(docLogWynik.toString());
				System.out.println("CASTGC: "+castgcCookie);
				
				Map<String, String> cookies = resLogowanie.cookies();
				
				this.openPageWithRedirect("https://usosweb.tu.kielce.pl", cookies, resLogowanie.url().toString());
				
				/*
				Document docOceny = Jsoup.connect("https://usosweb.tu.kielce.pl/kontroler.php?_action=dla_stud/studia/oceny/index")
						.cookie("JSESSIONID", jSessionIdCookie)
						.cookie("CASTGC", castgcCookie)
						.timeout(3000)
						.get();
				
				
				//Elements newsHeadlines = doc.select("#mp-itn b a");
				//System.out.println(docLogWynik.html());
				System.out.println(docOceny.html());
				//System.out.println(doc.);
				*/
	}
}
