package pages.applestore

import geb.Page

class DashBoardPage extends Page {

    static at = { title == 'Dashboard ‹ ONLINE STORE — WordPress' || title == 'Profile ‹ ONLINE STORE — WordPress'}

    static content = {
        profileTab(wait: true){ $("div.wp-menu-name", text: 'Profile')}
        firstNameBox(wait: true){ $("input[name='first_name']") }
        updateProfile(wait: true){ $("input[value='Update Profile']")}
        accountMenu(wait: true){ $("li#wp-admin-bar-my-account")}
        logoutMenuItem(wait: true){ $("a", text: 'Log Out')}
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
