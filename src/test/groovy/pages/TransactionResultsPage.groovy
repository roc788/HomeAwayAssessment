package pages

import geb.Page

import java.util.regex.Matcher

class TransactionResultsPage extends Page {

    String totals

    static at = { title == 'Transaction Results | ONLINE STORE'}

    static content = {
        priceTotals { $("div.entry-content p")[2].text() }
    }

    Float getTotalPrice() {
        totals = priceTotals()
        def price = /Total: \$([0-9]+\.[0-9]+)./
        Matcher matcher = ( totals =~ price)
        return matcher[0][1].replace('$','').toFloat()
    }

    Float getShippingCost() {
        totals = priceTotals()
        def price = /Total Shipping: \$([0-9]+\.[0-9]+)./
        Matcher matcher = ( totals =~ price)
        return matcher[0][1].replace('$','').toFloat()
    }
}
