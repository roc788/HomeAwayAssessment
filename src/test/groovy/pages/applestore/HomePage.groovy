package pages.applestore

import geb.Page

class HomePage extends Page {

    static at = { title == 'ONLINE STORE | Toolsqa Dummy Test site' }

    static content = {
        productCategoryMenu { $("a", text: "Product Category") }
        productMenuItem { product -> $("a", text: product)}
        account {$("a.account_icon")}
    }

    def selectProduct(String product) {
        interact {
            moveToElement(productCategoryMenu)
        }
        productMenuItem(product).click()
    }

}
