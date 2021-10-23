package UnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Exception.EmptyPathException;
import Exception.IncorrectFilePathException;
import ScreenCapture.APIForScreenShot;

public class TestAPIForScreenShotCapture {

	@Test
	public void APIForScreenShotInvalid()
	{
		Assertions.assertThrows(EmptyPathException.class, () -> {
			APIForScreenShot apiForScreenShot = new APIForScreenShot();
			apiForScreenShot.getScreenShot("", "https://en.wikipedia.org/wiki/Java_(programming_language)");
		});
	}
	
	@Test
	public void APIForScreenShotIncorrectFilePath()
	{
		Assertions.assertThrows(IncorrectFilePathException.class, () -> {
			APIForScreenShot apiForScreenShot = new APIForScreenShot();
			apiForScreenShot.getScreenShot("/fds/dkdhs", "https://en.wikipedia.org/wiki/Java_(programming_language)");
		});
	}
}
