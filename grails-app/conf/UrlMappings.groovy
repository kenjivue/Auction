class UrlMappings {
    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/api/account"(resources: 'accountRest')
        "/api/listing"(resources: 'listingRest')
        "/api/detail"(resources: 'listingRest')
        "/api/review"(resources: 'reviewRest')
        "/api/bid"(resources: 'bidRest')
        "/$controller/$id?"{
            action = [GET:"show", POST:"save", PUT:"update", DELETE:"delete"]
        }

        "/"(view:"/index")
        "500"(view:'/error')
    }
}
