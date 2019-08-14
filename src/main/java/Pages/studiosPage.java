package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class studiosPage extends basePage {

    List<WebElement> listaStudios = driver.findElements(By.className("card-section"));

    public studiosPage(WebDriver driver) {
        super(driver);
    }

    public List<String> obtenerStudio(){
        List<String> listaNombres = new ArrayList<String>();;

        for (WebElement i: listaStudios) {
            listaNombres.add(i.getText());
        }

        return listaNombres;
    }
}
