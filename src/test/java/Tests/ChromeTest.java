/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Carlos Gil Sabrido
 */
public class ChromeTest {
   protected WebDriver driver;
   @BeforeClass
   public static void setupClass() {
    System.setProperty("webdriver.chrome.driver","C:/Users/Carlos Gil Sabrido/Documents/chromedriver.exe");
    ChromeDriverManager.getInstance().setup();
    }
    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }
    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void test () {
        System.out.println("ESTO SI");
    }
}

