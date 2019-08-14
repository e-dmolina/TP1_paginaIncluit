package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class whatWeDoPage extends basePage {

    By btnContactUs = By.xpath("/html/body/div[1]/header/div/div/div/nav/div[2]/ul/li[7]/a");


    public whatWeDoPage(WebDriver driver) {
        super(driver);
    }

    public String obtenerTitulo(){
        return driver.getTitle();
    }

    public contactUsPage goToContactUsPage(){
        click(btnContactUs);
        return new contactUsPage(driver);
    }
}
