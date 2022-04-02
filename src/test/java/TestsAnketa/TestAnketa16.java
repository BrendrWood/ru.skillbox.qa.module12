package TestsAnketa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAnketa16 extends WebDriverSettings {
    @Test (retryAnalyzer = Retry.class)
    public void testAnketa16 () {
        driver.get("http://qa.skillbox.ru/module11/practice/");
        driver.manage().window().maximize();

        //Ввести произвольное имя в поле "Имя"
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Денис");

        //Кликнуть радиобутон "Муж" поля выбора пола
        driver.findElement(By.xpath("//*[.='Муж']")).click();

        //Выбрать элемент "В гражданском браке" выпадающего списка "Семейное положение"
        driver.findElement(By.xpath("//div[@class='baseSelect__header']")).click();
        action.pause(500).build().perform();
        driver.findElement(By.xpath("//a[@href='civilMarriage']")).click();

        //Кликнуть радиобутон "Да" поля выбора "Дети"
        driver.findElement(By.xpath("//*[.='Да']")).click();

        //Выбрать элемент "Россия" выпадающего списка "Страна проживания"
        driver.findElement(By.xpath("//span[.='Страна проживания']")).click();
        action.pause(1000).build().perform();
        //action.dragAndDropBy(driver.findElement(By.xpath("//div[@class='vb-dragger']")), 1, 20).build().perform();
        driver.findElement(By.xpath("//a[.='Россия']")).click();

        //Выбрать элемент "Средне-специальное" выпадающего списка "Образование"
        driver.findElement(By.xpath("//span[.='Образование']")).click();
        action.pause(1000).build().perform();
        //action.dragAndDropBy(driver.findElement(By.xpath("//div[@class='vb-dragger']")), 1, 20).build().perform();
        driver.findElement(By.xpath("//a[.='Средне-специальное']")).click();

        //Проверка наличия сообщения об ошибке
        action.pause(1000).build().perform();
        element = driver.findElement(By.xpath("//div[@class='baseSelect baseSelect--animate baseSelect--error']/div[@class='baseSelect__message']"));
        String ActualContent = element.getText();
        String ExpectedContent = "К сожалению, кандидатов с данными характеристиками мы пока не рассматриваем к полетам. Спасибо за проявленный интерес к нашей организации!";
        Assert.assertEquals(ActualContent, ExpectedContent);
    }
}


