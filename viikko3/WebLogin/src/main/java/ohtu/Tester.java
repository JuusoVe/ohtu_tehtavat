package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\ChromeDriver\\ChromeDriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4567");
        
        sleep(2);
        
        // Creating a new user
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        sleep(2);
        
        Random r = new Random();
        element = driver.findElement(By.name("username"));
        element.sendKeys("uusi"+r.nextInt(999999));
        element = driver.findElement(By.name("password"));
        element.sendKeys("Salainen1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("Salainen1");
        sleep(2);
        element.submit();
        
        // Logging out after creating new user
        sleep(2);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        sleep(2);
        
        
        
        
        
        /*
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);
        */
        
        /*
        // Failed login due to wrong password
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("wrong");
        element = driver.findElement(By.name("login"));
        */
        
        /*
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        */

        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
