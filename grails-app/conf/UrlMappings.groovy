class UrlMappings {

	static mappings = {
        //"/song/$id?"(resource: "song")

        "/$aController"{
                    controller = {"${params.aController}"}
                    action = [GET: "show", POST: "save"]
        }

        "/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
