package usos;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsosManagerSeleniumTest {
	
	static WebDriver driver;
	
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
		driver.quit();
	}
	
	protected void login() {
		driver.get("https://cas.usos.tu.kielce.pl/cas/login");
		WebElement loginField = driver.findElement(By.name("username"));
		WebElement passField = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.name("submit"));
		
		loginField.sendKeys("94070910750");
		passField.sendKeys("qwerty");
		
		loginButton.click();
	}
	
	@Test
	public void testLogin() throws InterruptedException {
		this.login();
		
		Thread.sleep(5000);
		WebElement loginEffectText = driver.findElement(By.cssSelector("#page > div.text > h2"));
		assertEquals(loginEffectText.getText(), "Udane logowanie");
		
	}

	@Test
	public void testLogout() throws InterruptedException {
		this.login();
	}

	@Test
	public void testGetMarksForLastSemester() {
		//fail("Not yet implemented");
	}

}
