package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends BasicTest {
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void successRegistration()  {
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User().withName("Garri").withLastName("Potter").withEmail("garri"+i+"@mail.ru").withPassword("Garri@123");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkTermofuse();
        app.getHelperUser().checkPrivacyPolicy();
        app.getHelperUser().clickCheckbox();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().checkMessage(),"You are logged in success");


    }

    @Test
    public void RegistrationWrongEmail() {
        User user = new User().withName("Garri").withLastName("Potter").withEmail("garrimail.ru").withPassword("Garri@123");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkTermofuse();
        app.getHelperUser().checkPrivacyPolicy();
        app.getHelperUser().clickCheckbox();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().checkWrongEmail(),"Wrong email format");
        app.getHelperUser().isYallaButtonNotActive();
        app.getHelperUser().submit();
//
    }

    @Test
    public void RegistrationWrongPassword() {

    }

    @Test
    public void RegistrationUnregisterUser() {

    }
    @AfterMethod
    public void closeDialog() {
      //  app.getHelperUser().closeDialog();
    }
}
