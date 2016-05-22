package pages.applestore

import geb.Page

class CheckoutPage extends Page {

    String price

    static at = { title == 'Checkout | ONLINE STORE'}

    static content = {
        subtotalVal(wait: true){ $("span.yourtotal span.pricedisplay").text() }
        continueButton(wait: true){ $("span", text: "Continue")}
        purchaseButton(wait: true){ $("input.make_purchase")}
        removeButton(wait: true){item -> $("a", text: item).closest("tr.product_row").find("input[value='Remove']")}
        checkoutContent(wait: true){ $(".entry-content").text() }
        shippingRegion(wait: true){ region -> $("form input.shipping_region").value(region)}
        email(wait: true){ email -> $("form input[title='billingemail']").value(email)}
        firstName(wait: true){ firstName -> $("form input[title='billingfirstname']").value(firstName)}
        lastName(wait: true){ lastName -> $("form input[title='billinglastname']").value(lastName)}
        address(wait: true){ address -> $("form textarea[title='billingaddress']").value(address)}
        city(wait: true){ city -> $("form input[title='billingcity']").value(city)}
        state(wait: true){ state -> $("form input[title='billingstate']").value(state)}
        country(wait: true){ country -> $("form select[title='billingcountry']").value(country)}
        phone(wait: true){ phone -> $("form input[title='billingphone']").value(phone)}
        shippingCostVal(wait: true){ $("tr.total_shipping span.pricedisplay")[1].text() }
        totalPriceVal(wait: true){$("tr.total_price span.pricedisplay")[1].text() }
    }

    def fillForm() {
        shippingRegion("Maryland")
        email("foobar@yahoo.com")
        firstName("John")
        lastName("Smith")
        address("333 foobar Court")
        city("foo")
        state("Maryland")
        country("USA")
        phone("555-555-5555")
    }

    Float getSubtotal() {
        price = subtotalVal()
        return price.replace('$','').toFloat()
    }

    Float getTotalPrice() {
        price = totalPriceVal()
        return price.replace('$','').toFloat()
    }

    Float getShippingCost() {
        price = shippingCostVal()
        return price.replace('$','').toFloat()
    }

    void removeItem(String item) {
        removeButton(item).click()
    }
}
