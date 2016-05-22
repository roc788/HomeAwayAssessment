package pages.applestore

import geb.Page

class AccountPage extends Page {

    static at = { title == 'Your Account | ONLINE STORE'}

    static content = {
        username(wait: true){ name -> $("input[name='log']").value(name)}
        password(wait: true){ password -> $("input[name='pwd']").value(password)}
        loginButton(wait: true){ $("form[name='loginform'] input[name='submit']")}
        siteAdmin(wait: true){ $("a", text: 'Site Admin')}
    }


}
