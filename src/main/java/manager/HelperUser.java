package manager;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//a[text()=' Logout ']"));
        return list.size() > 0;
    }

    public void logout() {
        click(By.xpath("//div[@class = 'header']/a[5]"));
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);

    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
        //  div/app-login/form/button

    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text() = ' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void clickCheckbox() {
        wd.navigate().back();
        click(By.className("checkbox-container"));
    }



    public String checkMessage() {
        return wd.findElement(By.cssSelector("h2.message")).getText();
        //return wd.findElement(By.xpath("//h2[text()='\"Login or Password incorrect\"']")).getText();
    }

    public String checkWrongEmail() {
        return wd.findElement(By.cssSelector("div[class^='error'] div")).getText();

    }

    public void closeDialog() {
        if(isElementPresent(By.xpath("//button[text()='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public void checkTermofuse() {
        click(By.xpath("//a[text() = 'terms of use']"));
    }

    public void checkPrivacyPolicy() {
        wd.navigate().back();
        click(By.xpath("//a[text() = 'privacy policy']"));
    }

    public boolean isYallaButtonNotActive() {
        return !wd.findElement(By.cssSelector("button[disabled]")).isEnabled();
    }
}
