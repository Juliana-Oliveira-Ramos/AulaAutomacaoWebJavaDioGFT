package dev.Juliana.pages;
import org.openqa.selenium.By;
public class LoginPage extends BasePage{

    //Locators
    private By emailAddressLocator = By.id("email");
    private By passwordLocator = By.name("password");
    private By submitBtnLocator = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    private By tagMyAccountLocator = By.tagName("h1");


    public void signin() {
        if(super.isDisplayed(emailAddressLocator)) {
            super.type("julianaoliveiraqa@outlook.com", emailAddressLocator);
            super.type("testadora2", passwordLocator);
            super.click(submitBtnLocator);
        } else {
            System.out.println("email textbox was not present");
        }
    }

    public String getMyAccountMessage() {
        return super.getText(tagMyAccountLocator);
    }
}
