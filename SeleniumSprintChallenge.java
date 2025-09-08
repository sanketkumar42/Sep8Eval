package SeleniumSprintChallenge;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SeleniumSprintChallenge {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,1000)");

		driver.get("https://demoqa.com/");
		driver.findElement(By.xpath("//h5[text()='Elements']/..")).click();
		driver.findElement(By.xpath("//span[text()='Text Box']")).click();
		
		 driver.findElement(By.id("userName")).sendKeys("Sanket kumar");
		 driver.findElement(By.id("userEmail")).sendKeys("sk022@example.com");
		 driver.findElement(By.id("currentAddress")).sendKeys("12345 bihar");
		 driver.findElement(By.id("permanentAddress")).sendKeys("12345 bihar");
		 driver.findElement(By.id("submit")).click();

		 driver.findElement(By.xpath("//span[text()='Radio Button']")).click();
		 driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();

		 String confirmationText = driver.findElement(By.className("text-success")).getText();
		 Assert.assertEquals(confirmationText, "Impressive");
		 
		 driver.get("https://demoqa.com/");
		 
		 driver.findElement(By.xpath("//h5[text()='Widgets']/..")).click();
		 driver.findElement(By.xpath("//span[text()='Select Menu']")).click();

		 Select titleDropdown = new Select(driver.findElement(By.id("oldSelectMenu")));
		 titleDropdown.selectByVisibleText("Black");

		 WebElement selectOption = driver.findElement(By.id("react-select-2-input"));
		 selectOption.sendKeys("Group 1, option 1");
		 selectOption.sendKeys(Keys.ENTER);

		 driver.findElement(By.xpath("//span[text()='Date Picker']")).click();
		 WebElement dateInput = driver.findElement(By.id("datePickerMonthYearInput"));
		 dateInput.click();

		 Calendar calendar = Calendar.getInstance();
		 calendar.add(Calendar.MONTH, 1);
		 int year = calendar.get(Calendar.YEAR);
		 String monthName = new SimpleDateFormat("MMMM").format(calendar.getTime());

		 WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
		 new Select(monthDropdown).selectByVisibleText(monthName);

		 WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
		 new Select(yearDropdown).selectByVisibleText(String.valueOf(year));

		 driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--015']")).click();
		 
		 
		 
		 
		 
		 driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']/..")).click();
		 driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

		 String originalWindow = driver.getWindowHandle();
		 driver.findElement(By.id("tabButton")).click();

		 for (String windowHandle : driver.getWindowHandles()) {
		     if (!windowHandle.equals(originalWindow)) {
		         driver.switchTo().window(windowHandle);
		         String newTabText = driver.findElement(By.id("sampleHeading")).getText();
		         Assert.assertEquals(newTabText, "This is a sample page");
		         driver.close();
		     }
		 }
		 
		         
		         
		         driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		         driver.findElement(By.xpath("//span[text()='Buttons']")).click();

		         JavascriptExecutor js = (JavascriptExecutor) driver;
		         WebElement clickMeBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));

		         js.executeScript("arguments[0].scrollIntoView(true);", clickMeBtn);
		         js.executeScript("arguments[0].click();", clickMeBtn);

		         String message = driver.findElement(By.id("dynamicClickMessage")).getText();
		         Assert.assertTrue(message.contains("You have done a dynamic click"));
		         
		         
		         
		         
		 
	}

}
