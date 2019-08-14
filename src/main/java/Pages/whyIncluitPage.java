package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class whyIncluitPage extends basePage {

    By numberTM = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/main/article/div/figure/figcaption/section/div/div[2]/span[2]");

    public whyIncluitPage(WebDriver driver) {
        super(driver);
    }

    public String ReadTeamMembers(){
        return readText(numberTM);
    }

}
