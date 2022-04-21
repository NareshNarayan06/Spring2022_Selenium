package SeleniumHomeWorks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomeWorkSelenium_1 {

    @Test
public void launchAmAzOnWeb (){

    System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");

    WebDriver driver = new ChromeDriver();

    driver.get("https://www.amazon.com/");

    driver.close();

}

}
