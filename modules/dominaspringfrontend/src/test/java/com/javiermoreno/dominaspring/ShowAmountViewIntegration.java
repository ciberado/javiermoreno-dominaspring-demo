package com.javiermoreno.dominaspring;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author ciberado
 */
public class ShowAmountViewIntegration {

    @Test
    public void checkFormOk() {
        // Download and add to the path ChromeDriver: http://chromedriver.storage.googleapis.com/index.html?path=2.9/
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8081/dominaspringfrontend/index.html");
        WebElement element = driver.findElement(By.name("codigo"));
        element.sendKeys("9999");
        element.submit();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                WebElement element = driver.findElement(By.id("output"));
                boolean result = "ok".equals(element.getAttribute("class"));
                return result;
            }
        });

        driver.quit();
    }

}
