import org.apache.http.auth.UsernamePasswordCredentials;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailSignInTest {


    @Test
    public void gmailLoginShouldBeSuccessful(){
        //1. Go to Gmail Website
        System.setProperty ("webdriver.gecko.driver", "/Users/jillgrabowski/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        //Fill in Username
        WebElement usernameTextbox = driver.findElement(By.id("login-email"));
        usernameTextbox.clear();
        usernameTextbox.sendKeys("jgrabowski@gmail.com");
        //Fill in Password
        WebElement passwordTextbox = driver.findElement(By.id("login-password"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys("li0n3ss!");
        //Click Sign In
        WebElement signInButton = driver.findElement(By.id("login-submit"));
        signInButton.click();
        //Verify user did sign in
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("My Network")));
        Assert.assertTrue("My Network should exist", driver.findElements(By.partialLinkText("My Network")).size() > 0);
        //Sign out
        WebElement profileButton = driver.findElement(By.id("nav-settings__dropdown-trigger"));
        profileButton.click();
        WebElement signOutLinkage = driver.findElement(By.linkText("Sign out"));
        signOutLinkage.click();
        //Verify user did sign out
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email")));
        Assert.assertTrue("Log in should exist", driver.findElements(By.id("login-email")).size() > 0);

    }


}
