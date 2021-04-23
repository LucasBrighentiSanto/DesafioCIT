package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultSearchPage {

	private WebDriver driver;

	public ResultSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getMessage(String string) {
		return driver.findElement(By.xpath("/html/body/div[2]/div")).getText();
	}
	
	public List<WebElement> verifyRows(){
		WebElement tab_numb = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody"));
		List<WebElement> row_total = tab_numb.findElements(By.tagName("tr"));
		
		return (row_total);
	}
	
	public Boolean isPag() {
		Boolean pagination = driver.findElement(By.xpath("/html/body/div[2]/center/ul")).isDisplayed();
		
		return (pagination);
	}
	
	public List<WebElement> verifyItems(String string){
		WebElement tab_text = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody"));
		List<WebElement> text_total = tab_text.findElements(By.xpath("//td[text()='" + string + "']"));
		
		return(text_total);
	}
	
	public ResultSearchPage orderByID() {
		driver.findElement(By.xpath("/html/body/div[2]/table/thead/tr/th[1]/a/i")).click();
		
		return this;
	}
}
