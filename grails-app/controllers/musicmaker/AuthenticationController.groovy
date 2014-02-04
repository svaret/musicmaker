package musicmaker

import grails.converters.JSON

class AuthenticationController {
    AuthenticationService authenticationService
    AccountService accountService

    def login() {
        int i = 1
        def result = [url: authenticationService.getGoogleAuthorizationUrl()]
        render result as JSON
    }

    def callback() {
        if (params.error) {
            redirect uri: '/'
            return
        }

        def email = authenticationService.getUserEmail(params.code)
        if (!accountService.accountExists(email))
            accountService.createAccount(email)
        session.code = params.code
        session.email = email

        redirect uri: '/'
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