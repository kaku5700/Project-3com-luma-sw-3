package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        // Open browser and launch Url
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Gear Menu
        mouseHoverToElement(By.id("ui-id-6"));
        // Click on Bags
        clickOnElement(By.id("ui-id-25"));
        // Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        // Verify the text ‘Overnight Duffle’
        String expectedMessage = "Overnight Duffle";
        String actualMessage = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Change Qty 3
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        Thread.sleep(1000);
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        expectedMessage = "You added Overnight Duffle to your shopping cart.";
        actualMessage = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the product name ‘Overnight Duffle’
        expectedMessage = "Overnight Duffle";
        actualMessage = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //Verify the Qty is ‘3’
        expectedMessage = "3";
        actualMessage = driver.findElement(By.xpath("(//input[@class='input-text qty'])[1]")).getAttribute("value");
        Assert.assertEquals(expectedMessage, actualMessage);
        // Verify the product price ‘$135.00’
        expectedMessage = "$135.00";
        actualMessage = getTextFromElement(By.xpath("(//span[@class='cart-price']//span)[2]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Change Qty to ‘5’
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@class='input-text qty'])[1]")).clear();
        Thread.sleep(1000);
        sendTextToElement(By.xpath("(//input[@class='input-text qty'])[1]"), "5");
        // Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        Thread.sleep(1000);
        // Verify the product price ‘$225.00’
        expectedMessage = "$225.00";
        actualMessage = getTextFromElement(By.xpath("(//span[@class='cart-price']//span)[2]"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        // Close all open tabs
        closeBrowser();
    }
}
