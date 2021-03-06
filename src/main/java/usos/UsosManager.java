package usos;
import java.io.IOException;
import java.util.Map;

import usos.database.DatabaseManager;
import usos.database.Element;
import usos.helper.Semester;

public class UsosManager {

	protected UsosLoginManager usosLoginManager;
	protected UsosMarksManager usosMarksManager;
	protected DatabaseManager databaseManager;
	
	protected String sessionId = null;
	protected String login;
	protected String username;
	
	public UsosManager() {
		usosLoginManager = new UsosLoginManager();
		usosMarksManager = new UsosMarksManager();
		databaseManager = new DatabaseManager();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void turnOnTestMode(String testServerUrl) {
		usosLoginManager.turnOnTestMode(testServerUrl);
		usosMarksManager.turnOnTestMode(testServerUrl);
	}
	
	public void login(String login, String pass) throws IOException, LoginInvalidCredentialsException {
			usosLoginManager.login(login, pass);
			this.sessionId = usosLoginManager.getSessionId();
			this.login = login;
			this.username = login;
	}
	 
	public void logout() throws IOException, LogoutException {
		databaseManager.close(); //close database first !!!
		usosLoginManager.logout(); 
	}
	
	
	public Semester getMarksForLastSemester() throws IOException {
		return usosMarksManager.getMarksForLastSemester(this.sessionId);
	}
	
	public boolean checkChangesInMarks() throws IOException {
		Semester semester = this.getMarksForLastSemester();
		
		if(databaseManager.checkChangesInMarks(semester, login)) {
			databaseManager.saveSemester(semester, login); 
			return true;
		} else {
			return false;
		}

	}
	
	
}
