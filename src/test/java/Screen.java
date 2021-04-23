import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screen {

	public static void screenshot(WebDriver driver, String file) {
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(ss, new File(file));
		} catch (Exception e) {
			System.out.println("Ocorreu um problema:" + e.getMessage());
		}
	}
}
