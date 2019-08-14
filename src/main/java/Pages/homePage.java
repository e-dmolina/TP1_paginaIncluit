package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class homePage extends basePage {

    String baseURL = "https://incluit.com/";

    By btnWhyIncluit = By.xpath("/html/body/div[1]/header/div/div/div/nav/div[2]/ul/li[1]/a");
    By btnWhatWeDo = By.xpath("/html/body/div[1]/header/div/div/div/nav/div[2]/ul/li[2]/a");
    By btnStudios = By.xpath("/html/body/div[1]/header/div/div/div/nav/div[2]/ul/li[4]/a");
    By btnContactUs = By.xpath("/html/body/div[1]/header/div/div/div/nav/div[2]/ul/li[7]/a");

    //List<WebElement> menuList = driver.findElements(By.className("menu-item menu-item-type-post_type menu-item-object-page menu-item-1852"));

    public homePage(WebDriver driver) {
        super(driver);
    }

    public homePage goToHomePage(){
        driver.get(baseURL);
        return this;
    }

    public whyIncluitPage goToWhyIncluitPage(){
        click(btnWhyIncluit);
        return new whyIncluitPage(driver);
    }

    public whatWeDoPage goToWhatWeDoPage(){
        click(btnWhatWeDo);
        return new whatWeDoPage(driver);
    }

    public studiosPage goToStudiosPage(){
        click(btnStudios);
        return new studiosPage(driver);
    }

    public contactUsPage goToContactUsPage(){
        click(btnContactUs);
        return new contactUsPage(driver);
    }

   /* public void goToLinkMenu(String link){

        for (WebElement i: menuList) {
            if (i.getText().equalsIgnoreCase(link)){
                i.click();
            }
        }
    }*/
}
