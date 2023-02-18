package com.cydeo.step_Definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {  // in this class we will be able to create "pre" and "post" condition for ALL the SCENARIOS and even STEPS FROM OUR  PROJECT

  @Before   // import @Before coming from io.cucumber.java
public  void setup(){
System.out.println("----> @setUp before each SCENARIOS");
}




                        /**screenshot custom method*/
         @After   // import @After coming from io.cucumber.java
         public void teardownMethod(Scenario scenario) { // take screenshot method
         if (scenario.isFailed()){ // if one of our scenarios failed then take a screenshot
         byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
         scenario.attach(screenshot, "image/png", scenario.getName());
         }





         System.out.println("---->@After running after each SCENARIOS");
             BrowserUtils.sleep(3);
             Driver.closeDriver();// it wil open me the browser wich i am  using
   }




/*
----> @Before each SCENARIOS
User is on the login page of the Library application.
User enters librarian username.
User enters librarian password.
User sees the dashboard
@After running for each SCENARIOS
----> @Before each SCENARIOS

 */
//@BeforeStep
    public static void beforeStep(){
    System.out.println("---->@BeforeStep running before each steps");
}
//@AfterStep
    public static void teardownAfterStep(){
    System.out.println("---->@AfterStep running after each steps");
}
}
