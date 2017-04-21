package usos.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import usos.helper.mark.AllUsosHelperMarkTests;

@RunWith(Suite.class)
@SuiteClasses({ SemesterTest.class, SubjectTest.class, TypeOfClassTest.class, AllUsosHelperMarkTests.class })
public class AllUsosHelperTests {

}
