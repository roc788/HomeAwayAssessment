package pages.applestore

import geb.Page

class LoginPage extends Page {

    static at = { title == 'ONLINE STORE › Log In'}

    static content = {
        username(wait: true){ name -> $("input[name='log']").value(name)}
        password{ password -> $("input[name='pwd']").value(password)}
        loginButton{ $("input[name='wp-submit']")}
    }
}