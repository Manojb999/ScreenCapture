package ScreenCapture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Exception.EmptyPathException;
import Exception.IncorrectFilePathException;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class APIForScreenShot {
	public void getScreenShot(String screenShotPath ,String uri) throws EmptyPathException, IncorrectFilePathException {
		
		/*
		 * Will create a ChromeDriver object
		 */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		/*
		 * Checking if the URI is empty if yes will throw EmptyPathException
		 */
		if(uri.length()>0)
		{
			driver.get(uri);
		}
		else
		{
			throw new EmptyPathException("URI Can not be empty");
		}
		
		/*
		 * Below line create a screen shot object for fullpage and will 
		 */
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);             
		File file1 = null;
		
		try 
		{
			/*
			 * Checking if the Image Path is empty if yes will throw EmptyPathException
			 * if path is not there it will throw IncorrectFilePathException 
			 */
			if(screenShotPath.length()>0)
			{
				file1= new File(screenShotPath);
				ImageIO.write(screenshot.getImage(),"PNG",file1);
			}
			else
			{
				throw new EmptyPathException("File path of ScreenShot can not be empty");
			}
			
		} catch (IOException e1 ) {
			// TODO Auto-generated catch block
			
			throw new IncorrectFilePathException(e1.getMessage());
		}
		catch(NullPointerException e1)
		{
			throw new IncorrectFilePathException(e1.getMessage());
		}
		finally {
			
			driver.close();
		}
	
	}
}
