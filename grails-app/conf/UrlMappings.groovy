class UrlMappings {

    static mappings = {
        "/$controller/random" {
            action = [GET:"random"]
        }

        "/$controller/delete" {
            action = [GET:"delete"]
        }

        "/$aController/$id?" {
            controller = { "${params.aController}" }
            action = [GET: "read", POST: "create", PUT: "update", DELETE: "delete"]
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
