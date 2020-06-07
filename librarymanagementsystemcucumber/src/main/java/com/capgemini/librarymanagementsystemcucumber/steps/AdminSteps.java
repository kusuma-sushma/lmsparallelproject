package com.capgemini.librarymanagementsystemcucumber.steps;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminSteps {
	
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

		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@Given("^Admin is on login page$")
	public void admin_is_on_login_page() throws Throwable {
		Thread.sleep(5000);
		String actual = driver.getTitle();
		String expected = "Library";
		assertTrue("The Webpage is not a login page", actual.equals(expected));
		
	}
 
	@When("^Admin gives \"([^\"]*)\", \"([^\"]*)\"$")
	public void admin_gives(String arg1, String arg2) throws Throwable {
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		email.sendKeys(arg1);
		password.sendKeys(arg2);
		login.click();
	}

	@Then("^Admin should be able to logged in$")
	public void admin_should_be_able_to_logged_in() throws Throwable {
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:4200/allBooks";
		assertTrue("Admin  is not at login page", actual.equals(expected));
	}

	@Given("^Admin is on add user page$")
	public void admin_is_on_add_user_page() throws Throwable {
		Thread.sleep(5000);
		WebElement user = driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a"));
		action.moveToElement(user).click().perform();
	}

	@When("^Admin enter User Details like \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void admin_enter_User_Details_like(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		WebElement username = driver.findElement(By.id("username"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement department = driver.findElement(By.id("department"));
		WebElement addUser = driver.findElement(By.xpath("//button[@type='submit']"));
		username.clear();
		username.sendKeys(arg1);
		email.clear();
		email.sendKeys(arg2);
		password.clear();
		password.sendKeys(arg3);
		department.clear();
		department.sendKeys(arg4);
		addUser.click();
	}
	

	@Then("^User Added Successfully$")
	public void user_Added_Successfully() throws Throwable {
	}
	
	@Given("^Admin is on get all books page$")
	public void admin_is_on_get_all_books_page() throws Throwable {
		Thread.sleep(5000);
		WebElement user = driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[5]/a"));
		action.moveToElement(user).click().perform();
	}

	@Then("^Books has found Successfully$")
	public void books_has_found_Successfully() throws Throwable {
		
	}
	
	@Given("^Admin is on update book page$")
	public void admin_is_on_update_book_page() throws Throwable {
		Thread.sleep(5000);
		WebElement updateBook = driver.findElement(By.xpath("/html/body/app-root/app-header/div/app-booklist/div/div/div/table/tbody/tr[3]/td[7]"));
		action.moveToElement(updateBook).click().perform();
		String actual = driver.getCurrentUrl();
		String expected ="http://localhost:4200/updateBook?bookId=95&bookName=Networks&bookAuthor=Networks&bookCategory=Networks&bookPublisher=Networks&bookAvailable=true";
		assertTrue("The Webpage is not a update book page", actual.equals(expected));
	}


	@When("^Admin enters Book Details like (\\d+), \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void admin_enters_Book_Details_like(int arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
	 	WebElement bookId = driver.findElement(By.id("bookId"));
		WebElement bookName = driver.findElement(By.id("bookName"));
		WebElement bookAuthor = driver.findElement(By.id("bookAuthor"));
		WebElement bookCategory = driver.findElement(By.id("bookCategory"));
		WebElement bookPublisher = driver.findElement(By.id("bookPublisher"));
		WebElement updateBook = driver.findElement(By.id("updateBook"));
		bookId.clear();
		bookId.sendKeys(""+arg1);
		bookName.clear();
		bookName.sendKeys(arg2);
		bookAuthor.clear();
		bookAuthor.sendKeys(arg2);
		bookCategory.clear();
		bookCategory.sendKeys(arg2);
		bookPublisher.clear();
		bookPublisher.sendKeys(arg2);
		updateBook.click();

	}

	@Then("^Book Upated Successfully$")
	public void book_Upated_Successfully() throws Throwable {
	}



	@Given("^Admin is on add book page$")
	public void admin_is_on_add_book_page() throws Throwable {
		Thread.sleep(5000);
		WebElement user = driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[2]/a"));
		action.moveToElement(user).click().perform();
	}

	@When("^Admin enters Book Details like \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void admin_enters_Book_Details_like(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		WebElement bookName = driver.findElement(By.id("bookName"));
		WebElement bookAuthor = driver.findElement(By.id("bookAuthor"));
		WebElement bookCategory = driver.findElement(By.id("bookCategory"));
		WebElement bookPublisher = driver.findElement(By.id("bookPublisher"));
		WebElement addBook = driver.findElement(By.xpath("//button[@type='submit']"));
		bookName.clear();
		bookName.sendKeys(arg1);
		bookAuthor.clear();
		bookAuthor.sendKeys(arg2);
		bookCategory.clear();
		bookCategory.sendKeys(arg3);
		bookPublisher.clear();
		bookPublisher.sendKeys(arg4);
		addBook.click();
	}

	@Then("^Book Added Successfully$")
	public void book_Added_Successfully() throws Throwable {
	}

	@Given("^Admin is on delete book page$")
	public void admin_is_on_delete_book_page() throws Throwable {
		Thread.sleep(5000);
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:4200/allBooks";
		assertTrue("Admin  is not at Show Books page", actual.equals(expected));
	}


	@When("^Admin enters (\\d+)$")
	public void admin_enters(int arg1) throws Throwable {
		WebElement deleteBook = driver.findElement(By.xpath("/html/body/app-root/app-header/div/app-booklist/div/div/div/table/tbody/tr[5]/td[8]"));
		action.moveToElement(deleteBook).click().perform();
	}

	@Then("^Book Deleted Successfully$")
	public void book_Deleted_Successfully() throws Throwable {
	}

	@Given("^Admin is on issue book page$")
	public void admin_is_on_issue_book_page() throws Throwable {
		Thread.sleep(5000);
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:4200/showRequests";
		assertTrue("Admin is not at Show Requests page", actual.equals(expected));
	}

	@When("^Admin enters requestId (\\d+)$")
	public void admin_enters_requestId(int arg1) throws Throwable {
		WebElement issueBook = driver.findElement(By.xpath("/html/body/app-root/app-header/div/app-show-requests/div/div/table/tbody/tr[1]/td[7]"));
		action.moveToElement(issueBook).click().perform();
	}

	@Then("^Book Issued Successfully$")
	public void book_Issued_Successfully() throws Throwable {
	}

	@Given("^Admin is on search book page$")
	public void admin_is_on_search_book_page() throws Throwable {
		Thread.sleep(5000);
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:4200/allBooks";
		assertTrue("Admin  is not at Show Books page", actual.equals(expected));
	}

	@When("^Admin enters Book Id for search (\\d+)$")
	public void admin_enters_Book_Id_for_search(int arg1) throws Throwable {
		WebElement dropDown = driver.findElement(By.cssSelector("select[id='search']"));
		Select select = new Select(dropDown);
		select.selectByVisibleText("BookId");
		WebElement search = driver.findElement(By.xpath("/html/body/app-root/app-header/div/app-booklist/div/div/div/div/input"));
		search.sendKeys(""+arg1);
	}

	@Then("^Book has found Successfully$")
	public void book_has_found_Successfully() throws Throwable {
	}

	@Given("^Admin is on get all users page$")
	public void admin_is_on_get_all_users_page() throws Throwable {
		Thread.sleep(5000);
		WebElement user = driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[4]/a"));
		action.moveToElement(user).click().perform();
	}

	@Then("^Users has found Successfully$")
	public void users_has_found_Successfully() throws Throwable {
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:4200/showUsers";
		assertTrue("Admin  is not at Show Users page", actual.equals(expected));
	}

	@Given("^Admin is on get all requests page$")
	public void admin_is_on_get_all_requests_page() throws Throwable {
		Thread.sleep(5000);
		WebElement requests = driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[6]/a"));
		action.moveToElement(requests).click().perform();
	}

	@Then("^Requests has found Successfully$")
	public void requests_has_found_Successfully() throws Throwable {
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:4200/showRequests";
		assertTrue("Admin is not at Show Requests page", actual.equals(expected));
	}


}
