package homeassignment4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionclassusingAmazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
        String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
        System.out.println("The prize of first product is : "+text);
        
        WebElement element = driver.findElement(By.xpath("(//i[@data-cy='reviews-ratings-slot'])[1]"));
        Actions act=new Actions(driver);
        act.click(element).perform();
        String text2 = driver.findElement(By.xpath("(//span[@data-hook='acr-average-stars-rating-text'])[1]")).getText();
        System.out.println("The ratings provided by the user is : "+text2);
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        Set<String> page = driver.getWindowHandles();
		List<String> window=new ArrayList<String>(page);
		String page2title = driver.switchTo().window(window.get(1)).getTitle();
		System.out.println("The title of page2 is: "+page2title);
       
        File src = driver.getScreenshotAs(OutputType.FILE);
        File dest=new File("./Screenshot/amazon.png");
        FileUtils.copyFile(src, dest);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
 
        Thread.sleep(5000);
        String text3 = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
        System.out.println("The amount in cart is: "+text3);
        if(text3.contains(text))
        {
        	System.out.println("The prize is same is summary and cart");
        }
        else
        {
        	System.out.println("The prize is differnt");
        }
        
      driver.close();
	}

}
