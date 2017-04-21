package usos.helper.mark;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import usos.helper.mark.strategy.AllUsosMarkStrategyTests;

@RunWith(Suite.class)
@SuiteClasses({ MarkFactoryTest.class, MarkTest.class, AllUsosMarkStrategyTests.class })
public class AllUsosHelperMarkTests {

}
