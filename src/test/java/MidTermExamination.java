import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MidTermExamination {

    //Method-Q3

    public static void commonValues(String[] inputA , String[] inputB ){

        boolean commonValuesPresent = false;
        ArrayList<String> commonValues = new ArrayList<>();

        for (String valA : inputA){
            for (String valB : inputB) {
                if (valA.equalsIgnoreCase(valB)) {
                    commonValues.add(valB);
                    commonValuesPresent = true;
                }
            }
        }
        if (!commonValuesPresent){
            System.out.println("There are no common values");
        } else {
            System.out.println("\nCommon Values --> " + commonValues);

        }
    }

    // Method-Q4

    public static int missingSmallestPositiveInteger(int[] input) {

        for(int i = 0 ; i < input.length ; i++){ //  input -> Ascending order and find missmin
            int minimumIndex = i ;

            for (int j = i+1 ; j < input.length ; j++){
                if(input[minimumIndex] > input[j])
                    minimumIndex = j ;
            }
            int val = input[i];
            input[i] =input[minimumIndex];
            input[minimumIndex] = val;
        }

        int smallestMissingValue = 1;
        for(int i = 0 ; i < input.length ; i++){
            if(input[i] == smallestMissingValue)
                smallestMissingValue++;
            else if (input[i] > smallestMissingValue)
                break;;
        }
        return smallestMissingValue;
    }

    //Method-Q2

    public static long getFactorial (int input){
        long factorial = 1 ;                    //

        for(int i = input ; i > 1 ;i--){

            factorial = factorial * i;

        }
        return factorial;
    }

   // f = 1;
   // f = f * i => 1 * 5 = 5; => 5
   // f = f * i => 5 * 4 = 20; => 5 * 4
   // f = f * i => 20 * 3 = 60  => 5 * 4 * 3


    public static void main(String[] args) {

        //Q2

        int inputNumber = 5;

        System.out.println( inputNumber + "! = " + getFactorial(inputNumber));

        //Q3

        String[] inputA = {"happY", "king", "peace", "living standard"};
        String[] inputB = {"king kong", "Happy", "PEACE"};

        commonValues(inputA,inputB);


        //Q4

        int[] input = {3, 5, 1, 4, 2, 7};

        int missingPosInt = missingSmallestPositiveInteger(input);

        System.out.println("\nMissing Smallest Positive Integer is " + missingPosInt);


    }
@Test
    public void isTempValueIsCorrect(){

        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
        MyDriver.getDriver().manage().window().maximize();

        WebElement feelsLikeTempLocator = MyDriver.getDriver().findElement(By.xpath("//span[contains(text() ,'Feels Like')]/following-sibling::*"));
        String feelsLikeTemperatureValue = feelsLikeTempLocator.getText();
        String feelsLikeTempDegRemoved = feelsLikeTemperatureValue.substring(0,feelsLikeTemperatureValue.length()-1);
        int feelsLikeTempValInInt = Integer.parseInt(feelsLikeTempDegRemoved);

        WebElement lowTempLocator = MyDriver.getDriver().findElement(By.xpath("//span[@class='low-temp-text']"));
        String lowTemperatureValue = lowTempLocator.getText();
        String lowTempDegRemoved = lowTemperatureValue.substring(0,feelsLikeTemperatureValue.length()-1);
        int lowTempValInInt = Integer.parseInt(lowTempDegRemoved);

        WebElement highTempLocator = MyDriver.getDriver().findElement(By.xpath("//span[@class='high-temp-text']"));
        String highTemperatureValue = highTempLocator.getText();
        String highTempDegRemoved = highTemperatureValue.substring(0,feelsLikeTemperatureValue.length()-1);
        int highTempValInInt = Integer.parseInt(highTempDegRemoved);

        boolean isTempCorrect = (lowTempValInInt <= feelsLikeTempValInInt && feelsLikeTempValInInt <= highTempValInInt);
        Assert.assertTrue(isTempCorrect,"Feels Like temperature is not in the range");
        MyDriver.quitWindow();


    }



}
