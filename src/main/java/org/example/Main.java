package org.example;

import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        Random randomGenerator= new Random();
        int randomInt = randomGenerator.nextInt(1000);
        driver.get("https://www.walgreens.com/request_error.jsp?redirect=/&quot");
        System.out.println(driver.getTitle());
        if(driver.getTitle().equalsIgnoreCase("We're Sorry | Page Not Found | Walgreens")) {
            System.out.println("Correct URL");
        } else {
            System.out.println("Incorrect URL");
        }
        driver.get("https://qa.taltektc.com/home/login");
        driver.manage().window().maximize();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }

        driver.findElement(By.partialLinkText("Create")).click();
        WebElement element= driver.findElement(By.xpath("//form[@id='signup-form']/legend"));
        System.out.println(element.getText());
        Assert.assertEquals(element.getText(), "Sign Up");

        WebElement element2= driver.findElement(By.xpath("//form[@id='signup-form']/h4"));
        System.out.println(element2.getText());
        Assert.assertEquals(element2.getText(), "It's free and always will be.");


        driver.findElement(By.xpath("//form[@id='signup-form']/div[3]/div[1]/input[@name='firstName']")).sendKeys("Angela");
        driver.findElement(By.xpath("//form[@id='signup-form']/div[3]/div[2]/input[@name='lastName']")).sendKeys("mehri");
        WebElement emailElement = driver.findElement(By.xpath("//form[@id='signup-form']/input[1][@name='email']"));
        emailElement.sendKeys("username"+ randomInt + "@gmail.com");
        driver.findElement(By.xpath("//form[@id='signup-form']/input[2][@name='password']")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[placeholder='Confirm Password']")).sendKeys("12345");
        WebElement el = driver.findElement(By.xpath("//form[@id='signup-form']/div[4]/div[1]/select[@name='month']"));
        Select select = new Select(el);
        select.selectByVisibleText("Feb");

        WebElement el1 = driver.findElement(By.xpath("//form[@id='signup-form']/div[4]/div[2]/select[@name='day']"));
        Select sel = new Select(el1);
        sel.selectByIndex(9);

        WebElement el2 = driver.findElement(By.xpath("//form[@id='signup-form']/div[4]/div[3]/select[@name='year']"));
        Select sel2 = new Select(el2);
        sel2.selectByValue("1993");

        driver.findElement(By.xpath("//form[@id='signup-form']/label[3]/input[@id='male']")).click();
        driver.findElement(By.xpath("//form[@id='signup-form']/label[4]/input[@id='female']")).click();
        driver.findElement(By.xpath("//form[@id='signup-form']/div[5]/input[@id='defaultCheck1']")).click();
        driver.findElement(By.xpath("//form[@id='signup-form']/button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@id='page-content-wrapper']/nav/div/ul/li[2]/a[@class='nav-link']")).click();
        driver.findElement(By.xpath("//form[@id='login_form']/input[1][@class='ttc_email']")).sendKeys("angelamehri@gmail.com");
        driver.findElement(By.xpath("//form[@id='login_form']/input[2][@class='ttc_password']")).sendKeys("12345");
        driver.findElement(By.xpath("//form[@id='login_form']/input[3][@class='my-login']")).click();
        driver.wait(2000);

        driver.close();

    }
}