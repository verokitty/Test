package SrcPagestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Home_page_US_tng {
	WebDriver driver;
	public ExtentTest test;

	public ExtentReports extent;
	
	
	@BeforeTest
	
  public void Initiatedriver() {
	try {
	
		
		  extent=new ExtentReports("G:/Project_Appli_testng/Report/TestReportCookie.html",true);//"G:/Milli-Appli_Poject/Report/TestReportCookie.html",true

		System.setProperty("webdriver.chrome.driver", "G:\\Milli-Appli_Poject\\Resources\\Drivers\\chromedriver.exe");
		
		
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			//e.printStackTrace();
		}
  }
  @Test(priority=0)
  public void launchBrowsre() {
	 // Hooks.launchBrowsre(driver);
	  //ExtentHtmlRepoter htmlreporter=
			
		driver.get("http://us.milliman.com");
		
		String HomePageTittle=driver.getTitle().toString();
		if (HomePageTittle.contains("404")){
			System.out.println("US Milliman Home page shows Error"+HomePageTittle);
			
		}
		else 
			System.out.println("US Milliman Home page opened->Tittle:"+HomePageTittle);
		 
		
  }
  @Test(priority=1)
  public void verifycookiepopuptext() {
	test=extent.startTest("verifycookiepopuptext...");
			WebDriverWait wait=new WebDriverWait(driver, 40);
			//cc-btn cc-allow
			//cookieconsent:desc
			WebElement Cookietext =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body:nth-child(2) > div.cc-wrapper:nth-child(2)")));//("//div[@class='cc-wrapper cookie-message/div[@id='cookieconsent:desc'][@class='cc-message']")
			test.log(LogStatus.INFO, "verifycookiepopuptext");
			if(Cookietext.getText()==null)
				{System.out.println("Cookietext missing");
				//test.log(LogStatus.FAIL, "Cookietext missing");
				}
			else
				{System.out.println(Cookietext.getText());
				test.log(LogStatus.PASS, "Cookietext Present");
				}
			extent.endTest(test);
			
  }
  @Test(priority=2)
  public void verifypageLogoworking() {
	test=extent.startTest("verifypageLogoworking()...");
			String HomePageTittle=driver.getTitle().toString();
			test.log(LogStatus.INFO, "verifypageLogoworking");
			WebDriverWait wait=new WebDriverWait(driver, 40);
		WebElement Logo =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.page:nth-child(4) div.top-level-menu-rendering.rendering.transparent-treatment.white-content.blue-button.show-light-icons:nth-child(1) div.color-overlay.content-styling:nth-child(1) div.container div.row div.col.navigation-container div.dropdown.collapsibleNav div.height-spacer div.nav-content div.logo a:nth-child(1) > img.light-icon")));
			Logo.click();
			String HomePageTittlelogo=driver.getTitle().toString();
			if (HomePageTittle.contentEquals("Milliman | US")){
				System.out.println("US Milliman Home page Logo working"+HomePageTittlelogo);
				test.log(LogStatus.PASS, "US Milliman Home page Logo working"+HomePageTittlelogo);
			}
			else 
				{System.out.println("US Milliman Home page Logo redirected to page other than Home page:"+HomePageTittlelogo);
				test.log(LogStatus.FAIL, "US Milliman Home page Logo redirected to page other than Home page:"+HomePageTittlelogo);
				}
			extent.endTest(test);
			test.log(LogStatus.INFO, "COMPLETE");
			

  }
  @Test(priority=3)
  public void verifycookiepopupCancelButton() {
	test=extent.startTest("verifycookiepopupCancelButton()...");
			WebDriverWait wait=new WebDriverWait(driver, 40);
			WebElement CookieCancelButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cc-wrapper:nth-child(2) div.cc-container div.cc-window.cc-banner.cc-type-info.cc-theme-block.cc-bottom.bg-dark-blue-transparent-85 div.cc-wrapper.cookie-message:nth-child(1) div.cc-compliance.button-color-bright-blue > a.cc-btn.cc-dismiss:nth-child(2)")));
			
			if(CookieCancelButton.getText().toString().equals("Cancel"))
				{System.out.println("CookieCancelButton present");
				test.log(LogStatus.PASS, "CookieCancelButton present-clicked");
				}
			else
				{System.out.println("CookieCancelButton wrong :"+CookieCancelButton.getText());
				test.log(LogStatus.FAIL, "CookieCancelButton wrong :"+CookieCancelButton.getText());
				}
			if(CookieCancelButton.isEnabled())
				{CookieCancelButton.click();
				System.out.println("CookieCancelButton present-clicked");
				test.log(LogStatus.PASS, "CookieCancelButton present-clicked");
				}
			else 
				{
				System.out.println("Cookie Delete Button is not Enabled");
				test.log(LogStatus.FAIL, "Cookie Delete Button is not Enabled");
				
			}
			extent.endTest(test);
			extent.flush();
			  }
  /*@Test(priority=4)
  public void verifycookiepopupCancelButton() {
	//test=extent.startTest("verifycookiepopupCancelButton()...");
			WebDriverWait wait=new WebDriverWait(driver, 40);
			WebElement CookieCancelButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cc-wrapper:nth-child(2) div.cc-container div.cc-window.cc-banner.cc-type-info.cc-theme-block.cc-bottom.bg-dark-blue-transparent-85 div.cc-wrapper.cookie-message:nth-child(1) div.cc-compliance.button-color-bright-blue > a.cc-btn.cc-dismiss:nth-child(2)")));
			
			if(CookieCancelButton.getText().toString().equals("Cancel"))
				{System.out.println("CookieCancelButton present");
				//test.log(LogStatus.PASS, "CookieCancelButton present-clicked");
				}
			else
				{System.out.println("CookieCancelButton wrong :"+CookieCancelButton.getText());
				//test.log(LogStatus.FAIL, "CookieCancelButton wrong :"+CookieCancelButton.getText());
				}
			if(CookieCancelButton.isEnabled())
				{CookieCancelButton.click();
				System.out.println("CookieCancelButton present-clicked");
				//test.log(LogStatus.PASS, "CookieCancelButton present-clicked");
				}
			else 
				{
				System.out.println("Cookie Delete Button is not Enabled");
				//test.log(LogStatus.FAIL, "Cookie Delete Button is not Enabled");
				
				}
		
			//extent.endTest(test);
		
  }*/
  

  @AfterTest
  public void afterTest() {
		driver.close();
  }

}

