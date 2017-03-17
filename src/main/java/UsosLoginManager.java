import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class UsosLoginManager {
	
	protected String jSessionIdCookie;
	protected String castgcCookie;
	protected String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
	
	Map<String, String> cookies;
	
	UsosLoginManager() {
		cookies = new HashMap<String, String>();
	}
	
	/*
	protected void openPageWithRedirect(String url, Map<String, String> cookiesParam, String ref) throws IOException
	{
		
		this.cookies.putAll(cookiesParam);
		
		Response response = Jsoup.connect(url)
				.userAgent(this.userAgent)
				.cookies(cookiesParam)
				.followRedirects(false)
				.referrer(ref)
				.execute();
		
		
		this.displayDataResponse(response);
		
		this.cookies.putAll(response.cookies());
		
		
		if(response.statusCode() == 301 || response.statusCode() == 302) {
			
			this.openPageWithRedirect(response.url().toString()+"/"+response.header("Location"), this.cookies, url);
		}
	}
	*/
	
	/**
	 * 
	 * @param login
	 * @param pass
	 * @return ciasteczka
	 * @throws IOException
	 */
	public Map<String, String> login(String login, String pass) throws IOException {
		
				Response res = Jsoup.connect("https://cas.usos.tu.kielce.pl/cas/login")
						.userAgent(this.userAgent)
						.execute();
				
				String jSessionIdCookie = res.cookie("JSESSIONID");
				
				Document logStartDocument = res.parse(); 
				
				String logFormEventId = logStartDocument.select("[name='_eventId']").attr("value");
				String logFormLt = logStartDocument.select("[name='lt']").attr("value");
				String logFormExecution = logStartDocument.select("[name='execution']").attr("value");
				String logFormSubmit = "ZALOGUJ";				

				Response resLogowanie = Jsoup.connect("https://cas.usos.tu.kielce.pl/cas/login;jsessionid="+jSessionIdCookie)
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
				.followRedirects(false)
				.referrer("https://cas.usos.tu.kielce.pl/cas/login")
				.method(Connection.Method.POST)
				.timeout(3000)
				.execute();
				
				System.out.println(resLogowanie.parse());
				this.displayDataResponse(resLogowanie);
				
				String castgcCookie = resLogowanie.cookie("CASTGC");
				
				// ================ otwieramy ocenki
				Response resOceny = Jsoup.connect("https://usosweb.tu.kielce.pl/kontroler.php?_action=dla_stud/studia/oceny/index")
						.userAgent(this.userAgent)
						.cookie("JSESSIONID", jSessionIdCookie)
						.header("Host", "usosweb.tu.kielce.pl")
						.header("Upgrade-Insecure-Requests", "1")
						.followRedirects(false)
						.execute();
				
				System.out.println("Otwarcie ocen");
				this.displayDataResponse(resOceny);
				
				String PHPSESSID = resOceny.cookie("PHPSESSID");
				
				//  ================ przekierowanie 2
				
				Response przekierowanie2 = Jsoup.connect("https://cas.usos.tu.kielce.pl/cas/login")
						.userAgent(this.userAgent)
						.cookie("JSESSIONID", jSessionIdCookie)
						.cookie("CASTGC", castgcCookie)
						.header("Host", "cas.usos.tu.kielce.pl")
						.header("Upgrade-Insecure-Requests", "1")
						.data("service", "https://usosweb.tu.kielce.pl/kontroler.php?_action=dla_stud/studia/oceny/index",
								"gateway", "true",
								"locale", "pl")
						.followRedirects(false) 
						.method(Connection.Method.GET)
						.execute();
				
				System.out.println("przekierowanie 2");
				this.displayDataResponse(przekierowanie2);
				
			//  ================ przekierowanie 3 z ticketem
				Response przekierowanie3ticket = Jsoup.connect(przekierowanie2.header("Location"))
						.userAgent(this.userAgent)
						.header("Host", "usosweb.tu.kielce.pl")
						.header("Upgrade-Insecure-Requests", "1")
						.cookie("PHPSESSID", PHPSESSID)
						.followRedirects(false) 
						.execute();
				
				System.out.println("przekierowanie 3 z ticketem");
				this.displayDataResponse(przekierowanie3ticket);
				
				// ============= wchodzimy na oceny !!!!!!!!!
				
				Response oceny = Jsoup.connect(przekierowanie3ticket.header("Location"))
						.userAgent(this.userAgent)
						.header("Host", "usosweb.tu.kielce.pl")
						.header("Upgrade-Insecure-Requests", "1")
						.cookie("PHPSESSID", PHPSESSID)
						.followRedirects(false) 
						.execute();
				
				
				System.out.println(oceny.parse().toString());
				
				/*
				// ==================== otwieramy 302
				Response res302Ticket = Jsoup.connect(resLogowanie.header("Location"))
						.followRedirects(false)
						.userAgent(this.userAgent)
						.header("Upgrade-Insecure-Requests", "1")
						.header("Host", "usosweb.tu.kielce.pl")
						.referrer(resLogowanie.url().toString())
						.execute();
				
				this.displayDataResponse(res302Ticket);
				
				*/
				return null;
	}
	
	protected void displayDataResponse(Response response) {
		System.out.println("URL : "+response.url());
		System.out.println("HTML CODE: "+response.statusCode());
		System.out.println("Coockies : "+response.cookies());
		
		if(response.statusCode() == 301 || response.statusCode() == 302) {
			System.out.println("Location : "+response.header("Location"));
		}
		
		
		
		System.out.println(" ===================== ");
		
		
	}
	
	
}
