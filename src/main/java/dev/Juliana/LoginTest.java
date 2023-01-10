package dev.Juliana;

import dev.Juliana.pages.BasePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;


import static org.asynchttpclient.util.Assertions.*;

public class LoginTest   {
private WebDriver driver;

@BeforeEach
void setup() throws Exception {

 System.getProperty("webdriver.chrome.driver", "C:\\ProjetoJava\\AulaAutomacaoWebDio");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://automationexercise.com/login");

}
@AfterEach
void tearDown()throws Exception{
    driver.quit();
}

@Test
void test(){
    //pegando o campo email e inserindo o email do usuario
    WebElement emailAddressElement = driver.findElement(By.name("email"));
    emailAddressElement.sendKeys("julianaoliveiraqa@outlook.com");

    //pegando o campo password e inserindo a senha
    WebElement passwordElement = driver.findElement(By.name("password"));
    passwordElement.sendKeys("testadora2");

    //clicar no botao login
    WebElement submitBtnElement = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
    submitBtnElement.click();

    //verficar se logou
    WebElement tagMyAccoount = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"));
    String textTagA = tagMyAccoount.getText();
    Assertions.assertTrue(textTagA.equals("Website for automation pratice"));


}
}
