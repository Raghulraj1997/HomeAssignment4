package homeassignment4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Framevalidation {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
        //User cancelled the prompt.
        if(text.equals("User cancelled the prompt."))
        {
        	System.out.println("The message is printed after clicking dismiss button");
        }
        else
        {
        	System.out.println("Failed to click dismiss button");
        }
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        Alert alert1 = driver.switchTo().alert();
        alert1.sendKeys("Adding");
        alert1.accept();
        String element = driver.findElement(By.xpath("//p[@id='demo']")).getText();
        if(element.contains("Adding"))
        {
        	System.out.println("Clicked Accept button");
        }
        else
        {
        	System.out.println("fail to click accept button");
        }
        driver.close();
	}
   
}
