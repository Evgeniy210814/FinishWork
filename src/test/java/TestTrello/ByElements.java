package TestTrello;

import org.openqa.selenium.By;

public class ByElements {
    public static By findButtonSignIn = By.xpath("//a[@class='global-header-section-button']");
    public static By findFieldLogin =By.cssSelector("#user");
    public static By findFieldPassword =By.cssSelector("#password");
    public static By findButtonLogin = By.cssSelector("#login");
    public static By findButtonUserMenu = By.xpath(".//span[@title='Евгений (user80882857)']");
    public static By findButtonLogOut = By.xpath("//a[@class='js-logout']");
    public static By findErrorMessage = By.xpath("//p[@class='error-message']");
    public static By findButtonHome = By.xpath("//span[@class='header-btn-icon icon-lg icon-house light']");
    public static By findButtonBoard = By.xpath("//span[@class='header-btn-text'][contains(text(),'Доски')]");
    public static By findItemChosen = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div");
    public static By findItemRecent = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[2]");
    public static By findFieldSearch = By.xpath("//input[@placeholder='Поиск по названию…']");
    public static By findControlButtonsInMenu =By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/a[1]");
    public static By findButtonSearchBoard = By.xpath("//div[@class='header-search']//input[@type='text']");
    public static By findFieldSearchBoard = By.xpath("//span[@class='header-search-icon icon-lg icon-search light js-search-icon header-search-icon-dark hide']");
    public static By findButtonAllPage = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/div[1]/div[3]/div[1]/a[1]");
    public static By findButtonCloseFieldSearch = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/div[1]/div[3]/div[1]/span[2]");
    public static By findFieldSearchInCentralPage = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/input[1]");
    public static By findButtonsInMenuCreateBoard = By.xpath("//ul[@class='pop-over-list']/li");
    public static By findControlMenu = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/div[1]/div[5]/a");
    public static By findMasButtonInInformation = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li");
    public static By findDataInNotification = By.xpath("//span[contains(text(),'Обновление Условий использования')]");
    public static By findElementInUser = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/ul");
    public static By findButtonBoardsInMainBoard = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li");
    public static By findBasicBoards = By.xpath("//h3[contains(text(),'Персональные доски')]");
    public static By findMainPage = By.xpath("//div[@class='orientation-card__infoContainer__2lmIm']");
    public static By findFieldNameTeam = By.cssSelector("#org-display-name");
    public static By findFieldDiscriptionTeam = By.cssSelector("#org-desc");
    public static By findButtonCreateTeam = By.xpath("//input[@value='Создать']");
    public static By findButtonCreateTeamOnMainBoard = By.xpath("//span[contains(text(),'Создать команду')]");
    public static By findButtonCloseInMenuCreateTeam = By.xpath("//a[@class='pop-over-header-close-btn icon-sm icon-close']");
    public static By selectColorBoard = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/form[1]/div[1]/ul[1]/li");
    public static By findFieldNameBoard = By.xpath("//input[@placeholder='Добавить заголовок доски']");
    public static By findButtonCreateBoard = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/form[1]/button[1]/span[2]");
    public static By findButtonPrivate = By.xpath("//div[@class='board-tile create-board-tile has-photo-background']//div//button[@type='button']");
    public static By findCreatedBoard =By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/ul[1]/li[1]/div[1]/a[1]/span[2]");
    public static By findNameNewBoard =By.xpath("//a[@class='board-header-btn board-header-btn-name js-rename-board']");
    public static By findEditNameBoardField =By.xpath("/html[1]/body[1]/div[2]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]");
    public static By findButtonRename = By.xpath("//input[@value='Переименовать']");
    public static By findMenuInBoard = By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']");
    public static By findButtonInMenu = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li");
    public static By findButtonCloseBoard = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul");
    public static By findButtonCloseInPopap = By.xpath("//input[@value='Закрыть']");
    public static By findButtonDeleteBoard =By.xpath("//a[@class='quiet js-delete']");
    public static By findAcceptDelete = By.xpath("//input[@value='Удалить']");
    public static By findSelectTeam = By.xpath("//span[contains(text(),'team')]");
    public static By findSelectInMenuSetting = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/div[2]/ul[1]/li[1]/ul[1]/li");
    public static By findButtonDeleteTeam = By.xpath("//span[contains(text(),'Удалить команду')]");
    public static By findButtonDeleteforever =By.xpath("//input[@value='Удалить навсегда']");

}
