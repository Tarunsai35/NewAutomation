package testcases;

import org.testng.annotations.Test;

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

	@Test
		public void testRemoveItemsFromCart() {
		//1. Navigate to application URL
		String appUrl = properties.getProperty("appURL");
		driver.get(appUrl);
		logger.info("Navigated to application URL: "+appUrl);
		
		//2. Enter an existing product name in the search text box
		
		
	}
}
