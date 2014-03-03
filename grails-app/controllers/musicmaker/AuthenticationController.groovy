package musicmaker

import grails.converters.JSON

class AuthenticationController {
    AuthenticationService authenticationService
    AccountService accountService

    def login() {
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
        session.authCode = params.code
        session.email = email

        redirect uri: '/'
    }

    def code() {
        def result = [authCode: session.authCode, email: session.email]
        render result as JSON
    }

    def logout() {
        session.invalidate()
        def result = [status: "OK"]
        render result as JSON
    }
}