package usos;
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
	
	private String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
	private String sessionId = null;
	private String testServerUrl = null;
	private boolean testMode = false;
	
	
	UsosLoginManager() {
		turnOnTestMode("http://localhost:8080/javaUSOSpskMock");
	}
	
	private String getCasDomain() {
		return (testMode == true) ? testServerUrl : "https://cas.usos.tu.kielce.pl";
	}
	
	private String getUsosDomain() {
		return (testMode == true) ? testServerUrl : "https://usosweb.tu.kielce.pl"; 
	}
	
	
	/**
	 * 
	 * @param login
	 * @param pass
	 * @return ciasteczka
	 * @throws IOException
	 * @throws LoginInvalidCredentialsException 
	 */
	public void login(String login, String pass) throws IOException, LoginInvalidCredentialsException {
		
				Response res = Jsoup.connect(getCasDomain()+"/cas/login")
						.userAgent(this.userAgent)
						.execute();
				
				String jSessionIdCookie = res.cookie("JSESSIONID");
				
				Document logStartDocument = res.parse(); 
				
				String logFormEventId = logStartDocument.select("[name='_eventId']").attr("value");
				String logFormLt = logStartDocument.select("[name='lt']").attr("value");
				String logFormExecution = logStartDocument.select("[name='execution']").attr("value");
				String logFormSubmit = "ZALOGUJ";				

				Response resLogowanie = Jsoup.connect(getCasDomain()+"/cas/login;jsessionid="+jSessionIdCookie)
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
				
				String castgcCookie = resLogowanie.cookie("CASTGC");
				
				if(resLogowanie.parse().select("#page > div.text > h2").text().trim().equals("Udane logowanie") == false) {
					throw new LoginInvalidCredentialsException();
				} 
				
				// ================ otwieramy ocenki
				Response resOceny = Jsoup.connect(getUsosDomain()+"/kontroler.php?_action=dla_stud/studia/oceny/index")
						.userAgent(this.userAgent)
						.cookie("JSESSIONID", jSessionIdCookie)
						.header("Host", "usosweb.tu.kielce.pl")
						.header("Upgrade-Insecure-Requests", "1")
						.followRedirects(false)
						.execute();
								
				this.sessionId = resOceny.cookie("PHPSESSID");
				
				//  ================ przekierowanie 2
				Response przekierowanie2 = Jsoup.connect(getCasDomain()+"/cas/login")
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
				
			//  ================ przekierowanie 3 z ticketem
				if(przekierowanie2.header("Location") != null) {
					Response przekierowanie3ticket = Jsoup.connect(przekierowanie2.header("Location"))
							.userAgent(this.userAgent)
							.header("Host", "usosweb.tu.kielce.pl")
							.header("Upgrade-Insecure-Requests", "1")
							.cookie("PHPSESSID", this.sessionId)
							.followRedirects(false) 
							.execute();
				}
				
				
	}
	
	public String getSessionId() {
		return this.sessionId;
	}
	
	public void turnOnTestMode(String testServerUrl) {
		testMode = true;
		this.testServerUrl = testServerUrl;
	}
	
	protected void displayDataResponse(Response response) {
		System.out.println("URL : "+response.url());
		System.out.println("HTML CODE: "+response.statusCode());
		System.out.println("Cookies : "+response.cookies());
		
		if(response.statusCode() == 301 || response.statusCode() == 302) {
			System.out.println("Location : "+response.header("Location"));
		}
		
		try {
			//System.out.println(response.parse().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(" ===================== ");
	}
	
	
}
