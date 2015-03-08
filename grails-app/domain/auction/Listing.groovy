package auction
class Listing {
    def scaffolding=true
    String  listingName
    String listingDescription
    Integer listingDays
    BigDecimal startingPrice
    Date startDate
    Delivery deliveredby
    Date dateCreated=new Date()
    static belongsTo = [owner: Account]
    static constraints = {
        owner(nullable: false)
        listingName(nullable:false)
        listingDays(nullable: false)
        startingPrice(min: 0.5,nullable: false)
        startDate(nullable: false )
        deliveredby(nullable: false)
    }
}
