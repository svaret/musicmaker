package musicmaker

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(AuthenticationController)
class AuthenticationControllerTest extends Specification {
    AuthenticationService authenticationService = Mock()
    AccountService accountService = Mock()

    def setup() {
        controller.authenticationService = authenticationService
        controller.accountService = accountService
    }

    def "callback should create user when user does not exist"() {
        given:
        params.code = "authCode"
        authenticationService.getUserEmail("authCode") >> "email@domain.se"
        accountService.accountExists("email@domain.se") >> false

        when:
        controller.callback()

        then:
        1 * accountService.createAccount("email@domain.se")
        session.authCode == "authCode"
        session.email == "email@domain.se"
        response.redirectedUrl == '/'
    }

    def "callback should just render start page when user denies access"() {
        given:
        params.error = "access denied"

        when:
        controller.callback()

        then:
        0 * authenticationService.getUserEmail()
        0 * accountService.accountExists()
        0 * accountService.createAccount()
        response.redirectedUrl == '/'
    }
}