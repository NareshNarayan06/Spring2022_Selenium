package HomeWork2;

import Helper.Misc;
import Web.MyDriver;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork {

    @Test
    public void verifyBttIsNotSelected(){

        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        String linkText = "Messenger";

        By locatorUsingLinkText = By.linkText(linkText);

        WebElement linkTextLocator = MyDriver.getDriver().findElement(locatorUsingLinkText);

        linkTextLocator.click();

        Misc.pause(5);

        String boxXpath = "//*[@class='_2qcu']";

        By locatorUsingXpath = By.xpath(boxXpath);

        WebElement boxXpathLocator = MyDriver.getDriver().findElement(locatorUsingXpath);

        boolean isBoxSelected = boxXpathLocator.isSelected();

        Assert.assertFalse(isBoxSelected,"'Keep me signed in ' is selected");

        MyDriver.getDriver().manage().window().maximize();

        String xpathLogin = "//button[text()='Log in']";

        By locatorUsingXpathTextLogIn = By.xpath(xpathLogin);

        WebElement LogInLocator = MyDriver.getDriver().findElement(locatorUsingXpathTextLogIn);

        LogInLocator.click();

        String messageXpath = "//div[text()='Incorrect email or phone number']";

        By locatorUsingMessageXpath = By.xpath(messageXpath);

        WebElement messageXpathLocator = MyDriver.getDriver().findElement(locatorUsingMessageXpath);

      // String getText= messageXpathLocator.getText();

        boolean isItDisplayed = messageXpathLocator.isDisplayed();

        Assert.assertTrue(isItDisplayed,"'Incorrect email or phone number' is not displayed");

        String nameValue = "login";

        By locatorUsingNameValue = By.name(nameValue);

        WebElement nameValueLocator = MyDriver.getDriver().findElement(locatorUsingNameValue);

        boolean isItEnabled = nameValueLocator.isEnabled();

       Assert.assertTrue(isItEnabled,"'Continue button' is not enabled");

       MyDriver.quitWindow();

    }

    @Test
    public void signUpBttEnabled (){

        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        String xpathOfCreateNewAcc = "//a[contains(@data-testid, 'open-registration')]";

        By locatorOfCreateNewAcc = By.xpath(xpathOfCreateNewAcc);

        WebElement createNewAccLocator = MyDriver.getDriver().findElement(locatorOfCreateNewAcc);

        createNewAccLocator.click();

        Misc.pause(5);

        MyDriver.getDriver().manage().window().maximize();

        String signUpNameMethod = "websubmit";

        By locatorOfNameMethod = By.name(signUpNameMethod);

        WebElement nameMethodLocator = MyDriver.getDriver().findElement(locatorOfNameMethod);

        boolean isItEnabled= nameMethodLocator.isEnabled();

        Assert.assertTrue(isItEnabled,"Sign-up button is not enabled");

        String firstNameValue = "firstname";

        By locatorOfNameValue = By.name(firstNameValue);

        WebElement nameValueLocator = MyDriver.getDriver().findElement(locatorOfNameValue);

        nameValueLocator.sendKeys("Naresh");

        String lastNameValue = "lastname";

        By locatorOfLastNameValue = By.name(lastNameValue);

        WebElement lastNameValueLocator = MyDriver.getDriver().findElement(locatorOfLastNameValue);

        lastNameValueLocator.sendKeys("Narayan");

        String xpathValueOfEmail = "//input[contains(@name , 'email__')]";

        By locatorOfXpathValueOfEmail = By.xpath(xpathValueOfEmail);

        WebElement xpathValueOfEmailLocator = MyDriver.getDriver().findElement(locatorOfXpathValueOfEmail);

        xpathValueOfEmailLocator.sendKeys("abc@test.com");

        String reEnterEmailVal = "//input[contains(@name,'email_confirm')]";

        By locatorOfReEnterEmailVal = By.xpath(reEnterEmailVal);

        WebElement reEnterEmailValLocator = MyDriver.getDriver().findElement(locatorOfReEnterEmailVal);

        reEnterEmailValLocator.sendKeys("abc@test.com");

        String passwordXpath = "//input[@data-type='password']";

        By locatorOfPassWordXpath = By.xpath(passwordXpath);

        WebElement passWordXpathLocator = MyDriver.getDriver().findElement(locatorOfPassWordXpath);

        passWordXpathLocator.sendKeys("123@cba");

        nameMethodLocator.click();

        Misc.pause(5);

        String xpathOfGenderMessage = "//div[contains(text() , '. You can change')]";

        By locatorOfGenderMessageXpath = By.xpath(xpathOfGenderMessage);

        WebElement genderMessageXpathLocator = MyDriver.getDriver().findElement(locatorOfGenderMessageXpath);

       boolean isMessageDisplayed = genderMessageXpathLocator.isDisplayed();

       Assert.assertTrue(isMessageDisplayed,"The message is not displayed");

       Misc.pause(5);

       MyDriver.quitWindow();




    }

}
