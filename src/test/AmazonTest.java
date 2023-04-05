package test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement searchBox=driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		searchBox.sendKeys("samsung mobile");
		
		WebElement submitButton=driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
		submitButton.submit();
		
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@data-component-type=\"s-search-result\"]"));
		
		for(WebElement element: searchResults) {
						
			WebElement nameElement = element.findElement(By.xpath(".//h2//span"));
			System.out.println("Name: "+ nameElement.getText());

			WebElement priceElement = element.findElement(By.xpath(".//a//span[@class=\"a-price\"]"));
			System.out.println("Price: "+ priceElement.getText());
			
		}
		
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("amazonScreeShot.png");
		FileUtils.copyFile(fileObj,screenshotObj);
		
		driver.close();
	}

}
