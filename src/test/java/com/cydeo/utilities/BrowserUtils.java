package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

//   This class will be storing only the utility methods that can be used across the Project

    //1. This method will accept int(in seconds)
// and execute Thread.sleep method for given duration
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
        }
    }


/*TC #2: Create utility method
1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle

 */

    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle) {
        Set<String> windows = Driver.getDriver().getWindowHandles();

        for (String eachWindow : windows) {
            Driver.getDriver().switchTo().window(eachWindow);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }
//   Assert: Title contains “Etsy
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }
//3. TC #3: Create utility method
//1. Create a new method for title verification
//2. Create a method to make title verification logic re-usable
//3. When method is called, it should simply verify expected title with actual
//title

//Method info:
//• Name: verifyTitle()
//• Return type: void
//• Arg1: WebDriver
//• Arg2: String expectedTitle

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals( Driver.getDriver().getTitle(), expectedTitle );

    }

    public static void verifyContainTitle(String expectedInTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    //this method help me to see if specifique element will apear after“loading bar disappears
    public static void waitForInvisibilityOff(WebElement target) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));

    }

    //This method accept String title, and waits for Title to contain given String value
    public static void waitForTitleContains(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));


    }

    /**
     * this method accepts a dropdown element and returns a List<String>that contains all options values as String
      * @param dropdown
     * @return
     */


    public static List<String>dropdownOptions_asSTRING(WebElement dropdown) {

        Select month = new Select(dropdown);
//Storing all the Actual options into a List of WebElements
        List<WebElement> actualResult_as_WebElement =  month.getOptions();
//Creating an Empty list of String to store Actual <option> as String
        List<String> actualMonthsAsString = new ArrayList<>();

//Looping through the List<WebElement>,getting all options texts, and storing them into List<String>
        for (WebElement each : actualResult_as_WebElement) {actualMonthsAsString.add(  each.getText());
        }
        return actualMonthsAsString;

    }

}