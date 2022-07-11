package com.company;

import Utils.CompanyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class Irachatbot extends CompanyUtils {


    public void launchBrowser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.setProperty(webDriver, webDriver_Location);
        driver.navigate().to(url_Test);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //WELCOME PAGE
        String getTitle = driver.findElement(By.cssSelector(css_Selector_Welcome)).getText();
        if (getTitle.contains("Test agent - IRA"))
            System.out.println(TEST_STEP_PASSED + getTitle);
        else
            System.out.println(TEST_STEP_FAILED + getTitle);
        //click on start button
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(css_Selector_Welcome))).perform();
        action.click(driver.findElement(By.cssSelector(css_Selector_Welcome))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.cssSelector(css_Selector_Bot_Start))).perform();
        action.click(driver.findElement(By.cssSelector(css_Selector_Bot_Start))).perform();
        Thread.sleep(2000);
        System.out.println("Clicked on Start button");
        WebElement chatBot = driver.findElement(By.cssSelector(getCss_Selector_Iframe));
        driver.switchTo().frame(chatBot);
        String getMenuOption = driver.findElement(By.cssSelector("#bot-menu-container > div.botMenu.dflex.ptr > div")).getText();
        if (getMenuOption.equalsIgnoreCase("Menu options"))
            System.out.println(TEST_STEP_PASSED + getMenuOption);
        else
            System.out.println(TEST_STEP_FAILED + getMenuOption);


        WebElement startOver = driver.findElement(By.cssSelector(getCss_Selector_Menu_Container));
        action.moveToElement(startOver).perform();
        action.click(startOver).perform();
        Thread.sleep(2000);
        System.out.println(TEST_STEP_PASSED + "Clicked on start Over");


        WebElement downloadMotarPolicy = driver.findElement(By.id("messages-list"));
        action.moveToElement(downloadMotarPolicy.findElement(By.linkText("Download Motor Policy"))).perform();
        action.click(downloadMotarPolicy.findElement(By.linkText("Download Motor Policy"))).perform();
        Thread.sleep(2000);
        String vBaseWindowHandle = driver.getWindowHandle();
        System.out.println(TEST_STEP_PASSED + "Clicked on Download Motor Policy");

        action.moveToElement(downloadMotarPolicy.findElement(By.linkText("Download"))).perform();
        action.click(downloadMotarPolicy.findElement(By.linkText("Download"))).perform();
        Thread.sleep(5000);
        System.out.println(TEST_STEP_PASSED + "Clicked on Download");

        driver.switchTo().window(vBaseWindowHandle);
        driver.switchTo().frame(chatBot);

        driver.findElement(By.id("queryTextbox")).sendKeys("Test Bot");

        action.click(driver.findElement(By.xpath("//*[@id=\"messageEditor-region\"]/div/div[3]/button[2]"))).perform();
        action.click(driver.findElement(By.xpath("//*[@id=\"messageEditor-region\"]/div/div[3]/button[2]"))).perform();
        Thread.sleep(5000);
        System.out.println(TEST_STEP_PASSED + "Typed Test Bot and clicked sent");
        //filling the form
        driver.findElement(By.xpath("//input[contains(@class,\"textbox avm_accessible_txt\")]")).sendKeys("Shreya Srivastava");
        driver.findElement(By.xpath("//textarea")).sendKeys("112233 ," + "\n" + " DNR ATMOSPHERE , Ramagodanhalli ," + "\n" + " Bengaluru");
        driver.findElement(By.xpath("//label[2]/span[1]")).click();
        action.moveToElement(driver.findElement(By.xpath("//input[contains(@id,\"picklist\")]"))).perform();
        action.click(driver.findElement(By.xpath("//input[contains(@id,\"picklist\")]"))).perform();
        action.moveToElement(driver.findElement(By.xpath("//ul/li[2]"))).perform();
        driver.findElement(By.xpath("//ul/li[2]")).click();
        driver.findElement(By.xpath("//label[3]")).click();
        driver.findElement(By.xpath("//div/div[3]/button")).click();
        Thread.sleep(5000);
        System.out.println(TEST_STEP_PASSED + "Form filled successfully");

        driver.findElement(By.id("queryTextbox")).sendKeys("New Test");
        action.click(driver.findElement(By.xpath("//*[@id=\"messageEditor-region\"]/div/div[3]/button[2]"))).perform();
        action.click(driver.findElement(By.xpath("//*[@id=\"messageEditor-region\"]/div/div[3]/button[2]"))).perform();
        action.click(driver.findElement(By.xpath("//div/div[2]/a[contains(text(),\"Google\")]"))).perform();
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath(" //*[@id=\"webview_body\"]/div/div[1]/button"))).perform();
        Thread.sleep(2000);
        System.out.println(TEST_STEP_PASSED + "Test executed successfully");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        Irachatbot iraChatBot = new Irachatbot();
        iraChatBot.launchBrowser();
    }
}
