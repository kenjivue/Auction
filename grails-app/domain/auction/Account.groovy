package auction

class Account {
    def scaffolding=true
    String name
    String password
    String email
    Address address
    Date dateCreated=new Date()
    Date dateUpdated=new Date()
    static hasMany = [reviews: Review]
    static constraints = {
        email(nullable: false, email: true)
        password(blank: false, nullable: false, size:6..16, validator: {password, obj ->
            if (!password.matches('^.*\\p{Alpha}.*$') ||
                    !password.matches('^.*\\p{Digit}.*$'))return ['invalid.matchingpasswords']
        })
        name(nullable: false,size:6..150)
        address(nullable:false, blank: false)
    }
}
