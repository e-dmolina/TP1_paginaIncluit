package Pages;

import org.openqa.selenium.WebDriver;

public class contactUsPage extends basePage {
    public contactUsPage(WebDriver driver) {
        super(driver);
    }

    public String obtenerTitulo(){
        return driver.getTitle();
    }
}
