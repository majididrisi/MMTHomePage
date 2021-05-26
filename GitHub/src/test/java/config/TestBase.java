package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestBase {
	    public static WebDriver driver;
	    public static Properties prps;
	    
	        
	    public TestBase() {        
	            try {
	                prps = new Properties();
	                FileInputStream ip = new FileInputStream("C:\\Users\\Sajid\\eclipse-workspace\\Sprint2\\src\\test\\java\\config\\prop.properties");
	                prps.load(ip);
	            } catch(FileNotFoundException e) {
	                e.printStackTrace();
	            }
	            catch (IOException e) {
	                e.printStackTrace();
	            }    
	    }
	}
