package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//главная страница сервиса Яндекс Самокат
public class MainPage {
    public static WebDriver driver;

//костанты и локаторы
    public static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final String IMPORTANT_QUESTION_PATTERN  = ".//div[contains(@id, 'accordion__heading') and contains(text(), '%s')]";
    private static final By accordionAnswerString= By.xpath(".//div[contains (@class,'accordion__panel') and not (@hidden)]/p");
    private static final By upOrderButton= By.xpath(".//div[contains(@class,'Header_Nav')]/button[text()='Заказать']");
    private static final By downOrderButton= By.xpath(".//button[contains(@class,'Button_Middle')]");
    private final By closeCookieButton= By.xpath(".//button[contains(@class,'App_CookieButton')]");

    public MainPage(WebDriver driver){
        MainPage.driver = driver;
    }
    public void openMainPage(){
        driver.get(MAIN_PAGE_URL);
    }
    //методы:
    //закрываем предупреждение о куках
    public void setCloseCookieButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(closeCookieButton));
        driver.findElement(closeCookieButton).click();
    }
    //нажимаем на вопрос в аккордеоне
    public void importantQuestionsClick(String questionMessage){
        String questionLocator = String.format(IMPORTANT_QUESTION_PATTERN, questionMessage);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(questionLocator)));

        WebElement questionElement = driver.findElement(By.xpath(questionLocator));
        scrollToElement(questionElement);
        questionElement.click();
    }

    // скролл до элемента
    public void scrollToElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //получаем ответ на вопрос в аккордеоне
    public String answerAccordionExist(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionAnswerString));
    WebElement realAnswer = driver.findElement(accordionAnswerString);
        return realAnswer.getText();
    }

    //нажимаем верхнюю кнопку Заказать
    public void upOrderButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(upOrderButton));
        driver.findElement(upOrderButton).click();
    }

    //нажимаем нижнюю кнопку Заказать
   public void downButtonClick() {
       new WebDriverWait(driver, Duration.ofSeconds(5))
               .until(ExpectedConditions.elementToBeClickable(upOrderButton));
       WebElement element = driver.findElement(downOrderButton);
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
       driver.findElement(downOrderButton).click();
   }
   }
