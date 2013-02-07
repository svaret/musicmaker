class UrlMappings {

    static mappings = {
        "/$controller/random" {
            action = [GET:"random"]
        }

        "/$controller/dropDatabase" {
            action = [GET:"dropDatabase"]
        }

        "/$aController/$id?" {
            controller = { "${params.aController}" }
            action = [GET: "read", POST: "create", PUT: "update"]
        }

        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
    }
}
