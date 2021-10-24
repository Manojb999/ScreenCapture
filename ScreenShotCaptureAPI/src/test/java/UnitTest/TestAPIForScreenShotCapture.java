package UnitTest;



import java.io.IOException;

import org.asynchttpclient.util.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Exception.EmptyPathException;
import Exception.IncorrectFilePathException;
import ScreenCapture.APIForScreenShot;

public class TestAPIForScreenShotCapture {

	APIForScreenShot apiForScreenShot = new APIForScreenShot();
	
	@Rule
	public ExpectedException expected =  ExpectedException.none();
	
	@Test
	public void APIForScreenShotInvalid() throws EmptyPathException, IncorrectFilePathException
	{
		expected .expect(EmptyPathException.class);
		expected.expectMessage("File path of ScreenShot can not be empty");
		apiForScreenShot.getScreenShot("", "https://en.wikipedia.org/wiki/Java_(programming_language)");
	}
	
	@Test
	public void APIForScreenShotIncorrectFilePath() throws IOException, IncorrectFilePathException, EmptyPathException
	{
		expected .expect(IncorrectFilePathException.class);
		expected.expectMessage("");
		apiForScreenShot.getScreenShot("/fds/dkdhs", "https://en.wikipedia.org/wiki/Java_(programming_language)");
	}
	
	
}
