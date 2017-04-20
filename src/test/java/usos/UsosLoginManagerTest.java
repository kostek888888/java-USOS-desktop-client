package usos;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class UsosLoginManagerTest {
	
	static private UsosLoginManager usosLoginManager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usosLoginManager = new UsosLoginManager();
		usosLoginManager.turnOnTestMode("http://31.178.72.165:8080/javaUSOSpskMock");
	}

	@Test(expected=LoginInvalidCredentialsException.class)
	public void testIncorrectLogin() throws IOException, LoginInvalidCredentialsException {
			usosLoginManager.login("test", "qwertyx");
	}
	
	@Test()
	public void testLogin() throws IOException, LoginInvalidCredentialsException {
			usosLoginManager.login("test", "qwerty");
			assertNotNull(usosLoginManager.getSessionId());
			
	}
	
	@Test
	public void testLogout() throws IOException, LogoutException {
		usosLoginManager.logout();  
	}
	

	@Test
	public void testGetSessionId() {
		assertEquals(usosLoginManager.getSessionId(),"test");
	}
	
	

}
