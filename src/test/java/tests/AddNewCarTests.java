package tests;

import model.Car;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends BasicTest{
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("rehovot1@gmail.ru").withPassword("Remember123@"));
        }
    }

    @Test
    public void addNewCarSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        Car car = Car.builder()
                .location("Haifa, Israel")
                .manufacture("BMW")
                .model("M5")
                .year("2020")
                .fuel("Petrol")
                .seats("4")
                .clasS("C")
                .carRegNumber("66-66-" +i)
                .price("65")
                .about("very nice car")
                .build();


        app.getHelperCar().openCarForm();
        app.getHelperCar().pause(1000);
        app.getHelperCar().fillCarForm(car);
         app.getHelperCar().attachPhoto("C:\\Users\\corvett.jpeg");
        app.getHelperCar().submit();

    }
}
