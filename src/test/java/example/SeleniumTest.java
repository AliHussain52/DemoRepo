package example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SeleniumTest {

	WebDriver driver;

	@Test
	public void seleniumTest() throws IOException, InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\ALI HUSSAIN\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ALI HUSSAIN\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/autoit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("postjob")).click();

		driver.switchTo().frame("JotFormIFrame-72320244964454");

		driver.findElement(By.id("input_3")).sendKeys("Ali Hussain");
		driver.findElement(By.id("input_4")).sendKeys("test.test@gmail.com");
		driver.findElement(By.id("input_5")).click();

		Thread.sleep(2000);
		// below line execute the AutoIT script .
		Runtime.getRuntime().exec("C:\\Users\\ALI HUSSAIN\\Downloads\\FileUpload.exe");

		driver.findElement(By.id("input_6")).sendKeys("AutoIT in Selenium");

		if (driver.findElement(By.id("input_2")).isDisplayed()) {
			driver.findElement(By.id("input_2")).click();
		}
		Assert.assertEquals(driver.findElement(By.xpath("//strong[contains(.,'Thank You!')]")).getText(), "Thank You!");

		driver.close();
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}
}
