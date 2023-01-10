package dev.Juliana.tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dev.Juliana.pages.RegisterPage;

public class RegisterPageTest {
    //classe onde iremos adicionar o email para realizar o cadastro no site
    //Locators
    private RegisterPage registerPage;
    private final String URL = "https://automationexercise.com/signup";


    @BeforeEach
    void setUp() throws Exception {
        this.registerPage = new RegisterPage();
        this.registerPage.visit(this.URL);
    }
    @AfterEach
    void tearDown() throws Exception {
        this.registerPage.quitWebDriver();
    }

    @Test
    void test() {
        //when
        this.registerPage.insertEmailToRegister();

        //then
        String expected = "julianaoliveiraqa@outllok.com";
        String actual = this.registerPage.getEmailNewAccount();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2() {
        //when
        this.registerPage.fillOutForm();

        //then
        String expected = "Congratulations! Your new account has been successfully created!\n" +
                "\n" +
                "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String actual = this.registerPage.getWelcomeMessage();
        Assertions.assertEquals(expected, actual);

        String actualUrl = this.registerPage.getCurrentUrl();
        Assertions.assertFalse(this.URL.equals(actualUrl));
    }
    void insertEmailToRegister(){}

}
