package dev.Juliana.tests;

import dev.Juliana.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginPageTests {
    private LoginPage loginPage;
    private final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    @BeforeEach
    void setUp() throws Exception {
        this.loginPage = new LoginPage();
        this.loginPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.loginPage.quitWebDriver();
    }

    @Test
    void test() {
        //when
        this.loginPage.signin();

        //then
        Assertions.assertTrue(this.loginPage.getMyAccountMessage().equals(" Logged in as "));
        Assertions.assertFalse(this.loginPage.getCurrentUrl().equals(this.URL));
    }
}
