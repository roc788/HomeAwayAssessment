package pages.applestore

import geb.Page

class DashBoardPage extends Page {

    static at = { title == 'Dashboard ‹ ONLINE STORE — WordPress' || title == 'Profile ‹ ONLINE STORE — WordPress'}

    static content = {
        profileTab{ $("div.wp-menu-name", text: 'Profile')}
        firstNameBox { $("input[name='first_name']") }
        updateProfile{ $("input[value='Update Profile']")}
        accountMenu{ $("li#wp-admin-bar-my-account")}
        logoutMenuItem{ $("a", text: 'Log Out')}
    }

    def logout() {
        interact {
            moveToElement(accountMenu)
        }
        logoutMenuItem.click()
    }

    void setFirstName(String name){
        firstNameBox.value(name)
    }

    def getFirstName(){
        return firstNameBox.attr('value')
    }
}
