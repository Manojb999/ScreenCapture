package ScreenCapture;

import Exception.EmptyPathException;
import Exception.IncorrectFilePathException;

public class ScreenCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		APIForScreenShot apiForScreenShot = new APIForScreenShot();
		try {
			apiForScreenShot.getScreenShot("C:\\Users\\Manoj Baviskar\\Desktop\\Try\\Page.PNG","https://en.wikipedia.org/wiki/Java_(programming_language)");
		} catch (EmptyPathException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IncorrectFilePathException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
