package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class contactUsPage extends basePage {

    String baseUrl = "https://incluit.com/contact-us";
    By inName = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/main/article/div/div/div/div[1]/div/form/p[1]/span/input");
    By inEMail = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/main/article/div/div/div/div[1]/div/form/p[2]/span/input");
    By inSubject = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/main/article/div/div/div/div[1]/div/form/p[3]/span/input");
    By inMessage = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/main/article/div/div/div/div[1]/div/form/p[4]/span/textarea");
    By btnSend = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/main/article/div/div/div/div[1]/div/form/p[6]/input");
    By msjConfirm = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/main/article/div/div/div/div[1]/div/form/div[2]");
    By linkHome = By.xpath("/html/body/div[1]/header/div/div/div/div/a/img");

    public contactUsPage(WebDriver driver) {
        super(driver);
    }

    public contactUsPage goToContactUsPage(){
        driver.get(baseUrl);
        return this;
    }

    public String obtenerTitulo(){
        return driver.getTitle();
    }

    public void compararTitulo(String titulo){
        Assert.assertTrue(titulo.contains(driver.getTitle()));
    }

    public void ingresarName(String name){
        writeText(inName, name);
    }

    public void ingresarEMail(String eMail){
        writeText(inEMail, eMail);
    }

    public void ingresarSubject(String subject){
        writeText(inSubject, subject);
    }

    public void ingresarMessage(String message){
        writeText(inMessage, message);
    }

    public void clickSend(){
        click(btnSend);
    }

    public void confirmarSend(String texto){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(msjConfirm)));
        System.out.println("El text esperado es "+ texto);
        System.out.println("El texto obtenido de la pagina es "+ driver.findElement(msjConfirm).getText());
        Assert.assertTrue(texto.equalsIgnoreCase(driver.findElement(msjConfirm).getText()));
    }

    public homePage goToHomePage(){
        click(linkHome);
        return  new homePage(driver);
    }
}
