package Pages;

import org.openqa.selenium.WebElement;

public class BasePage {
	

    public void clickOnElement(WebElement locator){
        locator.click();
    }

    public void writeOnElement(WebElement locator, String text){
        locator.clear();
        locator.sendKeys(text);
    }

    public String getElementText(WebElement locator){
        return locator.getText();
    }

    public void sleepTime() throws InterruptedException {
    	Thread.sleep(3000);
    }

}
