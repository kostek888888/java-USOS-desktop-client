import java.io.IOException;
import java.util.Map;

public class UsosManager {
	
	
	
	protected Map<String, String> coockies;
	
	protected UsosLoginManager usosLoginManager;
	protected UsosMarksManager usosMarksManager;
	
	UsosManager() {
		usosLoginManager = new UsosLoginManager();
		usosMarksManager = new UsosMarksManager();
	}
	
	public void login(String login, String pass) throws IOException {
		coockies = usosLoginManager.login(login, pass);
	}
	
	public void logout() {
		//@todo
	}
	
	
	public void getMarks() throws IOException
	{
		usosMarksManager.getMarks(coockies);
	}
	
	
}
