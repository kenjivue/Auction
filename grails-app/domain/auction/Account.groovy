package auction

class Account {
    def scaffolding=true
    String name
    String email
    User user
    Date dateCreated=new Date()
    Date dateUpdated=new Date()
    static hasMany = [reviews: Review,address: Address]
    static constraints = {
        email(nullable: false, email: true)
        name(nullable: false,size:6..150)
        address(nullable:false, blank: false)
    }
}
