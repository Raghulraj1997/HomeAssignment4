package homeassignment4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
       // driver.findElement(By.name("USERNAME")).sendKeys("DemoSalesManager");
        //driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
        //driver.findElement(By.xpath("(//input[@class='loginButton'])[1]")).click();
        driver.findElement(By.xpath("//a[text()='Contacts']")).click();
        driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> wind=new ArrayList<String>(windowHandles);
        String title2 = driver.switchTo().window(wind.get(1)).getTitle();
        System.out.println(title2);
        driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
        driver.switchTo().window(wind.get(0));
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
        Set<String> window2 = driver.getWindowHandles();
        List<String> wind2=new ArrayList<String>(window2);
        driver.switchTo().window(wind2.get(1));
        driver.findElement(By.xpath("//a[text()='dp1a1contact2']")).click();
        driver.switchTo().window(wind2.get(0));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println(title);
        driver.close();
        
        
	}

}
