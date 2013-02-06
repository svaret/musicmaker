class UrlMappings {

    static mappings = {
        "/$controller/random" {
            action = [GET:"random"]
        }

        "/$aController/$id?" {
            controller = { "${params.aController}" }
            action = [GET: "show", POST: "save", PUT: "update"]
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
