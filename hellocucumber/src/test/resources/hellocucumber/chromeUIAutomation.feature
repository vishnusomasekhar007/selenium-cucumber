Feature: User Registration and Add item to Cart with validations using Chrome browser 

	
	
@chromeUIAutomation	
Scenario: User Registration and Adds item to Cart 
	Given User is on Homepage 
	And User navigates to SignIn Page 
	When User registers with valid emailID post validation for incorrect emailID 
	And User enters form details for registration
	Then User navigates to MegaMenu Dresses
	And Selects Summer Dresses SubMenu
	And Verify if grid view is selected
	Then User sorts items by price
	And validate if product grid is arranged properly
	Then User selects a product
	And User changes colour of product 
	Then Add product to cart and checkout
	And Validate Cart Summary details for selected product details
	Then User SignsOut
	#And Close Browser
	
	
	
	
	
