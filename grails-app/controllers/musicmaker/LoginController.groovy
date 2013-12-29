package musicmaker

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow
import com.google.api.client.http.HttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson.JacksonFactory
import grails.converters.JSON

import static java.util.Arrays.asList

class LoginController {
    private static final String CLIENT_ID = "72370846401-jo027588vl6vimint313crgh4r1t940h.apps.googleusercontent.com"
    private static final String CLIENT_SECRET = "c2Y0I2-TtoICzcfAVP2i9cXg";
    private static final String CALLBACK_URI = "http://localhost:8090/musicmaker/login/authenticate";
    private static final Iterable<String> SCOPE = asList("https://www.googleapis.com/auth/userinfo.profile",
            "https://www.googleapis.com/auth/userinfo.email")
    private static final String USER_INFO_URL = "https://www.googleapis.com/oauth2/v1/userinfo"
    private static final JsonFactory JSON_FACTORY = new JacksonFactory()
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport()
    private GoogleAuthorizationCodeFlow flow

    LoginController() {
        flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, CLIENT_ID,
                CLIENT_SECRET, SCOPE).build()
    }

    def login() {
        def result = [url: "https://accounts.google.com/o/oauth2/auth?" +
                "client_id=72370846401-jo027588vl6vimint313crgh4r1t940h.apps.googleusercontent.com&" +
                "redirect_uri=http://localhost:8090/musicmaker/login/authenticate&" +
                "response_type=code&" +
                "scope=https://www.googleapis.com/auth/userinfo.profile%20https://www.googleapis.com/auth/userinfo.email&" +
                "state=google;601227152"]
        render result as JSON
    }

    def authenticate() {
//        [error:access_denied, state:google;601227152, action:authenticate, controller:login]
//        [state:google;601227152, code:4/88odFKmMVst_23oIb36tLLLTlsXN.0uHXWR3mgaAYPvB8fYmgkJxNhtNxhgI, action:authenticate, controller:login]
        System.out.println(params)
        session.code = params.code
        render(view: "/index.gsp")
    }


    def code() {
        def result = [code: session.code]
        render result as JSON
    }

    def logout() {
        session.invalidate()
        def result = [status: "OK"]
        render result as JSON
    }
}