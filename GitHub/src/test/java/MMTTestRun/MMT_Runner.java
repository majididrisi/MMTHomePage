package MMTTestRun;


import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/MMTFeature/",
        glue = "MMTSteps",
   //     dryRun = true,
       // monochrome = true,
       tags = "@Visa"
        
       // plugin = {"pretty", /*"usage",*/ "json:target/Myreports/report.json", "junit:target/Myreports/report.xml", }
        )
public class MMT_Runner extends AbstractTestNGCucumberTests {

}
