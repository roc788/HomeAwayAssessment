package pages

import geb.Page


class IPhonesPage extends Page {

    static at = { title == "iPhones | ONLINE STORE"}

    static content = {
        addToCart { product -> $("a", text: product).closest("div.productcol").find("input[value='Add To Cart']")}
        productPriceVal{ product -> $("a", text: product).closest("div.productcol").find("span.currentprice").text() }
        goToCheckout(wait: true){ $("a.go_to_checkout")}
    }

    Float getProductPrice(String product) {
        String price = productPriceVal(product)
        return price.replace('$','').toFloat()
    }

}