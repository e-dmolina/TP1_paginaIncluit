package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Constructor
    public basePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void waitVisibility(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Click method
    public void click(By elementBy){
        driver.findElement(elementBy).click();

    }

    //Write method
    public void writeText(By elementBy, String text){
        //waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read method
    public String readText(By elementBy){
        //waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Select Dropdown
    public void selectDropDownByVisibleText(By elementBy, String text){
        Select dropdown = new Select(driver.findElement(elementBy));
        dropdown.selectByVisibleText(text);
    }

    public String getAttributeValue(By elementBy, String attribute){
        return driver.findElement(elementBy).getAttribute(attribute);
    }

    //Assert
    public void assertContains(String expectedText, String containsText) {
        //waitVisibility(elementBy);
        //Assert.assertEquals(readText(elementBy), expectedText);
        Assert.assertTrue(expectedText.contains(containsText));
    }

    public void assertContains(By elementBy, String expectedText, String containsText) {
        Assert.assertEquals(readText(elementBy), expectedText.contains(containsText));
    }

}
