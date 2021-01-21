package site;

import static org.junit.Assert.fail;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.objects;
import help.Base;

public class NagwaSite {
	static Logger LOG = Logger.getLogger(site.NagwaSite.class.getName());
	int TimeWait = Integer.valueOf(Base.getStaticProperty("TimeProp"));
	private static WebDriver driver;
	Base sm = new Base();
	objects element;

	@BeforeSuite
	public void setUp() throws Exception {
		try {
			LOG.info("Launching the browser");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.home") + System.getProperty("file.separator") + "chromedriver.exe");
			driver = new ChromeDriver();
			LOG.info("The Browser is launched successfully");
		} catch (Exception e) {
			LOG.error("Can't Launch the browser ", e);
			fail();
		}

	}

	@BeforeTest
	public void openServer() {
		LOG.info("==========================================");
		LOG.info("Now we are start testing Nagwa Web site");
		LOG.info("==========================================");
		LOG.info("Opening Nagwa Website");
		try {

			driver.get(Base.getStaticProperty("url"));
			LOG.info("Nagwa Website is opened successfully");

		} catch (Exception e) {
			LOG.error("Can't Open Nagwa Website ", e);
			fail();
		}

	}

	@Test(priority = 1)
	public void language() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, TimeWait);
		element = new objects(driver);

		LOG.info("Waitting for Languages to appear in the Website");

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element.Language));
		} catch (Exception e) {
			fail("Language not found");
			LOG.error("Language not found");
		}

		try {
			LOG.info("Click on Language Button");
			element.Language().click();

		} catch (Exception e) {
			LOG.error("Can't Click on Language Button", e);
			e.printStackTrace();
		}

		try {

			LOG.info("Verify That the Home page opened successfully with chosen Language");
			wait.until(ExpectedConditions.visibilityOfElementLocated(element.SignIn));
			assertEquals("Sign In", element.SignIn().getText());

			LOG.info("Home page opened successfully with chosen Language");

		} catch (Exception e) {
			fail("Home page not opened with chosen Language");
			LOG.error("Home page not opened with chosen Language");
		}

	}

	@Test(priority = 2)
	public void Search() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, TimeWait);
		element = new objects(driver);

		LOG.info("Waitting for Search Icon to appear in the Website");

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element.searchButton));
		} catch (Exception e) {
			fail("Search Icon not found");
			LOG.error("Search Icon not found");
		}

		try {
			LOG.info("Click on Search Icon");
			element.searchButton().click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(element.searchInput));

		} catch (Exception e) {
			LOG.error("Can't Click on Search Icon", e);
			e.printStackTrace();
		}

		try {
			LOG.info("Search for" + Base.getStaticProperty("searchText") + "");
			element.searchInput().sendKeys(Base.getStaticProperty("searchText"));
			LOG.info("Click on Search");
			element.searchSubmit().click();
		} catch (Exception e) {
			LOG.error("Can't Search for " + Base.getStaticProperty("searchText") + "", e);
			e.printStackTrace();
		}

		try {

			LOG.info("Verify That the search result appear");
			wait.until(ExpectedConditions.visibilityOfElementLocated(element.searchResult));
			LOG.info("Search result appeared");

		} catch (Exception e) {
			fail("Can't find search Result for addition");
			LOG.error("Can't find search Result for addition");
		}
	}

	@Test(priority = 3)
	public void openSecondLesson() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, TimeWait);
		element = new objects(driver);

		LOG.info("Waitting for The second lesson to appear in search result");

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element.secondResult));
		} catch (Exception e) {
			fail("The second lesson not found");
			LOG.error("The second lesson not found");
		}

		try {
			LOG.info("Click on The second lesson");
			element.secondResult().click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(element.WorksheetSection));
			LOG.info("home page for on The second lesson opened successfully");

		} catch (Exception e) {
			LOG.error("Can't open home page for on The second lesson", e);
			e.printStackTrace();
		}

		try {
			LOG.info("Click preview button");
			element.previewButton().click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(element.mcq_choices));
			LOG.info("Worksheet home page opened successfully ");
		} catch (Exception e) {
			LOG.error("Can't Click on preview button", e);
			e.printStackTrace();
		}

		try {
			LOG.info("Get count number of questions displayed");
			List<WebElement> Questions = driver.findElements(element.question);
			LOG.info("The number of Questions is " + Questions.size());
			System.out.println("The number of Questions is " + Questions.size());

		} catch (Exception e) {
			LOG.error("Can't Get count number of questions", e);
			e.printStackTrace();
		}

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
