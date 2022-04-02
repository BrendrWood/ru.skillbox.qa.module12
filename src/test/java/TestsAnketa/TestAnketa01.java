package TestsAnketa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAnketa01 extends WebDriverSettings {

    @Test (retryAnalyzer = Retry.class)
    public void testAnketa01 () {
        driver.get("http://qa.skillbox.ru/module11/practice/");
        driver.manage().window().maximize();

        //Ввести произвольное имя в поле "Имя"
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Денис");

        //Кликнуть радиобутон "Жен" поля выбора пола
        driver.findElement(By.xpath("//*[.='Жен']")).click();

        //Выбрать элемент "В гражданском браке" выпадающего списка "Семейное положение"
        driver.findElement(By.xpath("//div[@class='baseSelect__header']")).click();
        action.pause(500).build().perform();
        driver.findElement(By.xpath("//a[@href='civilMarriage']")).click();

        //Кликнуть радиобутон "Нет" поля выбора "Дети"
        driver.findElement(By.xpath("//*[.='Нет']")).click();

        //Выбрать элемент "Беларусь" выпадающего списка "Страна проживания"
        driver.findElement(By.xpath("//span[.='Страна проживания']")).click();
        action.pause(500).build().perform();
        driver.findElement(By.xpath("//a[.='Беларусь']")).click();

        //Выбрать элемент "Высшее" выпадающего списка "Образование"
        driver.findElement(By.xpath("//span[.='Образование']")).click();
        action.pause(500).build().perform();
        driver.findElement(By.xpath("//a[.='Высшее']")).click();

        //Выбрать элемент "26" выпадающего списка "Возраст"
        driver.findElement(By.xpath("//span[.='Возраст']")).click();
        action.pause(500).build().perform();
        driver.findElement(By.xpath("//a[@href='26']")).click();
        action.pause(500).build().perform();

        //Кликнуть радиобутон "Нет" поля "Судимость"
        driver.findElement(By.xpath("//div[contains(.,'Судимость:')]/div[@class='radioButtonGroup__items']/*[.='Нет']")).click();
        action.pause(500).build().perform();

        //Кликнуть кнопку "Отправить"
        driver.findElement(By.xpath("//*[.='Отправить']")).click();
        action.pause(500).build().perform();

        //Проверка наличия благодарственного сообщения
        element = driver.findElement(By.xpath("//h1[@class='h1 page__title']"));
        String ActualContent = element.getText();
        String ExpectedContent = "Спасибо";
        Assert.assertEquals(ActualContent, ExpectedContent);

    }
}


