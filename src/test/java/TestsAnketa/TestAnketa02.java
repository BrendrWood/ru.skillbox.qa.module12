package TestsAnketa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAnketa02 extends WebDriverSettings {
    @Test (retryAnalyzer = Retry.class)
    public void testAnketa02 () {
        driver.get("http://qa.skillbox.ru/module11/practice/");
        driver.manage().window().maximize();

        //Ввести произвольное имя в поле "Имя"
        driver.findElement(By.xpath("//input[@name='name']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Денис");

        //Кликнуть радиобутон "Жен" поля выбора пола
        driver.findElement(By.xpath("//*[.='Жен']")).click();

        //Выбрать элемент "Холост/не замужем" выпадающего списка "Семейное положение"
        driver.findElement(By.xpath("//div[@class='baseSelect__header']")).click();
        action.pause(500).build().perform();
        driver.findElement(By.xpath("//a[@href='notMarried']")).click();

        //Кликнуть радиобутон "Да" поля выбора "Дети"
        driver.findElement(By.xpath("//*[.='Да']")).click();

        //Выбрать элемент "Украина" выпадающего списка "Страна проживания"
        driver.findElement(By.xpath("//span[.='Страна проживания']")).click();
        action.pause(1000).build().perform();
        action.dragAndDropBy(driver.findElement(By.xpath("//div[@class='vb-dragger']")), 1, 20).build().perform();
        driver.findElement(By.xpath("//a[.='Украина']")).click();

        //Выбрать элемент "Кандидат наук" выпадающего списка "Образование"
        driver.findElement(By.xpath("//span[.='Образование']")).click();
        action.pause(500).build().perform();
        driver.findElement(By.xpath("//a[.='Кандидат наук']")).click();

        //Выбрать элемент "27" выпадающего списка "Возраст"
        driver.findElement(By.xpath("//span[.='Возраст']")).click();
        action.pause(500).build().perform();
        driver.findElement(By.xpath("//a[@href='27']")).click();
        action.pause(500).build().perform();

        //Кликнуть радиобутон "Да" поля "Судимость"
        driver.findElement(By.xpath("//div[contains(.,'Судимость:')]/div[@class='radioButtonGroup__items']/*[.='Да']")).click();
        action.pause(500).build().perform();

        //Кликнуть кнопку "Отправить"
        driver.findElement(By.xpath("//*[.='Отправить']")).click();
        action.pause(500).build().perform();

        //Проверка наличия сообщения об ошибке
        element = driver.findElement(By.xpath("//div[@class='radioButtonGroup radioButtonGroup--error']/div[@class='radioButtonGroup__message']"));
        String ActualContent = element.getText();
        String ExpectedContent = "К сожалению, кандидатов с данными характеристиками мы пока не рассматриваем к полетам. Спасибо за проявленный интерес к нашей организации!";
        Assert.assertEquals(ActualContent, ExpectedContent);
        }
}