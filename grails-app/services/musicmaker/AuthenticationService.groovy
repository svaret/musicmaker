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

import static java.util.Arrays.asList

class AuthenticationService {
    private GoogleAuthorizationCodeFlow flow

    private static final String CLIENT_ID = "72370846401-jo027588vl6vimint313crgh4r1t940h.apps.googleusercontent.com"
    private static final String CLIENT_SECRET = "c2Y0I2-TtoICzcfAVP2i9cXg"
    private static final Iterable<String> SCOPE = asList("https://www.googleapis.com/auth/userinfo.profile",
            "https://www.googleapis.com/auth/userinfo.email")
    private static final JsonFactory JSON_FACTORY = new JacksonFactory()
    private static final String OFFLINE = "offline"
    private static final String CALLBACK_URI = "http://localhost:8090/musicmaker/authentication/callback"
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport()
    private static final String USER_INFO_URL = "https://www.googleapis.com/oauth2/v1/userinfo"

    AuthenticationService() {
        flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, CLIENT_ID,
                CLIENT_SECRET, SCOPE).build()
    }

    def getGoogleAuthorizationUrl() {
        GoogleAuthorizationCodeRequestUrl url = flow.newAuthorizationUrl()
        url.setRedirectUri(CALLBACK_URI).setState("google;601227152").setAccessType(OFFLINE).build()
    }

    String getUserEmail(String authenticationCode) {
        GoogleTokenResponse response = flow.newTokenRequest(authenticationCode).setRedirectUri(CALLBACK_URI).execute()
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