package auction

class Address {
    def scaffolding=true
    String address1
    String address2
    String city
    String state
    String zip
    Date datecreated=new Date()
    static constraints = {
        address1(nullable:false)
        address2(nullable:true)
        city(nullable: false)
        state(nullable: false)
        zip(nullable: false)
    }
}
