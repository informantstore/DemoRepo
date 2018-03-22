package packt.selenium.chap3_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

/**
 * Created by Ripon on 11/4/2015.
 */
public class WebDriverDocumentation_04Test {
    private WebDriver driver;
    private SeleniumHQ seleniumHQ;
    private Documentation documentationPage;

    @Before
    public void setUp() throws Exception {
    	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ShivamGupta\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testVerifyTitle_WebDriverDocumentation() throws Exception {
        seleniumHQ = new SeleniumHQ(driver);
        Documentation documentationPage = seleniumHQ.clickDocumentation();
        WebDriverDocumentation webDriverDocumentation = documentationPage.navigateToWebDriverDocumentation();

        String actualTitle = driver.getTitle();
        String expectedTitle = "xxSelenium WebDriver — Selenium Documentation";
        assertEquals(expectedTitle, actualTitle);
    }
}