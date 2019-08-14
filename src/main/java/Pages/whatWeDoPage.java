package Pages;

import org.openqa.selenium.WebDriver;

public class whatWeDoPage extends basePage {

    public whatWeDoPage(WebDriver driver) {
        super(driver);
    }

    public String obtenerTitulo(){
        return driver.getTitle();
    }
}
