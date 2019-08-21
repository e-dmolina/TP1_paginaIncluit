package Tests;

import Pages.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class steps {
    public WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\JavaAutomationJars\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("^Ingreso al sitio de Incluit$")
    public void ingresarSitio(){
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
    }

    //test case 1-D

    @And("^Hago click en el link contact us$")
    public void clickContactUs(){
        whatWeDoPage wwdp = new whatWeDoPage(driver);
        wwdp.goToContactUsPage();
    }

    @Then("^Ingreso a la pagina contact us$")
    public void verificarTituloContactUs(){
        String titulo = "Contact Us - IncluIT";
        contactUsPage cup = new contactUsPage(driver);
        cup.compararTitulo(titulo);
        //Assert.assertTrue(titulo.contains(cup.obtenerTitulo()));
    }

    //test case 2

    @Given("^Me encuentro en la pagina de contact us$")
    public void posicionarseContactUS(){
        contactUsPage cup = new contactUsPage(driver);
        cup.goToContactUsPage();
    }

    @When("^Ingreso el nombre \"([^\"]*)\"$")
    public void ingresarNombre(String nombre){
        contactUsPage cup = new contactUsPage(driver);
        cup.ingresarName(nombre);
    }

    @And("^El E-Mail \"([^\"]*)\"$")
    public void ingresarE_Mail(String eMail){
        contactUsPage cup = new contactUsPage(driver);
        cup.ingresarEMail(eMail);
    }

    @And("^Ingreso el subject \"([^\"]*)\"$")
    public void ingresarAsunto(String subject){
        contactUsPage cup = new contactUsPage(driver);
        cup.ingresarSubject(subject);
    }

    @And("^Ingreso el mensaje \"([^\"]*)\"$")
    public void ingresarMensaje(String message){
        contactUsPage cup = new contactUsPage(driver);
        cup.ingresarMessage(message);
    }

    @And("^Hago click en el boton SEND$")
    public void enviarMensaje(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 350);");
        contactUsPage cup = new contactUsPage(driver);
        cup.clickSend();
        //Thread.sleep(3000);
    }

    @Then("^Se envia el formulario y muestra el texto \"([^\"]*)\"$")
    public void validarEnvioYConfirmacion(String texto){
        contactUsPage cup = new contactUsPage(driver);
        cup.confirmarSend(texto);
    }

    @When("^Hago click en home$")
    public void irHomePage(){
        contactUsPage cup = new contactUsPage(driver);
        cup.goToHomePage();
    }

    @Then("^Ingresa a la pagina home$")
    public void verfificarHomePage(){
        homePage hp = new homePage(driver);
        hp.compararTitulo("IncluIT - Empowering Your Business");
    }

    @After
    public void cerrarNavegador(){
        driver.quit();
    }
}
