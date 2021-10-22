package main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Dimension;
public class APIForScreenShot {
	
	public void getScreenShot()
	{
		try {
			String path = "C:\\Users\\Manoj Baviskar\\Desktop\\Try\\ss.jpg";
			Robot robot = new Robot();
			Dimension dimesion = Toolkit.getDefaultToolkit().getScreenSize(); 
			Rectangle rectangle  = new Rectangle(dimesion);
			BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
			ImageIO.write(bufferedImage, "jpg", new File(path));
			
			System.out.println("Done ...");
		} catch (AWTException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
