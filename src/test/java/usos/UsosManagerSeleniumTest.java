package usos;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import usos.helper.Semester;
import usos.helper.Subject;
import usos.helper.TypeOfClass;
import usos.helper.TypeOfClass.type;

public class UsosManagerSeleniumTest {
	
	static WebDriver driver;
	static UsosManager usosManager;
	
	
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", Params.getInstance().get("geckoDriverPatch"));
		driver = new FirefoxDriver();
		usosManager = new UsosManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
		driver.quit();
	}
	
	protected void login() throws InterruptedException {
		driver.get(Params.getInstance().get("usosCasUrl")+"/cas/login");
		WebElement loginField = driver.findElement(By.name("username"));
		WebElement passField = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.name("submit"));
		
		loginField.sendKeys(Params.getInstance().get("usosLogin"));
		passField.sendKeys(Params.getInstance().get("usosPass"));
		
		loginButton.click();
		Thread.sleep(2000);
		
		
	}
	
	@Test
	public void testGetMarksForLastSemester() throws InterruptedException {
		this.login();
		driver.get(Params.getInstance().get("usosUrl")+"/kontroler.php?_action=dla_stud/studia/oceny/index");
		
		Semester lastSemester = null;
		
		try {
			usosManager.login(Params.getInstance().get("usosLogin"), Params.getInstance().get("usosPass"));
			lastSemester = usosManager.getMarksForLastSemester();
			
		} catch (IOException | LoginInvalidCredentialsException e) {
			fail();
		}
		
		List<Subject> subjects = lastSemester.getSubjects();
		
		//test first
		Subject firstSubject = subjects.get(0);
		
		Map<type, TypeOfClass> typesOfClass = firstSubject.getTypesOfClass();
		
		int i = 1;
		for(TypeOfClass typeOfClass : typesOfClass.values()) {

			WebElement xx = driver.findElement(By.cssSelector("#tab1 > tr:nth-child("+i+") > td.strong > div:nth-child(1) > span:last-child"));
			assertEquals(typeOfClass.getMainMark().getStringMark(), xx.getText());
			i++;
		}
		
	}

}
