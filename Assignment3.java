package week4.day2assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[text()='Men's Fashion']")).click();
		WebElement ele=driver.findElement(By.xpath("//span[text()='Sports Shoes'])[1]"));
		Select listBox=new Select(ele);
		
		int size=listBox.getOptions().size();
	}

}
