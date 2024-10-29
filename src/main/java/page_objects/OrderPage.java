package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// страница заказа сервиса Яндекс Самокат
public class OrderPage {
    protected static WebDriver driver;

    //костанты и локаторы
    private final By userNameString= By.xpath(".//input[contains(@placeholder,'Имя')]");
    private final By userLastNameString= By.xpath(".//input[contains(@placeholder,'Фамилия')]");
    private final By userAddressString= By.xpath(".//input[contains(@placeholder,'Адрес')]");
    private final By metroStationString= By.xpath(".//input[contains(@placeholder,'Станция метро')]");
    private final By userTelephoneString= By.xpath(".//input[contains(@placeholder,'Телефон')]");
    private final By orderNextButton= By.xpath(".//button[contains (@class, 'Button_Middle')]");
    private final By rentalPeriodInput= By.xpath(".//div[@class='Dropdown-control']");
    private final By rentalPeriodOption= By.xpath(".//div[(@class='Dropdown-option')and text()='сутки']");
    private final By deliveryDateInput = By.xpath(".//input[contains(@placeholder, 'Когда привезти самокат')]");
    private final By deliveryDayDatePicker = By.xpath(".//div[contains(@class, 'datepicker__day--selected')]");
    private static final String COLOR_SET_PATTERN = ".//input[@id='%s']";
    private final By orderEndButton= By.xpath(".//button[contains (@class, 'Button_Middle') and text()='Заказать']");
    private final By orderConfirmButton= By.xpath(".//button[contains(@class, Button_Button)and text()='Да']");
    private final By orderTextInModal= By.xpath(".//div[contains(@class,'Order_Modal')and text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        OrderPage.driver = driver;
    }

      //методы:
      //заполняем поле Имя
    public void userNameStringSet(String name){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(userNameString));
        driver.findElement(userNameString).click();
        driver.findElement(userNameString).sendKeys(name);
    }

    //заполняем поле Фамилия
    public void userLastNameStringSet(String lastName){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(userLastNameString));
        driver.findElement(userLastNameString).sendKeys(lastName);
    }

    //заполняем поле Адрес
    public void userAddressStringSet(String userAddress) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(userAddressString));
        driver.findElement(userAddressString).sendKeys(userAddress);
    }

    //выбираем станцию метро
    public void metroStationStringSet() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(metroStationString));
        driver.findElement(metroStationString).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    //заполняем поле Телефон
    public void userTelephoneStringSet(String userTelephone) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(userTelephoneString));
        driver.findElement(userTelephoneString).sendKeys(userTelephone);
    }

    //нажимаем кнопку Далее
    public void setOrderNextButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderNextButton));
        driver.findElement(orderNextButton).click();
    }

    //выбираем дату доставки
    public void deliveryDateSet(String date){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDateInput));
        driver.findElement(deliveryDateInput).sendKeys(date);
        driver.findElement(deliveryDayDatePicker).click();
    }

    //кликаем в поле срок аренды
   public void rentalPeriodSet() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(rentalPeriodInput));
        driver.findElement(rentalPeriodInput).click();
   }

    //выбираем срок аренды в меню
    public void rentalPeriodOptionSet(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(rentalPeriodOption));
        driver.findElement(rentalPeriodOption).click();
    }

    //выбираем цвет самоката
    public void colorCheckBoxSet(String color){
        String colorLocator = String.format(COLOR_SET_PATTERN, color);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(colorLocator)));
        driver.findElement(By.xpath(colorLocator)).click();
    }

    //нажимаем конечную кнопку Заказать
    public void orderEndButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderEndButton));
      driver.findElement(orderEndButton).click();
    }

    //нажимаем Да для подтверждения заказа
        public void orderConfirmButtonClick() {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(orderConfirmButton));
        driver.findElement(orderConfirmButton).click();
    }
    //появление модального окна Заказ оформлен
   public  boolean OrderTextInModalExist(){
      new WebDriverWait(driver, Duration.ofSeconds(7))
             .until(ExpectedConditions.visibilityOfElementLocated(orderTextInModal));
      return driver.findElement(orderTextInModal).isDisplayed();
   }

}
