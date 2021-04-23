package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	private WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SearchPage typeSearch(String string){
		driver.findElement(By.name("query")).sendKeys(string);
		
		return this;
	}
	
	public SearchPage clickSearch(){
		driver.findElement(By.xpath("/html/body/div[1]/form/div/button")).click();
		
		return new SearchPage(driver);
	}
	
	public SearchPage chooseOption(String string) {
		WebElement select = driver.findElement(By.id("type"));
		select.sendKeys(string);
		
		return this;
	}
	
	
}
