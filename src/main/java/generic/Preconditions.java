package generic;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Preconditions {

	public static void verifyUrl(String link) {
		
	try {
		

		URL url = new URL(link);

		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.connect();
		
		if (httpCon.getResponseCode()==200) {
			System.out.println(link+" "+httpCon.getResponseMessage());
		}else {
			System.out.println(link+" "+httpCon.getResponseMessage());
		}
		
	} catch (Exception e) {
		System.out.println("handled");
	}


	}

	@Test
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			WebElement link = links.get(i);
			String linkk = link.getAttribute("href");
			verifyUrl(linkk);
		}
		
		
	}
	
}
