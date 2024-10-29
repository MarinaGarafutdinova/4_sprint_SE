
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page_objects.MainPage;
import page_objects.OrderPage;

//страница теста создания заказа через верхнюю и нижнюю кнопку заказать
@RunWith(Parameterized.class)
public class CheckOrderCreateTest extends BaseUITest{
    private final String name;
    private final String lastName;
    private final String userAddress;
    private final String userTelephone;
    private final String date;
    private final String color;

    public CheckOrderCreateTest(String name, String lastName, String userAddress,
                                String userTelephone, String date, String color) {
        this.name = name;
        this.lastName = lastName;
        this.userAddress = userAddress;
        this.userTelephone = userTelephone;
        this.date = date;
        this.color = color;
    }

    //тестовые данные
    @Parameterized.Parameters
    public static Object[][] getOrderIsSuccessful() {
        return new Object[][] {
                {"Маша","Иванова","Зеленая 5","+79119054545","2024-10-30","black"},
                {"Коля","Герасимов","Красная 7","+79214504545","2024-11-01","grey"},
        };
    }

    //тест создания заказа через верхнюю кнопку Заказать
    @Test
    public void CheckFirstScenarioOrderCreateTest () {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.setCloseCookieButtonClick();
        mainPage.upOrderButtonClick();
        OrderPage orderPage= new OrderPage(driver);
        orderPage.userNameStringSet(name);
        orderPage.userLastNameStringSet(lastName);
        orderPage.userAddressStringSet(userAddress);
        orderPage.metroStationStringSet();
        orderPage.userTelephoneStringSet(userTelephone);
        orderPage.setOrderNextButtonClick();
        orderPage.deliveryDateSet(date);
        orderPage.rentalPeriodSet();
        orderPage.rentalPeriodOptionSet();
        orderPage.colorCheckBoxSet(color);
        orderPage.orderEndButtonClick();
        orderPage.orderConfirmButtonClick();
        boolean textInModal = orderPage.OrderTextInModalExist();
        Assert.assertTrue(textInModal);
   }

       //тест создания заказа через нижнюю кнопку Заказть
        @Test
       public void CheckSecondScenarioOrderCreateTest ()   {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.setCloseCookieButtonClick();
        mainPage.downButtonClick();
        OrderPage orderPage= new OrderPage(driver);
        orderPage.userNameStringSet(name);
        orderPage.userLastNameStringSet(lastName);
        orderPage.userAddressStringSet(userAddress);
        orderPage.metroStationStringSet();
        orderPage.userTelephoneStringSet(userTelephone);
        orderPage.setOrderNextButtonClick();
        orderPage.deliveryDateSet(date);
        orderPage.rentalPeriodSet();
        orderPage.rentalPeriodOptionSet();
        orderPage.colorCheckBoxSet(color);
        orderPage.orderEndButtonClick();
        orderPage.orderConfirmButtonClick();
        boolean textInModal = orderPage.OrderTextInModalExist();
        Assert.assertTrue(textInModal);
        }
      }



