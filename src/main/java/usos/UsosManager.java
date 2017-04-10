package usos;
import java.io.IOException;
import java.util.Map;

public class UsosManager {
	
	
	protected UsosLoginManager usosLoginManager;
	protected UsosMarksManager usosMarksManager;
	
	protected String sessionId = null;
	
	public UsosManager() {
		usosLoginManager = new UsosLoginManager();
		usosMarksManager = new UsosMarksManager();
	}
	
	public void login(String login, String pass) throws IOException, LoginInvalidCredentialsException {
			usosLoginManager.login(login, pass);
			this.sessionId = usosLoginManager.getSessionId();
	}
	
	public void logout() {
		//@todo
	}
	
	
	public void getMarks() throws IOException
	{
		usosMarksManager.getMarks(this.sessionId);
	}
	
	
}