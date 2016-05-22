package pages.applestore

import geb.Page

class HomePage extends Page {

    static at = { title == 'ONLINE STORE | Toolsqa Dummy Test site' }

    static content = {
        productCategoryMenu(wait: true){ $("a", text: "Product Category") }
        productMenuItem(wait: true){ product -> $("a", text: product)}
        account(wait: true){$("a.account_icon")}
    }

    def selectProduct(String product) {
        interact {
            moveToElement(productCategoryMenu)
        }
        productMenuItem(product).click()
    }

}
