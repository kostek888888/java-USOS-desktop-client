package usos;

import org.jsoup.Connection.Response;

public abstract class UsosAbstractManager {
	
	static private final String USOS_CAS_MAIN_URL = "https://cas.usos.tu.kielce.pl";
	static private final String USOS_MAIN_URL = "https://usosweb.tu.kielce.pl";
	
	protected String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
	protected boolean testMode = false;
	protected String testServerUrl = null;
	
	public void turnOnTestMode(String testServerUrl) {
		testMode = true;
		this.testServerUrl = testServerUrl;
	}
	
	protected String getCasDomain() {
		return (testMode == true) ? testServerUrl : USOS_CAS_MAIN_URL;
	}
	
	protected String getUsosDomain() {
		return (testMode == true) ? testServerUrl : USOS_MAIN_URL; 
	}
	
	protected void displayDataResponse(Response response) {
		System.out.println("URL : "+response.url());
		System.out.println("HTML CODE: "+response.statusCode());
		System.out.println("Cookies : "+response.cookies());
		
		if(response.statusCode() == 301 || response.statusCode() == 302) {
			System.out.println("Location : "+response.header("Location"));
		}
		
		System.out.println(" ===================== ");
	}
}
