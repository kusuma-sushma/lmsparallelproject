package com.capgemini.librarymanagementsystemcucumber.steps;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserSteps {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions action;

	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}

	@Before
	public void openBrowser() throws Exception {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/login");

		wait = new WebDriverWait(driver, 15);
		action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	

	
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		String actual = driver.getTitle();
		String expected = "Library";
		assertTrue("The Webpage is not a login page", actual.equals(expected));
	
	}

	@When("^User gives \"([^\"]*)\", \"([^\"]*)\"$")
	public void user_gives(String arg1, String arg2) throws Throwable {
	WebElement email = driver.findElement(By.id("email"));
	WebElement password = driver.findElement(By.id("password"));
	WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
	email.sendKeys(arg1);
	password.sendKeys(arg2);
	login.click();	
	}

	@Then("^User should be logged in$")
	public void user_should_be_logged_in() throws Throwable {
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:4200/allBooks";
		assertTrue("User  is not at login page", actual.equals(expected));
	}

	@Given("^User is on Book Request page$")
	public void user_is_on_Book_Request_page() throws Throwable {
		Thread.sleep(4000);
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:4200/allBooks";
		assertTrue("User is not at Show Books page", actual.equals(expected));
	}

	@When("^User Requests a Book by entering details bookId (\\d+)$")
	public void user_Requests_a_Book_by_entering_details_bookId(int arg1) throws Throwable {
		WebElement requestBook = driver.findElement(By.xpath("/html/body/app-root/app-header/div/app-booklist/div/div/div/table/tbody/tr[8]/td[7]"));
		action.moveToElement(requestBook).click().perform();
	}


	@Then("^User placed the Request Successfully$")
	public void user_placed_the_Request_Successfully() throws Throwable {
	}

	@Given("^User is on Book Return page$")
	public void user_is_on_Book_Return_page() throws Throwable {
		Thread.sleep(4000);
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:4200/allBooks";
		assertTrue("User is not at Show Books page", actual.equals(expected));
	}


@When("^User Returns a Book by entering details bookId (\\d+)$")
public void user_Returns_a_Book_by_entering_details_bookId(int arg1) throws Throwable {
		WebElement requestBook = driver.findElement(By.xpath("/html/body/app-root/app-header/div/app-booklist/div/div/div/table/tbody/tr[1]/td[8]"));
		action.moveToElement(requestBook).click().perform();
	}

	@Then("^User Returned Book Successfully$")
	public void user_Returned_Book_Successfully() throws Throwable {
	}


}
