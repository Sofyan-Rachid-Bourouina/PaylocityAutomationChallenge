package com.Paylocity.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;



public class Driver {
    private Driver() {

    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver get() {

        if (driverPool.get() == null) {

            String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigurationReader.get("browser");


            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driverPool.get().manage().window().maximize();

                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driverPool.get().manage().window().maximize();
                    break;

            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if(driverPool.get() != null){
        driverPool.get().quit();
        driverPool.remove();
        }
    }
}
