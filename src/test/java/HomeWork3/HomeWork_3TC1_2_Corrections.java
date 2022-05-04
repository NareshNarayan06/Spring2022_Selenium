package HomeWork3;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeWork_3TC1_2_Corrections {


        @Test
        public void isTempValCorrect(){

            MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");

            MyDriver.getDriver().manage().window().maximize();

            By tempValLocator = By.xpath("//span[contains(text() ,'Feels Like')]/following-sibling::*");
            WebElement tempValElement = MyDriver.getDriver().findElement(tempValLocator);
            String TempValDisplayedF = tempValElement.getText();
            String TempValDisplayedFDegRemoved = TempValDisplayedF.substring(0,TempValDisplayedF.length()-1);
            double fahrenheitTempVal = Integer.parseInt(TempValDisplayedFDegRemoved);

            By dropDownLocator = By.xpath("(//span[contains(text(),'F,')]//following-sibling::b[@class='button'])[1]");
            WebElement dropDownElement = MyDriver.getDriver().findElement(dropDownLocator);
            dropDownElement.click();

            Misc.pause(2);

            By selectingCelsiusLocator = By.xpath("(//li[contains(text(),'m/s') and @data-index='1'])[1]");
            WebElement selectingCelsiusElement = MyDriver.getDriver().findElement(selectingCelsiusLocator);
            selectingCelsiusElement.click();

            Misc.pause(2);

            By tempValLocatorAfterC = By.xpath("//div[@id='title']//span[@class='feels-like-text']");
            WebElement tempValCElement = MyDriver.getDriver().findElement(tempValLocatorAfterC);
            String tempValCInString = tempValCElement.getText();
            String tempValCStringRemovalDegree = tempValCInString.substring(0,tempValCInString.length()-1);
            double celsiusTempVal = Integer.parseInt(tempValCStringRemovalDegree);

            double actualTempValInCUsingF = (int)Math.round((fahrenheitTempVal-32)*5/9);
            double actualTempValInFUsingC =(int) Math.round((celsiusTempVal * 9/5 )+ 32 );

            Assert.assertEquals(actualTempValInCUsingF,celsiusTempVal,"The conversion is incorrect");
            Assert.assertEquals(actualTempValInFUsingC,fahrenheitTempVal,"The conversion is incorrect");

            MyDriver.quitWindow();
        }
    @Test
    public void verifyCurrentDateIsPresent(){

        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        By createButtonLocator = By.xpath("//a[contains(.,'Create new account')]");
        WebElement createButtonElement = MyDriver.getDriver().findElement(createButtonLocator);
        createButtonElement.click();
        Misc.pause(3);

        MyDriver.getDriver().manage().window().maximize();

        SimpleDateFormat sdFormatMonth = new SimpleDateFormat("MMM");
        Date now = new Date();
        String month = sdFormatMonth.format(now);

        By monthLocator = By.xpath("//select[@id='month']//option[@selected='1']");
        WebElement monthLocatorElement = MyDriver.getDriver().findElement(monthLocator);
        String monthTextValue = monthLocatorElement.getText();

        Assert.assertEquals(month,monthTextValue,"Current month is not present");

        SimpleDateFormat sdFormatDay = new SimpleDateFormat("d");
        String day = sdFormatDay.format(now);

        By dayLocator = By.xpath("//select[@id='day']//option[@selected='1']");
        WebElement dayLocatorElement = MyDriver.getDriver().findElement(dayLocator);
        String dayTextValue = dayLocatorElement.getText();

        Assert.assertEquals(day,dayTextValue,"Current day is not present");

        SimpleDateFormat sdFormatYear = new SimpleDateFormat("yyyy");
        String year= sdFormatYear.format(now);

        By yearLocator = By.xpath("//select[@id='year']//option[@selected='1']");
        WebElement yearLocatorElement = MyDriver.getDriver().findElement(yearLocator);
        String yearTextValue = yearLocatorElement.getText();

        Assert.assertEquals(year,yearTextValue,"Current year is not present");

        MyDriver.quitWindow();
    }

    }
