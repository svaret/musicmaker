package musicmaker

class SecurityFilters {
    def filters = {
        authorizationCheck(controller: '*', action: '*') {
            before = {
                if (!session.authCode && ['songs', 'chords'].contains(controllerName)) {
                    redirect uri: '/'
                    return false
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}