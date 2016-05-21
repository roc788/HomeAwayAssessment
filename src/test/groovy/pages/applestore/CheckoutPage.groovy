package pages.applestore

import geb.Page

class CheckoutPage extends Page {

    String price

    static at = { title == 'Checkout | ONLINE STORE'}

    static content = {
        subtotalVal(wait: true){ $("span.yourtotal span.pricedisplay").text() }
        continueButton(wait: true){ $("span", text: "Continue")}
        purchaseButton { $("input.make_purchase")}
        removeButton(wait: true){item -> $("a", text: item).closest("tr.product_row").find("input[value='Remove']")}
        checkoutContent(wait: true){ $(".entry-content").text() }
        shippingRegion(wait: true){ region -> $("form input.shipping_region").value(region)}
        email { email -> $("form input[title='billingemail']").value(email)}
        firstName { firstName -> $("form input[title='billingfirstname']").value(firstName)}
        lastName { lastName -> $("form input[title='billinglastname']").value(lastName)}
        address { address -> $("form textarea[title='billingaddress']").value(address)}
        city { city -> $("form input[title='billingcity']").value(city)}
        state { state -> $("form input[title='billingstate']").value(state)}
        country { country -> $("form select[title='billingcountry']").value(country)}
        phone { phone -> $("form input[title='billingphone']").value(phone)}
        shippingCostVal{ $("tr.total_shipping span.pricedisplay")[1].text() }
        totalPriceVal{$("tr.total_price span.pricedisplay")[1].text() }
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
