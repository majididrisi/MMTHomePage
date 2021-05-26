package options;
	import org.junit.runner.RunWith;

	import cucumber.api.CucumberOptions;
	import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(
	        features = "src/test/java/Feature/",
	        glue = "LoginNegative"
   //     dryRun = true,
//	        monochrome = true
//	        format =pretty
       // tags = "@Majid"
	        )

	 

	public class TestRun2 {
	    

	 

	}


