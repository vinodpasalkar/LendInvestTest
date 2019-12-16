package net.webtestautomation;


import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AcceptanceTestSuite extends SerenityStories {

	
    @Managed(uniqueSession = false)
    public static WebDriver webDriver;

    @BeforeStory
    public void beforeStory() {
    	 System.out.println("--- Before Story Starts---");
    }
        
    
    @BeforeStories
    public void startWebDriver() {
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }

    @AfterStory
    public void afterStory() {
    	System.out.println("--- After Story Ends---");
    }
    
    @AfterStories
    public  void stopWebDriver() {
        this.webDriver.quit();
    }
    
  
        
}
