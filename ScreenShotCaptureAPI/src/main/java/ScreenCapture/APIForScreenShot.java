package ScreenCapture;

import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class APIForScreenShot {
	public void getScreenShot(String screenShotPath ,String uri) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		if(uri.length()>0)
		{
			driver.get(uri);
		}
		else
		{
			
		}
		
		driver.manage().window().maximize();
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);             
		File file1 = null;
		if(screenShotPath.length()>0)
		{
			file1= new File(screenShotPath);
		}
		else
		{
			
		}
		
		
		try {
			ImageIO.write(screenshot.getImage(),"PNG",file1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			driver.close();
		}
	
	}
}
