package auction

import grails.transaction.Transactional

class BidService {

    def createNewBid(Bid bidInstance) {
        bidInstance.bidDate = new Date()
        if (bidInstance.listing.endDate > new Date()){
            if (!bidInstance.hasErrors() && bidInstance.save())
            {

            } else  {

                throw new grails.validation.ValidationException("Bid Error", bidInstance.errors)

            }

        }
        else {

            throw new grails.validation.ValidationException("Listing Expired", bidInstance.errors)
        }

        return bidInstance
    }
}
