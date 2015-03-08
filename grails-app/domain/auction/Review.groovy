package auction

class Review {
    def scaffolding = true
    Account account
    String reviewtype
    String comments
    boolean thumbsUp
    Date datecreated = new Date()
    static  belongsTo = [reviewer: Account]
    static constraints = {
        reviewtype(nullable: false, inList: 'Seller','Buyer')
        account(nullable: false)
        reviewer(nullable: false )
    }
}
