package auction

class Review {
    def scaffolding = true
    Account account
    String comments
    boolean thumbsUp
    Date datecreated = new Date()
    ReviewType reviewType
    static belongsTo = [reviewer: Account]
    static constraints = {
        reviewType(nullable: false)
        account(nullable: false)
        reviewer(nullable: false )
        comments(nullable: true)
    }
}
