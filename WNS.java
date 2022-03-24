/**
*
* @author prashant kumar
*/

// In real project below libraries would be needed to work below code.
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class WNS {
    //Download Chrome Driver and set systemProperty 
    public static void main(String[] args) {
       System.setProperty(
            "webdriver.chrome.driver",
            "C:\\Users\\ADMIN\\Documents\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();
  
        // Maximize the browser
        driver.manage().window().maximize();
  
        // Launch Website
        driver.get("https://www.moneycorp.com/en-gb/");
        
        WebElement languageDropdown = driver.findElement(By.id("language-dropdown-flag"));
        languageDropdown.click();
        
        WebElement usaLanguage = driver.findElement(By.xpath("//a[@aria-label='USA English']"));
        usaLanguage.click();
        
        //waiting for 30 seconds for the page to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        WebElement findMoreButton = driver.findElement(By.xpath("//*[text()='Foreign exchange solutions']/../a"));
        findMoreButton.click();
       
        //waiting for 10 seconds for the page to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebElement search = driver.findElement(By.xpath("//button[@aria-label='Search']"));
        search.click();
        
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='nav_search']"));
        searchInput.sendKeys("international payments");
        searchInput.searchInput(Keys.RETURN);
        
        if(driver.getPageSource().contains("international payments"))
        {
              System.out.println("Correct page is displayed!");
        }

        else
        {
              System.out.println("Incorrect page is displayed!");
         }
        
        List<WebElement> links = driver.findElements(By.className("results clearfix"));
        
        for (WebElement webElement : links) {
            
            WebElement hrefValue = webElement.findElement(By.xpath("/div[2]/a"));
                
                String printLinkText = hrefValue.getAttribute("href").toString();
                assert printLinkText.contains("https://www.moneycorp.com/en-us/")
                System.out.println(printLinkText);
                
            }
        
        driver.close();
        

    }


}
