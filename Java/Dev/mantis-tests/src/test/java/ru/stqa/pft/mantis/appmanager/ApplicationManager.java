package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private final Properties properties;
  WebDriver wd;

  private String browser;


  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
}


  public void init() throws IOException {
    String target = System.getProperty("target", "local");

    properties.load(new FileReader(new File
            (String.format("src/test/resources/%s.properties", target))));


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
    wd.get(properties.getProperty("web.baseUrl"));

  }

  public void stop() {
    wd.quit();
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public HttpSession newSession() {
    return new HttpSession(this);
  }
}
