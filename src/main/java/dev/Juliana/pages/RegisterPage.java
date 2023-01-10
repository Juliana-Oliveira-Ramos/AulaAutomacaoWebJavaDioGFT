package dev.Juliana.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage{

    //dados iniciais
    private By emailAddressLocator = By.name("email");
    private By PasswordLocator = By.name("password");
    private By submitBtnLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");

//escolher o genero
private By genderFemaleLocator = By.id("id_gender2");
    //preenche com o nome, email e senha
  private By nameLocator = By.id("name");
    private By emailLocator = By.id("email");

    private By passwordLocator = By.id("password");
//data de nascimento
    private By daysLocator = By.id("days");
    private By monthsLocator = By.id("months");
    private By yearsLocator = By.id("years");

    //newslatter
    private By newsletterLocator = By.id("newsletter");
    private By receiveOffersLocator = By.id("uniform-optin");


//informaçoes de  nome e endereço
private By firstNameLocator = By.id("first_name");
private By lastNameLocator = By.id("last_name");
    //Locators YOUR ADDRESS
    private By companyLocator = By.id("company");
    private By address1Locator = By.id("address1");
    private By address2Locator = By.id("address2");
    private By countryLocator = By.id("id_country");
    private By stateLocator = By.id("id_state");
    private By cityLocator = By.id("city");
    private By zipCodeLocator = By.id("zipcode");
    private By mobileNumberLocator = By.id("mobile_number");
    private By registerBtnLocator = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button");
    //depois de logado ira na pagina inicial
    private By welcomeMessageLocator = By.cssSelector("#center_column > p");

    private By additionalInformationLocator = By.name("other");
   // private By homePhoneLocator = By.id("phone");

    private By futureAddressLocator = By.id("alias");
    private By alertAdditionalInformationLocator = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[2]/p[11]");


    //Locators YOUR PERSONAL INFORMATION
   // private By customerFirstNameLocator = By.id("customer_firstname");
    // private By customerLastNameLocator = By.id("customer_lastname");


    public void insertEmailToRegister() {
        if(super.isDisplayed(emailAddressLocator)) {
            type("julianaoliveiraqa@outlook.com", emailAddressLocator);
            click(submitBtnLocator);
        } else {
            System.out.println("email textbox was not present");
        }
    }

    public String getEmailNewAccount() {
        super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
        return super.getTextByAttribute(this.emailLocator, "value");
    }

    public void fillOutForm() {
        this.insertEmailToRegister();
        super.waitVisibilityOfElementLocated(additionalInformationLocator);
        if(super.isDisplayed(genderFemaleLocator)) {
            super.click(genderFemaleLocator);
            super.type("Juliana", firstNameLocator);
            super.type("Oliveira", lastNameLocator);
            super.type("testadora2", passwordLocator);
            super.selectByValue(daysLocator, "14");
            super.selectByValue(monthsLocator, "1");
            super.selectByValue(yearsLocator, "1993");
            super.click(newsletterLocator);
            super.click(receiveOffersLocator);
            super.type("DIO", companyLocator);
            super.type("Street Name, 123", address1Locator);
            super.type("xxxxx", address2Locator);
            super.type("Taquaritinga", cityLocator);
            super.selectByValue(stateLocator, "Sao Paulo");
            super.selectByValue(countryLocator, "United States");
            super.type("12345", zipCodeLocator);
           // super.type("Additionl Information Test", additionalInformationLocator);
            //super.type("99999999", homePhoneLocator);
            super.type("99999999", mobileNumberLocator);
            super.clear(futureAddressLocator);
            String addressLocatorFuture = getTextByAttribute(address1Locator, "value");
            super.type(addressLocatorFuture, futureAddressLocator);
            super.click(registerBtnLocator);
        } else {
            System.out.println("message was not found.");
        }
    }

    public String getWelcomeMessage() {
        super.waitVisibilityOfElementLocated(welcomeMessageLocator);
        return super.getText(welcomeMessageLocator);
    }



}
