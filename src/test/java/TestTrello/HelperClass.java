package TestTrello;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HelperClass {
    static WebDriver driver = MainTest.driver;
    public static WebDriver getDriver(String browserType) throws MalformedURLException {
        WebDriver driver = null;
        if(browserType.equals("chrome")) {
            //System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if(browserType.equals("firefox")) {
            //System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }
    public static boolean isFindElement(By locator){
        try{
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e){
            System.out.println(e);
            return false;
        }
    }
    public static boolean findElementsInMenu(By locator, String nameElement){
        List<WebElement> elements =new ArrayList<WebElement>();
        WebElement element;
        try {
            elements=driver.findElements(locator);
            System.out.println(elements.size());
            for (int i = 0; i <elements.size(); i++) {
                if (elements.get(i).getText().contains(nameElement)){
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public static WebElement findButtonCreateNewComand(By locator,  String nameElement){
        List<WebElement> elements =new ArrayList<WebElement>();
        WebElement element;
        elements=driver.findElements(locator);
        System.out.println(elements.size());
        for (int i = 0; i <elements.size(); i++) {
            if (elements.get(i).getText().contains(nameElement)){
                return elements.get(i);
            }
        }
        return null;
    }
    public static WebElement findElementsInMainMenu(By locator, int numberElement){
        List<WebElement> elements =new ArrayList<WebElement>();
        WebElement element;
        try {
            System.out.println(elements.size());
            elements=driver.findElements(locator);
            return elements.get(numberElement);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }
    public static boolean findElementInUserMenu(By locator, String nameElement) {
        int count = 0;
        List<WebElement> elements_1 = new ArrayList<WebElement>();
        List<WebElement> elements_2 = new ArrayList<WebElement>();
        elements_1 = driver.findElements(locator);
        for (int i = 0; i < elements_1.size(); i++) {
            elements_2 = elements_1.get(i).findElements(By.cssSelector("li"));
            System.out.println("in" + " " + elements_2.size());
            for (int j = 0; j < elements_2.size(); j++) {
                if (elements_2.get(j).getText().contains(nameElement)){
                    System.out.println(elements_2.get(j).getText()+" "+nameElement);
                    return true;
                }

            }
        }
        return false;
            /*label:for (int i = 0; i < nameElement.length; i++) {
                for (int j = 0; j < elements_1.size(); j++) {
                    System.out.println("el1"+" "+elements_1.size());
                    elements_2 = elements_1.get(i).findElements(By.cssSelector("li"));
                    for (int k = 0; k <elements_2.size(); k++) {
                        if (elements_2.get(k).getText().contains(nameElement[i])) {
                            count++;
                            System.out.println(elements_2.get(j).getText()+" "+nameElement[k]);
                            System.out.println(count);
                            continue label;
                        }
                    }
                }
            }
            if(count!=(int)elements_1.size()) {
                return false;
            }else {
                System.out.println(count);
                return true;
            }*/

    }
}

