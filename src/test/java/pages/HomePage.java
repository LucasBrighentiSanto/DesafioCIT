package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SearchPage click() {
		driver.findElement(By.linkText("BROWSE")).click();
		
		return new SearchPage(driver);
	}

}
