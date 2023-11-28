package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        // Open browser and launch Url
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Men Menu
        mouseHoverToElement(By.id("ui-id-5"));
        // Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']"));
        // Click on Pants
        mouseHoverAndClickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        // Mouse Hover on product name Cronus Yoga Pant and click on size 32.
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverAndClickOnElement(By.xpath("(//div[@class='swatch-option text'])[1]"));
        // Mouse Hover on product name Cronus Yoga Pant and click on colour Black.
        mouseHoverAndClickOnElement(By.xpath("(//div[@class='swatch-option color'])[1]"));
        // Mouse Hover on product name Cronus Yoga Pant and click on ‘Add To Cart’ Button.
        clickOnElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
        Thread.sleep(1000);
        // Verify the text You added Cronus Yoga Pant to your shopping cart.
        verifyTextDisplayed(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"), "You added Cronus Yoga Pant to your shopping cart.");
        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the text ‘Shopping Cart.’
        verifyTextDisplayed(By.xpath("//span[@class='base']"), "Shopping Cart");
        // Verify the product name ‘Cronus Yoga Pant’
        verifyTextDisplayed(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"), "Cronus Yoga Pant");
        // Verify the product size ‘32’
        verifyTextDisplayed(By.xpath("//dd[contains(text(),'32')]"), "32");
        // Verify the product colour ‘Black’
        verifyTextDisplayed(By.xpath("//dd[contains(text(),'Black')]"), "Black");
    }

    @After
    public void tearDown() {
        // Close all open tabs
        closeBrowser();
    }
}
