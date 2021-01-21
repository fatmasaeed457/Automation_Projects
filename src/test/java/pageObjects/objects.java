package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import help.Base;

public class objects {
	public WebDriver driver;
	Base sm = new Base();

	public objects(WebDriver driver) {
		this.driver = driver;
	}

	public By Language = By.xpath("//a[contains(text(),'" + Base.getStaticProperty("Language") + "')]");
	public By SignIn = By.xpath("//div[@class='user-actions']//span[contains(text(),'Sign In')]");
	public By searchButton = By.xpath("//button[@type='button']");
	public By searchInput = By.xpath("//input[@id='txt_search_query']");
	public By searchSubmit = By.xpath("//button[@type='submit']");
	public By searchResult = By.xpath("//*[text()[contains(.,'" + Base.getStaticProperty("searchText") + "')]]");
	public By secondResult = By.xpath("(//*[text()[contains(.,'" + Base.getStaticProperty("searchText") + "')]])[2]");
	public By previewButton = By.xpath("//div[@class='question-preview']");
	public By WorksheetSection = By.xpath("//section[@id='WorksheetSection']");
	public By mcq_choices = By.xpath("//ul[@class='mcq_choices']");
	public By question = By.xpath("//b[text()[contains(.,'Q')]]");

	public WebElement Language() {
		return driver.findElement(Language);
	}

	public WebElement SignIn() {
		return driver.findElement(SignIn);
	}

	public WebElement searchButton() {
		return driver.findElement(searchButton);
	}

	public WebElement searchInput() {
		return driver.findElement(searchInput);
	}

	public WebElement searchSubmit() {
		return driver.findElement(searchSubmit);
	}

	public WebElement searchResult() {
		return driver.findElement(searchResult);
	}

	public WebElement secondResult() {
		return driver.findElement(secondResult);
	}

	public WebElement WorksheetSection() {
		return driver.findElement(WorksheetSection);
	}

	public WebElement previewButton() {
		return driver.findElement(previewButton);
	}

	public WebElement mcq_choices() {
		return driver.findElement(mcq_choices);
	}

	public WebElement question() {
		return driver.findElement(question);
	}

}
