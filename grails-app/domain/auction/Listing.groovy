package auction
class Listing {
    def scaffolding = true
    String listingName
    String listingDescription
    Integer listingDays
    BigDecimal startingPrice
    Date startDate
    String deliveredby
    Date dateCreated = new Date()
    static belongsTo = [owner: Account]
    Date endDate=null
    static hasMany = [bids:Bid, reviews: Review]
    static constraints = {
        owner(nullable: false)
        listingName(nullable: false)
        listingDays(nullable: false)
        startingPrice(min: 0.5, nullable: false)
        startDate(nullable: false)
        deliveredby(nullable: false, inList: ["US Only","Worldwide","Pickup Only"]) //refactored from class to arraylist
        endDate(nullable: true)
    }

}
