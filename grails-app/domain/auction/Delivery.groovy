package auction

class Delivery {
    def scaffolding=true
    String delivery
    Date datecreated=new Date()
    static constraints = {
        delivery(nullable: false)

    }
}
