package musicmaker

import grails.converters.JSON

class AuthenticationController {
    AuthenticationService authenticationService
    AccountService accountService

    def login() {
        def result = [url: authenticationService.login()]
        render result as JSON
    }

    def callback() {
        def email = authenticationService.getUserEmail(params.code)
        if (!accountService.accountExists(email))
            accountService.createAccount(email)
        session.code = params.code
        session.email = email

        render(view: "/index.gsp")
    }

    def code() {
        def result = [code: session.code, email: session.email]
        render result as JSON
    }

    def logout() {
        session.invalidate()
        def result = [status: "OK"]
        render result as JSON
    }
}