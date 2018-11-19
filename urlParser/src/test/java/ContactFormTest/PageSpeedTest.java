package ContactFormTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.List;

public class PageSpeedTest {
    WebDriver driver;
    WebDriverWait wait;
    WebDriverWait wait2;

    @BeforeMethod
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 60);
        wait2 = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.get("https://developers.google.com/speed/pagespeed/insights/");
    }

    /*@AfterMethod
    public void finishTest(){
        driver.quit();
    }*/

    @Test
    public void getPageSpeed(){

        WebElement inputField = driver.findElement(By.cssSelector("input[name=\"url\"]"));
        inputField.sendKeys("http://icm-dev.itwcorp2.info/");
        driver.findElement(By.cssSelector("div[class=\"analyze-cell\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"report-summary\"]")));
//        wait2.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"progress-bar-horizontal\"]"))));

        List<WebElement> res = driver.findElements(By.cssSelector(".lh-gauge__percentage"));
//        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div")).click();

        wait2.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"progress-bar-horizontal\"]"))));
        res.add(driver.findElement(By.cssSelector(".result-container > *:nth-child(2) div[class=\"lh-gauge__percentage\"]")));

//        int mobileSpeed = Integer.valueOf(res.get(0).getText());
//        int desktopSpeed = Integer.valueOf(res.get(1).getText());
        for (WebElement i:res) {
            System.out.println(i.getText());
        }
//        System.out.println(mobileSpeed);
//        System.out.println(desktopSpeed);

//        SoftAssert softAsert = new SoftAssert();
//        softAsert.assertTrue(mobileSpeed >= 90);
//        softAsert.assertTrue(desktopSpeed >= 90);
//        softAsert.assertAll();








    }




}
