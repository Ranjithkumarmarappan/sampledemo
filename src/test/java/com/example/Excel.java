package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Durations;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel{
    @Test
    public void test() throws AWTException,InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
         WebElement username= driver.findElement(By.xpath("//input[@placeholder='Username']"));
         username.click();
         username.sendKeys("Admin");
         WebElement password  = driver.findElement(By.xpath("//input[@placeholder='Password']"));
         password.click();
         password.sendKeys("admin123");
        WebElement element = driver.findElement(By.xpath("//button[starts-with(@class,'oxd-button')]"));
        element.click();
        // js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        WebElement element3 = driver.findElement(By.xpath("(//span[starts-with(@class,'oxd-text')])[2]"));
        element3.click();
        Thread.sleep(2000);
       WebElement click=  driver.findElement(By.xpath("//span[contains(text(),'Configuration')]"));
       click.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(By.xpath("//a[contains(text(),'Data Import')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Browse')]")).click();
        Thread.sleep(3000);

         StringSelection str = new StringSelection("C:\\Users\\manir\\Downloads\\RanjithCV.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);

         r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
        
         r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

        
        
    }
}