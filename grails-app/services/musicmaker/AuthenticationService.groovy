package musicmaker

import com.google.api.client.auth.oauth2.Credential
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpRequestFactory
import com.google.api.client.http.HttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson.JacksonFactory
import groovy.json.JsonSlurper

import javax.annotation.PostConstruct

import static java.util.Arrays.asList

class AuthenticationService {
    def grailsApplication
    private String clientID
    private String clientSecret
    private String callbackURI

    private GoogleAuthorizationCodeFlow flow
    private static final Iterable<String> SCOPE = asList("https://www.googleapis.com/auth/userinfo.profile",
            "https://www.googleapis.com/auth/userinfo.email")
    private static final JsonFactory JSON_FACTORY = new JacksonFactory()
    private static final String OFFLINE = "offline"
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport()
    private static final String USER_INFO_URL = "https://www.googleapis.com/oauth2/v1/userinfo"

    @PostConstruct
    private void init() {
        clientID = grailsApplication.config.google.authorization.client.id
        clientSecret = grailsApplication.config.google.authorization.client.secret
        callbackURI = grailsApplication.config.google.authorization.callback.uri
        flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientID,
                clientSecret, SCOPE).build()
    }

    def getGoogleAuthorizationUrl() {
        GoogleAuthorizationCodeRequestUrl url = flow.newAuthorizationUrl()
        url.setRedirectUri(callbackURI).setState("google;601227152").setAccessType(OFFLINE).build()
    }

    String getUserEmail(String authenticationCode) {
        GoogleTokenResponse response = flow.newTokenRequest(authenticationCode).setRedirectUri(callbackURI).execute()
        Credential credential = flow.createAndStoreCredential(response, null)
        HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(credential)

        // Make an authenticated request
        GenericUrl url = new GenericUrl(USER_INFO_URL)
        HttpRequest request = requestFactory.buildGetRequest(url)
        request.getHeaders().setContentType("application/json")
        String jsonIdentity = request.execute().parseAsString()

        new JsonSlurper().parseText(jsonIdentity).email
    }
}