package suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.automation.tests.LoginTest;
import com.automation.tests.BasicTest;

@Suite
@SelectClasses({
        LoginTest.class,
        BasicTest.class
})

public class TestSuite {
}
