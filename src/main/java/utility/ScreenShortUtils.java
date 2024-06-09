package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;


public final class ScreenShortUtils {

	private ScreenShortUtils() {
	}



	public static String getBase64Image() {
		return ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BASE64);
	}


	public static byte[] getBase64ImageBytes() {
		return ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
	}
}