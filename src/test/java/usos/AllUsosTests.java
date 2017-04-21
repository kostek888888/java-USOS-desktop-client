package usos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import usos.helper.AllUsosHelperTests;

@RunWith(Suite.class)
@SuiteClasses({ UsosLoginManagerTest.class, UsosManagerSeleniumTest.class, UsosMarksManagerTest.class, AllUsosHelperTests.class })
public class AllUsosTests {

} 
