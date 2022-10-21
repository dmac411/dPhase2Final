package stepdefs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

	WebDriver driver = Hooks.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@Given("I click on the login link")
	public void i_click_on_the_login_link() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I enter the correct username and password")
	public void i_enter_the_correct_username_and_password() {
		WebElement UserName = driver.findElement(By.name("user-name"));
		UserName.sendKeys("standard_user");

		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("secret_sauce");

	}

	@When("I enter standard user name {string} and password as {string}")
	public void i_enter_standard_user_name_and_password_as(String string, String string2) {

		WebElement UserName = driver.findElement(By.id("user-name"));
		UserName.sendKeys("standard_user");

		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("secret_sauce");
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
	}

	@When("I enter standard user name {string} and incorrrect password as {string}")
	public void i_enter_standard_user_name_and_incorrrect_password_as(String string, String string2) {
		WebElement UserName = driver.findElement(By.id("user-name"));
		UserName.sendKeys("standard_user");

		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("secret_sauce999");
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
	}

	@Then("error message appears")
	public void error_message_appears() {
		WebElement Error = driver.findElement(By.xpath("//h3[@data-test='error']"));
		String ActError = Error.getText();
		String ExpError = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(ExpError, ActError);
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		WebElement LoginLink = driver.findElement(By.name("login-button"));
		LoginLink.click();
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);

	}

	@Then("I should land on the home page")
	public void i_should_land_on_the_home_page() {

	}

	@When("I verify I am on the products page")
	public void I_verify_i_am_on_the_products_page() {
		WebElement Title = driver
				.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span[contains(text(),'Products')]"));
	}

	@Then("I select a product")
	public void i_select_a_product() {

		List<WebElement> resultsList = driver.findElements(By.xpath("//*[@id=\"item_0_img_link\"]//div[1]"));
		driver.findElement(By.className("btn btn_primary btn_small btn_inventory")).click();
		;
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);

	}

	@Then("click Add To Cart button")
	public void click_Add_To_Cart_button() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("I enter Locked Out user {string} with correct password as {string}")
	public void i_enter_Locked_Out_user_with_correct_password_as(String string, String string2) {
		WebElement UserName = driver.findElement(By.id("user-name"));
		UserName.sendKeys("locked_out_user");

		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("secret_sauce");
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
	}

	@Then("error message {string} is displayed")
	public void error_message_is_displayed(String string) {
		WebElement Error = driver.findElement(By.xpath("//h3[@data-test='error']"));
		String ActError = Error.getText();
		String ExpError = "Epic sadface: Sorry, this user has been locked out.";
		Assert.assertEquals(ExpError, ActError);
	}

	@When("I enter the username as {string} and Password as {string}")
	public void i_enter_the_username_as_and_Password_as(String UserNameValue, String PasswordValue) {
		WebElement UserName = driver.findElement(By.id("user-name"));
		UserName.sendKeys(UserNameValue);

		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(PasswordValue);
	}

	@Then("I should get the error message {string}")
	public void i_should_get_the_error_message(String string) {
		WebElement Error = driver.findElement(By.xpath("//h3[@data-test='error']"));
		String ActError = Error.getText();
		String ExpError = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(ExpError, ActError);
	}

}
