package loginTest;

import java.io.IOException;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;

import utils.ReadExcel;

public class Login {
	String sheetName = "one";
	WebDriver driver;

	@DataProvider(name = "onedata")
	public String[][] getData() throws IOException {
		String[][] data = ReadExcel.readExcel1(sheetName);
		return data;
	}

	@Test(dataProvider = "onedata")
	public void login(String username, String password) {
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(username);
		driver.findElement(By.id("login-button")).click();
		driver.quit();

	}

}
