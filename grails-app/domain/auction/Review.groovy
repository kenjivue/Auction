package auction

class Review {
    def scaffolding = true
    Account account
    String comments
    boolean thumbsUp
    Date dateCreated = new Date()
    String reviewType
    static belongsTo = [reviewer: Account, listing: Listing]
    static constraints = {
        reviewType nullable: false, inList: ['Seller','Buyer']
        account(nullable: false)
        reviewer(nullable: false )
        comments(nullable: true)
    }
}
