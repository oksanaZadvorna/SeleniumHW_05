package SeleniumHW_05;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Task2 extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://chercher.tech/practice/frames";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);
        driver.switchTo().frame("frame1");

        driver.switchTo().frame("frame3");
        WebElement frame3 = driver.findElement(By.xpath("//input[@id='a']"));
        driver.findElement(By.id("a")).click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame2");
        WebElement animal = driver.findElement(By.xpath("//b[text()='Animals :']"));
        System.out.println(animal.getText());
        WebElement babycat = driver.findElement(By.xpath("//select[@id='animals']"));
        Select sel =new Select(babycat);
        sel.selectByVisibleText("Baby Cat");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame1");
        WebElement textBox = driver.findElement(By.xpath("//input"));
        textBox.sendKeys("entering the text");
        Thread.sleep(2000);

        driver.close();

    }
}
