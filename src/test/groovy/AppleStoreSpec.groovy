import geb.spock.GebReportingSpec
import pages.AccountPage
import pages.CheckoutPage
import pages.DashBoardPage
import pages.HomePage
import pages.IPhonesPage
import pages.LoginPage
import pages.TransactionResultsPage

class AppleStoreSpec extends GebReportingSpec {

    def "Can submit an iphone order"(){

        when:
        to HomePage
        selectProduct("iPhones")

        at IPhonesPage
        Float iphonePrice = getProductPrice("Apple iPhone 4S 16GB SIM-Free – Black")
        addToCart("Apple iPhone 4S 16GB SIM-Free – Black").click()
        goToCheckout.click()

        at CheckoutPage
        Float subtotal = getSubtotal()

        then:
        assert iphonePrice == subtotal

        when:
        continueButton.click()
        fillForm()

        //Expectation was for the cost review to show up on the info page.  Only occurs when returning to the page.
        /*Float shippingCost = getShippingCost()
        Float totalPrice = getTotalPrice()

        then:
        assert totalPrice == subtotal + shippingCost*/

        purchaseButton.click()

        at TransactionResultsPage
        Float transResultsTotalPrice = getTotalPrice()
        Float transResultsShippingCost = getShippingCost()

        then:
        assert transResultsTotalPrice == subtotal + transResultsShippingCost
    }

    def "Verify update to account is applied assuming account was already created"(){

        when:
        to HomePage
        account.click()

        at AccountPage
        username("Joe")
        password("foobar")
        loginButton.click()
        siteAdmin.click()

        at DashBoardPage
        profileTab.click()
        firstName("Joe")
        updateProfile.click()
        logout()

        at LoginPage
        username("Joe")
        password("foobar")
        loginButton.click()

        at DashBoardPage
        profileTab.click()

        then:
        assert firstName == 'Joe'

    }

    def "Verify removal of all cart items gives empty cart message "(){

        when:
        to HomePage
        selectProduct("iPhones")

        at IPhonesPage
        addToCart("Apple iPhone 4S 16GB SIM-Free – Black").click() //Product name with a long dash!
        goToCheckout.click()

        at CheckoutPage
        removeItem("Apple iPhone 4S 16GB SIM-Free - Black") //Product name with a short dash!

        then:
        assert checkoutContent == "Oops, there is nothing in your cart."
    }

}
