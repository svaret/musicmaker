class UrlMappings {

	static mappings = {
        "/rest/$controller/list"(parseRequest:true) {
            action = [GET:"list", POST: "save"]
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
