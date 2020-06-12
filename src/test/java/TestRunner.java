import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefs"},
//        tags = {"~@Ignore"},
        plugin = {
                "pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "html:target/cucumber-reports/cucumber/"
        })
public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
		testNGCucumberRunner.runScenario(pickle.getPickle());
	}
	@DataProvider
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass(){
		testNGCucumberRunner.finish();
	}
}
