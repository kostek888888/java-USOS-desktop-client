import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
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
	
	Map<String, String> cookies;
	
	UsosLoginManager() {
		cookies = new HashMap<String, String>();
	}
	
	protected void openPageWithRedirect(String url, Map<String, String> cookiesParam, String ref) throws IOException
	{
		
		this.cookies.putAll(cookiesParam);
		
		Response response = Jsoup.connect(url)
				.userAgent(this.userAgent)
				.cookies(cookiesParam)
				.followRedirects(false)
				.referrer(ref)
				.execute();
		
		
		this.cookies.putAll(response.cookies());
		
		
		System.out.println(response.parse().toString());
		
		if(response.statusCode() == 301 || response.statusCode() == 302) {
			
			this.openPageWithRedirect(response.url().toString()+"/"+response.header("Location"), response.cookies(), url);
		}
	}
	
	/**
	 * 
	 * @param login
	 * @param pass
	 * @return ciasteczka
	 * @throws IOException
	 */
	public Map<String, String> login(String login, String pass) throws IOException {
		
				Response res = Jsoup.connect("https://cas.usos.tu.kielce.pl/cas/login?service=https%3A%2F%2Fusosweb.tu.kielce.pl%2Fkontroler.php%3F_action%3Dlogowaniecas%2Findex&locale=pl")
						.userAgent(this.userAgent)
						.execute();
				
				String jSessionIdCookie = res.cookie("JSESSIONID");
				
				Document logStartDocument = res.parse();
				
				String logFormEventId = logStartDocument.select("[name='_eventId']").attr("value");
				String logFormLt = logStartDocument.select("[name='lt']").attr("value");
				String logFormExecution = logStartDocument.select("[name='execution']").attr("value");
				String logFormSubmit = "ZALOGUJ";				
				
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

				String castgcCookie = resLogowanie.cookie("CASTGC");
				
				this.openPageWithRedirect("https://usosweb.tu.kielce.pl", resLogowanie.cookies(), resLogowanie.url().toString());
								
				return this.cookies;
	}
	
	
}
