package auction

class Bid {
    def scaffolding=true
    Listing listing
    Account bidder
    BigDecimal amount
    Date bidDate=new Date()
    def getBidderName(){
        return bidder.name
    }
    static constraints = {
        bidder(nullable: false, validator:{ val,obj-> val!=obj.listing.owner})
        amount(nullable:false, min: 0.5, validator:{val,
        obj-> def allBids=Bid.findAllByListing(obj.listing)
            def minimum=allBids*.amount.max()
            if(minimum){val>=minimum+0.5}
            else {val>=obj.listing.startingPrice}
        })
        bidDate(nullable: false, validator: {val, obj -> val<=obj.listing.endDate})
}
}
