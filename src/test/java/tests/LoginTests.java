package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }


    @Test
    public void successLogin() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("rehovot1@gmail.ru", "Remember123@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());


    }

    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("rehovot1gmail.ru", "Remember123@");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());


    }

    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("rehovot1@gmail.ru", "Re123@");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    @Test
    public void loginUnregisterUser() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("rehovoot1@gmail.ru", "Remember123@");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());

    }
}
