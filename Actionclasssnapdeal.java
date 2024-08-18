package homeassignment4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionclasssnapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement Menfashion = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]"));
        Actions act=new Actions(driver);
        act.moveToElement(Menfashion).perform();
        WebElement sportshoe = driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));
        act.click(sportshoe).perform();
        String totalsportshoe = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
        System.out.println(totalsportshoe);
        WebElement element = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
        act.click(element).perform();
        List<WebElement> beforesort = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
        List<Integer> value=new ArrayList<Integer>();
        for (int i = 0; i < beforesort.size(); i++) {
        	String attribute = beforesort.get(i).getAttribute("data-price");
                	value.add(Integer.parseInt(attribute));
                	Collections.sort(value);
		}
        System.out.println(value);
          //value.
        driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
        driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
        List<Integer> aftersort=new ArrayList<Integer>();
        for (int i = 0; i < elements.size(); i++) {
         	String attribute = elements.get(i).getAttribute("display-price");
        	aftersort.add(Integer.parseInt(attribute));
        	}
          System.out.println(aftersort);
          if(aftersort.equals(value))
          {
        	  System.out.println("Posting sorting values are equal");
          }
          else
          {
        	  System.out.println("Value are not equal");
          }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
        driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("500");
        driver.findElement(By.xpath("//input[@name='toVal']")).clear();
        driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("700");
        driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()=' White & Blue']/parent::label")).click();
        Thread.sleep(3000);
        act.moveToElement(driver.findElement(By.xpath("//img[@class='product-image wooble']"))).perform();
		Thread.sleep(3000);
     
        driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
        String text1 = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
		System.out.println("The cost and the discount percentage is: " +text1);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/snapdeal.png");
        FileUtils.copyFile(src, dest);
        driver.quit();
	}

}
