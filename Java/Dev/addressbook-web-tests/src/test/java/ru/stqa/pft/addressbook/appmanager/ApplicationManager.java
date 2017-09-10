package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {

    if (Objects.equals(browser, BrowserType.FIREFOX)){
      System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.18.0-arm7hf\\geckodriver.exe");
      wd = new FirefoxDriver();
    }else if (Objects.equals(browser, BrowserType.CHROME)){
      System.setProperty("webdriver.chrome.driver", "C:\\geckodriver-v0.18.0-arm7hf\\chromedriver.exe");
      wd = new ChromeDriver();
    }else if (Objects.equals(browser, BrowserType.IE)){
      System.setProperty("webdriver.ie.driver", "C:\\geckodriver-v0.18.0-arm7hf\\IEDriverServer.exe");
      wd = new InternetExplorerDriver();
    }

    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.18.0-arm7hf\\geckodriver.exe");
    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }


  public void goToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public ContactHelper address() {
    return contactHelper;
  }
}
