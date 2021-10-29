package week4.day2assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brand).perform();
		WebElement paris=driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		paris.sendKeys("L'Oreal Paris", Keys.ENTER);
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(paris).perform();
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		String title= driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		String string = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		System.out.println(string);
		driver.findElement(By.xpath("//div[@class='css-d5z3ro']")).click();
		//driver.getWindowHandles();
		//WebElement element = driver.findElement(By.xpath("//select[@title='SIZE']"));
		//Select select = new Select(element);
		//select.selectByIndex(0);
		String string1 = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling:: span[1]")).getText();
		System.out.println(string1);
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		WebElement ele = driver.findElement(By.xpath("//iframe[@src='/mobileCartIframe?ptype=customIframeCart']"));
		driver.switchTo().frame(ele);
		String text3 = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("Total Amount="+text3);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		String text4 = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div/span")).getText();
		System.out.println("Total Price"+text4);
		driver.quit();
	}

}
