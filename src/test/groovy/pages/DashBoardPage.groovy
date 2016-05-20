package pages

import geb.Page

class DashBoardPage extends Page {

    static at = { title == 'Dashboard ‹ ONLINE STORE — WordPress'}

    static content = {
        profileTab{ $("div.wp-menu-name", text: 'Profile')}
        firstName {name -> $("input[name='first_name']")}
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
}