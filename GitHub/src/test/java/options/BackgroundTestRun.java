package options;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature/ParametrizeProduct.feature",
        glue = "StepDefinitions"
   //       dryRun = true
//        monochrome = true
//        format =pretty
//        tags = "@SmokeTest"
        )

public class BackgroundTestRun {

}
