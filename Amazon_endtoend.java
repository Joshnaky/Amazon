package Amazon;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_endtoend {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\eclipse-workspace\\Selenium_Java\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement signin = driver.findElement(By.id("nav-link-accountList"));
		signin.click();
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("kyeshk@gmail.com");
		WebElement cont = driver.findElement(By.id("continue"));
		cont.click();
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("Yesh@2207");
		WebElement signbtn = driver.findElement(By.id("signInSubmit"));
		signbtn.click();
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("One plus 9");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()=\"OnePlus 9 5G (Arctic Sky, 8GB RAM, 128GB Storage)\"]")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
