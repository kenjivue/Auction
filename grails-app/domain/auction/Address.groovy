package auction

class Address {
    def scaffolding=true
    String addressName
    String address1
    String address2
    String city
    String state
    String zip
    Date datecreated=new Date()
    static constraints = {
        addressName(nullable: true, blank:true)
        address1(nullable:false, blank:false)
        address2(nullable:true, blank:true)
        city(nullable: false, blank:false)
        state(nullable: false, blank:false)
        zip(nullable: false, blank:false)
    }
}
