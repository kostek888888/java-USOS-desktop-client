package usos;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsosManagerTest {

	static UsosManager usosManager = new UsosManager();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usosManager.turnOnTestMode(Params.getInstance().get("usosMockUrl"));
		usosManager.login(Params.getInstance().get("usosMockLogin"), Params.getInstance().get("usosMockPass"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		usosManager.logout();
	}

	@Test
	public void testCheckChangesInMarks() {
		try {
			usosManager.checkChangesInMarks(); // musi to zostać !
			assertFalse(usosManager.checkChangesInMarks());
			Jsoup.connect(Params.getInstance().get("usosMockChangeMarkUrl")).execute();
			assertTrue(usosManager.checkChangesInMarks());
			assertFalse(usosManager.checkChangesInMarks());
		} catch (IOException e) {
			fail();
		}
	}

}
