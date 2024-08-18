package homeassignment4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionclassusingbigbasket {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//span[text()='Shop by'])[2]")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		WebElement element2 = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
        act.moveToElement(element2).perform();
        WebElement element3 = driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']"));
        act.click(element3).perform();
        WebElement element4 = driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']"));
        act.click(element4).perform();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> window=new ArrayList<String>(windowHandles);
        String title = driver.switchTo().window(window.get(1)).getTitle();
        System.out.println(title);
        WebElement element5 = driver.findElement(By.xpath("(//div[@class='flex justify-start w-full h-full'])[5]"));
        act.click(element5).perform();
        String a= driver.findElement(By.xpath("//h1[@class='Description___StyledH-sc-82a36a-2 bofYPK']")).getText();
        System.out.println(a);
        WebElement element6 = driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]"));
        act.click(element6).perform();
        Thread.sleep(500);
        String text = driver.findElement(By.xpath("//p[@class='mx-4 flex-1']")).getText();
        if(text.contains("added"))
        {
        System.out.println(text);
        }
        else
        {
        	System.out.println("Item not added");
        }
        File src= driver.getScreenshotAs(OutputType.FILE);
        File dest=new File("./Screenshot/bbimg.png");
        FileUtils.copyFile(src, dest);
        driver.close();
        driver.quit();
	}

}
