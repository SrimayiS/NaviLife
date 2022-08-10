package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public void capture(WebDriver driver,String testName) {
		
		String date = new Date().toString().replace(":", "_");
		
		TakesScreenshot TS = (TakesScreenshot) driver;
		File src = TS.getScreenshotAs(OutputType.FILE);
		File dst = new File(System.getProperty("user.dir")+"/Defects/"+date+testName+".png");
		
		try {
			FileHandler.copy(src, dst);
		} catch (IOException e) {
			System.out.println("Failed to take screnshot");
		}
		
		
		
	}
}
