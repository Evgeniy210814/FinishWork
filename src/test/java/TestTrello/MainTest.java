package TestTrello;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.awt.dnd.DropTarget;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //@Parameters("driver-name")
    @BeforeClass (groups = {"valid","notValid","input"})
    public static void start() throws MalformedURLException {
        driver=new ChromeDriver();
        //driver=HelperClass.getDriver(browserType);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.navigate().to(DataForTest.url);
        wait = new WebDriverWait(driver, 5);
        driver.findElement(ByElements.findButtonSignIn).click();
    }
    //@Test(priority = 1, groups = {"valid"})
    public static void validLogin() {
        sleep(300);
        driver.findElement(ByElements.findButtonSignIn).click();
        sleep(400);
        driver.findElement(ByElements.findFieldLogin).clear();
        driver.findElement(ByElements.findFieldPassword).clear();
        driver.findElement(ByElements.findFieldLogin).sendKeys(DataForTest.login);
        driver.findElement(ByElements.findFieldPassword).sendKeys(DataForTest.password);
        driver.findElement(ByElements.findButtonLogin).click();
        sleep(800);
        driver.findElement(ByElements.findButtonUserMenu).click();
        driver.findElement(ByElements.findButtonLogOut).click();
        //WebElement userMenu = wait.until(ExpectedConditions.presenceOfElementLocated(ByElements.findButtonLogOut));
        //exit.click();
    }
    @Test(priority = 2,groups = {"notValid"})
    public static void notValidPassword(){
        //driver.findElement(ByElements.findButtonSignIn).click();
        driver.findElement(ByElements.findFieldLogin).clear();
        driver.findElement(ByElements.findFieldPassword).clear();
        driver.findElement(ByElements.findFieldLogin).sendKeys(DataForTest.login);
        driver.findElement(ByElements.findFieldPassword).sendKeys(DataForTest.notValidPassword);
        driver.findElement(ByElements.findButtonLogin).click();
        sleep(800);
        assertTrue(driver.findElement(ByElements.findErrorMessage).getText().contains("Неверный пароль"));
    }
    @Test(priority = 3,groups = {"notValid"})
    public static void notValidLogin(){
        driver.findElement(ByElements.findFieldLogin).clear();
        driver.findElement(ByElements.findFieldPassword).clear();
        driver.findElement(ByElements.findFieldLogin).sendKeys(DataForTest.notValidLogin);
        driver.findElement(ByElements.findFieldPassword).sendKeys(DataForTest.password);
        driver.findElement(ByElements.findButtonLogin).click();
        sleep(800);
        assertTrue(driver.findElement(ByElements.findErrorMessage).getText().contains("Аккаунт с таким адресом электронной почты не существует"));
    }
    @Test(priority = 4,groups = {"notValid"})
    public static void notValidLoginPassword() {
        driver.findElement(ByElements.findFieldLogin).clear();
        driver.findElement(ByElements.findFieldPassword).clear();
        driver.findElement(ByElements.findFieldLogin).sendKeys(DataForTest.notValidLogin);
        driver.findElement(ByElements.findFieldPassword).sendKeys(DataForTest.notValidPassword);
        driver.findElement(ByElements.findButtonLogin).click();
        sleep(800);
        assertTrue(driver.findElement(ByElements.findErrorMessage).getText().contains("Аккаунт с таким адресом электронной почты не существует"));
    }
    @Test(priority = 5,groups = {"input"})
    public static void findButtonHome() {

        driver.findElement(ByElements.findFieldLogin).clear();
        driver.findElement(ByElements.findFieldPassword).clear();
        driver.findElement(ByElements.findFieldLogin).sendKeys(DataForTest.login);
        driver.findElement(ByElements.findFieldPassword).sendKeys(DataForTest.password);
        driver.findElement(ByElements.findButtonLogin).click();
        //sleep(800);
        assertTrue(HelperClass.isFindElement(ByElements.findButtonHome));
        driver.findElement(ByElements.findButtonHome).click();
    }
    @Test(priority = 6,groups = {"input"})
    public static void findButtonBoard() {
        sleep(800);
        driver.findElement(ByElements.findButtonBoard).click();
        sleep(800);
        assertTrue(HelperClass.isFindElement(ByElements.findFieldSearch));
        assertTrue(HelperClass.findElementsInMenu(ByElements.findItemChosen,"ИЗБРАННЫЕ"));
        //assertTrue(HelperClass.findElementsInMenu(ByElements.findItemChosen,"ПЕРСОНАЛЬНЫЕ ДОСКИ"));
        assertTrue(HelperClass.findElementsInMenu(ByElements.findControlButtonsInMenu,"Создать новую доску…"));
        assertTrue(HelperClass.findElementsInMenu(ByElements.findControlButtonsInMenu,"Закрепить это меню."));
        assertTrue(HelperClass.findElementsInMenu(ByElements.findControlButtonsInMenu,"Закрытые доски…"));
    }
    @Test(priority = 7,groups = {"input"})
    public static void findButtonSearch(){
        driver.findElement(ByElements.findButtonSearchBoard).click();
        assertTrue(HelperClass.isFindElement(ByElements.findFieldSearchBoard));
        assertTrue(HelperClass.isFindElement(ByElements.findButtonAllPage));
        driver.findElement(ByElements.findButtonCloseFieldSearch).click();
    }
    @Test(priority = 8,groups = {"input"})
    public static void findButtonSearchClick(){
        driver.findElement(ByElements.findButtonSearchBoard).click();
        driver.findElement(ByElements.findButtonAllPage).click();
        assertTrue(HelperClass.isFindElement(ByElements.findFieldSearchInCentralPage));
        driver.findElement(ByElements.findButtonHome).click();
    }
    @Test(priority = 9,groups = {"input"})
    public static void findButtonCreateBoard(){
        sleep(300);
        //driver.findElement(ByElements.findButtonCreateBoard).click();
        HelperClass.findElementsInMainMenu(ByElements.findControlMenu,0).click();
        sleep(300);
        assertTrue(HelperClass.findElementsInMenu(ByElements.findButtonsInMenuCreateBoard,"Создать доску"));
        assertTrue(HelperClass.findElementsInMenu(ByElements.findButtonsInMenuCreateBoard,"Создание команды"));
        assertTrue(HelperClass.findElementsInMenu(ByElements.findButtonsInMenuCreateBoard,"Создать бизнес-команду"));
    }
    @Test(priority = 10,groups = {"input"})
    public static void findButtonInformation(){
        sleep(300);
        //driver.findElement(ByElements.findButtonCreateBoard).click();
        HelperClass.findElementsInMainMenu(ByElements.findControlMenu,1).click();
        sleep(300);
        assertTrue(HelperClass.findElementsInMenu(ByElements.findMasButtonInInformation,"Тур"));
        assertTrue(HelperClass.findElementsInMenu(ByElements.findMasButtonInInformation,"Цены"));
        assertTrue(HelperClass.findElementsInMenu(ByElements.findMasButtonInInformation,"Приложения"));
        assertTrue(HelperClass.findElementsInMenu(ByElements.findMasButtonInInformation,"Блог"));
        assertTrue(HelperClass.findElementsInMenu(ByElements.findMasButtonInInformation,"Конфиденциальность"));
    }
    @Test(priority = 11,groups = {"input"})
    public static void findButtonNotification(){
        sleep(300);
        //driver.findElement(ByElements.findButtonCreateBoard).click();
        HelperClass.findElementsInMainMenu(ByElements.findControlMenu,2).click();
        sleep(300);
        assertTrue(HelperClass.isFindElement(ByElements.findDataInNotification));
    }
    @Test(priority = 12,groups = {"input"})
    public static void findElementInUserMenu(){
        sleep(300);
        //driver.findElement(ByElements.findButtonCreateBoard).click();
        HelperClass.findElementsInMainMenu(ByElements.findControlMenu,3).click();
        sleep(600);
        assertTrue(HelperClass.findElementInUserMenu(ByElements.findElementInUser,"Профиль"));
        assertTrue(HelperClass.findElementInUserMenu(ByElements.findElementInUser,"Карточки"));
        assertTrue(HelperClass.findElementInUserMenu(ByElements.findElementInUser,"Помощь"));
        assertTrue(HelperClass.findElementInUserMenu(ByElements.findElementInUser,"Горячие клавиши"));
        assertTrue(HelperClass.findElementInUserMenu(ByElements.findElementInUser,"Сменить язык…"));
        assertTrue(HelperClass.findElementInUserMenu(ByElements.findElementInUser,"Выйти"));
        assertTrue(HelperClass.findElementInUserMenu(ByElements.findElementInUser,"Настройки"));
    }
    @Test(priority = 13,groups = {"input"})
    public static void findButtonBoards(){
        HelperClass.findElementsInMainMenu(ByElements.findButtonBoardsInMainBoard,0).click();
        assertTrue(HelperClass.isFindElement(ByElements.findBasicBoards));

    }
    @Test(priority = 14,groups = {"input"})
    public static void findButtonMainPage(){
        sleep(300);
        HelperClass.findElementsInMainMenu(ByElements.findButtonBoardsInMainBoard,1).click();
        assertTrue(HelperClass.isFindElement(ByElements.findMainPage));
    }
    @Test(priority = 15,groups = {"input"})
    public static void findButtonCreateComandClose(){
        driver.findElement(ByElements.findButtonHome).click();
        sleep(300);
        driver.findElement(ByElements.findButtonCreateTeamOnMainBoard).click();
        sleep(300);
        driver.findElement(ByElements.findButtonCloseInMenuCreateTeam).click();

    }

    @Test(priority = 16,groups = {"input"})
    public static void findButtonCreateComand(){
        driver.findElement(ByElements.findButtonHome).click();
        sleep(300);
        HelperClass.findElementsInMainMenu(ByElements.findControlMenu,0).click();
        sleep(300);
        HelperClass.findButtonCreateNewComand(ByElements.findButtonsInMenuCreateBoard,"Создание команды").click();
        sleep(300);
        driver.findElement(ByElements.findFieldNameTeam).sendKeys("Team");
        driver.findElement(ByElements.findFieldDiscriptionTeam).sendKeys("Team");
        driver.findElement(ByElements.findButtonCreateTeam).click();
        sleep(1000);
        driver.findElement(ByElements.findButtonHome).click();
    }
    @Test(priority = 17,groups = {"input"})
    public static void createNewBoard() {
        sleep(800);
        driver.findElement(ByElements.findButtonBoard).click();// /html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]
        //HelperClass.findElementsInMainMenu(ByElements.findControlButtonsInMenu,0).click();
        driver.findElement(ByElements.findControlButtonsInMenu).click();
        sleep(800);
        //driver.findElement(ByElements.findControlButtonsInMenu).click();
        HelperClass.findElementsInMainMenu(ByElements.selectColorBoard,1).click();

        sleep(1000);
        HelperClass.findElementsInMainMenu(ByElements.selectColorBoard,1).click();
        driver.findElement(ByElements.findFieldNameBoard).sendKeys("board");
        sleep(1000);
        assertTrue(HelperClass.isFindElement(ByElements.findButtonPrivate));
        driver.findElement(ByElements.findButtonCreateBoard).click();
        sleep(3000);
        driver.findElement(ByElements.findButtonHome).click();

    }
    @Test(priority = 18,groups = {"input"})
    public static void editNewBoard() {
        sleep(1000);
        driver.findElement(ByElements.findButtonBoard).click();
        sleep(1000);
        driver.findElement((ByElements.findCreatedBoard)).click();
        sleep(1000);
        driver.findElement(ByElements.findNameNewBoard).click();
        driver.findElement(ByElements.findEditNameBoardField).sendKeys("NewBoard");
        driver.findElement(ByElements.findButtonRename).click();

    }
    @Test(priority = 22,groups = {"input"})
    public static void deleteBoard() {
        sleep(1000);
        driver.findElement(ByElements.findMenuInBoard).click();
        sleep(1000);
        HelperClass.findElementsInMainMenu(ByElements.findButtonInMenu,4).click();
        HelperClass.findElementsInMainMenu(ByElements.findButtonCloseBoard,2).click();
        sleep(300);
        driver.findElement(ByElements.findButtonCloseInPopap).click();
        driver.findElement(ByElements.findButtonDeleteBoard).click();
        driver.findElement(ByElements.findAcceptDelete).click();
        driver.findElement(ByElements.findButtonHome).click();

    }
    @Test(priority = 23,groups = {"input"})
    public static void deleteTeam() {
        sleep(1000);
        driver.findElement(ByElements.findSelectTeam).click();
        sleep(1000);
        HelperClass.findElementsInMainMenu(ByElements.findSelectInMenuSetting,3).click();
        driver.findElement(ByElements.findButtonDeleteTeam).click();
        driver.findElement(ByElements.findButtonDeleteforever).click();


    }

    @AfterClass (groups = {"valid","notValid","input"})
    public static void close(){
        driver.quit();
    }

}
