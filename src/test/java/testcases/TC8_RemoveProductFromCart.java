package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.ProductPage;
import pageobjects.SearchResultsPage;
import pageobjects.ShoppingCartPage;

/**
 * Test Case: Product Remove from Checkout page
 * 
 * Steps:
 * 1. Navigate to application URL
 * 2. Enter an existing product name in the search text box
 * 3. Click the search button
 * 4. Verify the product appears in the search results
 * 5. Select the product from the search results
 * 6. Add the product to the cart
 * 8. Verify the success message
 * 9. Click on Shopping cart and remove the items
 * 10. Verify the Your shopping cart is empty! is to be display
 */

public class TC8_RemoveProductFromCart extends BaseClass  {

		@Test(groups = {"Master"})
		public void testRemoveItemsFromCart() throws InterruptedException {
		//1. Navigate to application URL
		String appUrl = properties.getProperty("appURL");
		driver.get(appUrl);
		logger.info("Navigated to application URL: "+appUrl);
		
		HomePage homepage = new HomePage(driver);
		String ProductName = properties.getProperty("searchProductName");
		//2. Enter an existing product name in the search text box
		homepage.enterProductName(ProductName);
		logger.info("Entered product name in serach box: "+ProductName);
		// 3. Click the search button
		 SearchResultsPage searchResultPage = homepage.clickSearch();
		logger.info("Clicked the search button.");
		//4. Verify the product appears in the search results
		if(searchResultPage.isProductExist(ProductName)) {
			logger.info("product found in search result: "+ ProductName);
			
			//5. Select the product from the search results
			ProductPage productPage = searchResultPage.selectProduct(ProductName);
			logger.info("Selected product: "+ ProductName);
			
			// 6. Add the product to the cart
			productPage.addToCart();
			logger.info("Clicked 'Add to Cart' for product: "+ ProductName);
			
			// 8. Verify the success message
			boolean isSuccessMessageDisplayed = productPage.checkConfMsg();
			Assert.assertTrue(isSuccessMessageDisplayed,"Success message not displayed!");
			logger.info("Success message verified successfully");
			
			//9. Click on Shopping cart and remove the items
			homepage.checkOutPage();
			logger.info("Clicked on CheckoutPage");
			
			Thread.sleep(5000);
			
			ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
			shoppingCartPage.Removeproduct();
			logger.info("Clicked On Remove Button");
			
			//10. Verify the "Your shopping cart is empty!" Message is display
			String isEmptyMessageDisplayed = shoppingCartPage.ConfMessage();
			 Assert.assertEquals(isSuccessMessageDisplayed, "Your shopping cart is empty!");
			 logger.info("message verified successfully");
			
			 shoppingCartPage.ClickOnContinue();
			
		}else {
			logger.error("Product not found in search result :"+ProductName);
			Assert.fail("Prosuct not found in search");
		}
		
		
		
		
		
	}
}
