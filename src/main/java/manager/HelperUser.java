package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.awt.SystemColor.text;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//a[@href='/logout?url=%2Fsearch']"));
        return list.size() > 0;
    }

    public void logout() {
        click(By.xpath("//a[@href='/logout?url=%2Fsearch']"));
    }

    public void openLoginForm() {
        click(By.xpath("//a[.=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath ("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"), password);

    }

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
        //  div/app-login/form/button

    }

}
