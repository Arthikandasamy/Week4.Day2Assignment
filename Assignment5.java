package week4.day2assignment;

import java.io.File;
import java.io.IOException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5 {
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		driver.findElement(By.className("a-price-whole"));
		List<String> price = new ArrayList<String>();
		System.out.println(price);
		List<WebElement> reviews = driver.findElements(By.xpath("//span[@class='a-size-base']"));
		String text2 = reviews.get(0).getText();
		System.out.println("Review Count of First Product is:" + text2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom'])[1]")).click();
		WebElement table = driver.findElement(By.xpath("//table[@id='histogramTable']/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("Number of Rows:"+rows.size());
		List<WebElement> column = rows.get(0).findElements(By.tagName("td"));
		String text3 = column.get(2).getText();
		System.out.println("Five Star Rating % is :"+text3);
		List<WebElement> link = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		link.get(0).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lst.get(1));
		WebElement src = driver.findElement(By.xpath("(//img[@class='a-dynamic-image a-stretch-horizontal'])[1]"));
		File screenshotAs = src.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/pic3.png");
		FileUtils.copyFile(screenshotAs, dest);
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		}
}