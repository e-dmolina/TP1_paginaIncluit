package Tests;

import Pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class steps {
    public WebDriver driver;


    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\JavaAutomationJars\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("^Ingreso al sitio de Incluit$")
    public void ingresarSitio(){
        setup();
        homePage hp = new homePage(driver);
        hp.goToHomePage();
    }

    @When("^Hago click en el link why-incluit$")
    public void clickWhyIncluit(){
        homePage hp = new homePage(driver);
        hp.goToWhyIncluitPage();
    }

    @Then("^Veo que el número de team members es \"([^\"]*)\"$")
    public void verificarTeamMembers(String number){
        whyIncluitPage wip = new whyIncluitPage(driver);
        Assert.assertTrue(number.contains(wip.ReadTeamMembers()));
        driver.quit();
    }

    //test case 1-B

    @When("^Hago click en el link what we do$")
    public void clickWhatWeDo(){
        homePage hp = new homePage(driver);
        hp.goToWhatWeDoPage();
    }

    @Then("^Ingresa a la página what we do$")
    public void verificarTituloWWDP(){
        String titulo = "What We Do - IncluIT";
        whatWeDoPage wwdp = new whatWeDoPage(driver);
        Assert.assertTrue(titulo.contains(wwdp.obtenerTitulo()));
        driver.quit();
    }

    //test case 1-C

    @When("^Hago click en el link studios$")
    public void clickStudios(){
        homePage hp = new homePage(driver);
        hp.goToStudiosPage();
    }

    @Then("^El studio \"([^\"]*)\" existe$")
    public void verificarStudio(String studio){
        boolean bandera = false;
        studiosPage sp = new studiosPage(driver);
        for (String i: sp.obtenerStudio()    ) {
            if(studio.equalsIgnoreCase(i)){
                bandera = true;
                break;
            }
        }
        Assert.assertTrue(bandera);
        driver.quit();
    }

    //test case 1-D

    @When("^Hago click en el link contact us$")
    public void clickContactUs(){
        homePage hp = new homePage(driver);
        hp.goToContactUsPage();
    }

    @Then("^Ingreso a la pagina contact us$")
    public void verificarTituloContactUs(){
        String titulo = "Contact U - IncluIT";
        contactUsPage cup = new contactUsPage(driver);
        Assert.assertTrue(titulo.contains(cup.obtenerTitulo()));
    }
}
