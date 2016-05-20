package pages

import geb.Page

class AccountPage extends Page {

    static at = { title == 'Your Account | ONLINE STORE'}

    static content = {
        username(wait: true){ name -> $("input[name='log']").value(name)}
        password{ password -> $("input[name='pwd']").value(password)}
        loginButton{ $("form[name='loginform'] input[name='submit']")}
        siteAdmin{ $("a", text: 'Site Admin')}
    }


}
