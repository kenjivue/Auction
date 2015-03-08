import auction.Account
import auction.Address
import auction.Delivery
import auction.Listing
import auction.Review
import auction.ReviewType
import auction.Bid
class BootStrap {

    def init = { servletContext ->

        environments {
            development {
                LoadData()
            }
        }
    }
    def destroy = {
    }

    def LoadData() {
        println('Generating Test Data')
        Address add1 = new Address(address1: '5342 Northport Dr', city: 'Brooklyn Center', state: 'MN', zip: '55429').save(failOnError: true, flush: true)
        Address add2= new Address(address1: '1000 Wayne Manor Dr', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add3 = new Address(address1: '220 Arkham Rd', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add4= new Address(address1: '1212 Watchtower st', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)
        Address add5= new Address(address1: '1212 Main St', city: 'Gotham City', state: 'NY', zip: '54353').save(failOnError: true, flush: true)

        Account acc1 = new Account(name: 'Kenji Vue', password: 'sdfjks7898', email: 'kenjivue@live.com', address: add1).save(failOnError: true, flush: true)
        Account acc2 = new Account(name: 'Bruce Wayne', password: 'Batman589', email: 'batman@gotham.com',address: add2).save(failOnError: true, flush: true)
        Account acc3 = new Account(name: 'Oswald CobblePot', password: 'penguin666', email: 'peguin@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc4= new Account(name: 'Jim Gordon', password: 'C0mi55ioner', email: 'commish@gotham.com',address: add5).save(failOnError: true, flush: true)
        Account acc5= new Account(name: 'Edward Nigma', password: 'R1dddlemeThis', email: 'Riddler@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc6 = new Account(name: 'Fish Mooney', password: 'GanstaB1t**', email: 'gaasta@evil.com',address: add3).save(failOnError: true, flush: true)
        Account acc7 = new Account(name: 'Barbara Gordon', password: 'Batgirl65', email: 'batgirl@batfamily.com',address: add4).save(failOnError: true, flush: true)
        Account acc8= new Account(name: 'Dick Grayson', password: 'NightWing95', email: 'robin@batfamily.com',address: add4).save(failOnError: true, flush: true)

        Delivery del1= new Delivery(delivery: 'US Only').save(failOnError: true, flush: true)
        Delivery del2= new Delivery(delivery: 'Worldwide').save(failOnError: true, flush: true)
        Delivery del3= new Delivery(delivery: 'Pick Up Only').save(failOnError: true, flush: true)

        Listing list1=new Listing(listingName: 'Batmobile',listingDescription:'Used Batmobile , heavily damaged from crimefighting:  This is a fixer-upper, recommended for enthusiasts',
            listingDays: 20, startDate: new Date(),startingPrice: 50000,owner: acc2,deliveredby: del1).save(failOnError: true, flush: true)
        Listing list2=new Listing(listingName: 'Umbrella',listingDescription:'Umbrella used to stab the mayor in the heart',
            listingDays: 20, startDate: new Date(),startingPrice: 1000,owner: acc3,deliveredby: del2).save(failOnError: true, flush: true)
        Listing list3=new Listing(listingName: 'Glock 65',listingDescription:'Brand new gun, never fired a sigle shot',
            listingDays: 20, startDate: new Date(),startingPrice: 500,owner: acc4,deliveredby: del1).save(failOnError: true, flush: true)
        Listing list4=new Listing(listingName: 'Batarangs',listingDescription:'Set of 50 Batarangs, the perfect crime fighting tool!',
            listingDays: 20, startDate: new Date(),startingPrice: 1000,owner: acc8,deliveredby: del1).save(failOnError: true, flush: true)
        Listing list5=new Listing(listingName: 'Batgirl Costume',listingDescription:'Worn out crime fighting outfit.  major damage to the back area.  A  vintage collectors item',
            listingDays: 20, startDate: new Date(),startingPrice: 2500,owner: acc7,deliveredby: del3).save(failOnError: true, flush: true)
        Listing list6=new Listing(listingName: 'Top Hat',listingDescription:'Crushed Top hat.  Severly damaged from pummeling.',
            listingDays: 20, startDate: new Date(),startingPrice: 10,owner: acc5,deliveredby: del1).save(failOnError: true, flush: true)
        ReviewType rt = new ReviewType(reviewtype: 'Seller').save(failOnError: true, flush: true)
        ReviewType rt2 = new ReviewType(reviewtype: 'Buyer').save(failOnError: true, flush: true)
        Review r1 = new Review(reviewer: acc1, reviewType: rt, account: acc3, comments: 'Horrible Customer Service - Kept wanting to eat fish', thumbsUp: false).save(failOnError: true, flush: true)
        Review r2 = new Review(reviewer: acc2, reviewType: rt, account: acc2, comments: 'Awesome', thumbsUp: true).save(failOnError: true, flush: true)
        Review r3 = new Review(reviewer: acc3, reviewType: rt2, account: acc4, comments: 'Sold cheap crap', thumbsUp: false).save(failOnError: true, flush: true)
        Review r4 = new Review(reviewer: acc3, reviewType: rt, account: acc6, comments: 'Nice', thumbsUp: true).save(failOnError: true, flush: true)
        Review r5 = new Review(reviewer: acc4, reviewType: rt, account: acc5, comments: '', thumbsUp: false).save(failOnError: true, flush: true)
        Review r6 = new Review(reviewer: acc6, reviewType: rt2, account: acc4, comments: 'Happy with my purchase', thumbsUp: false).save(failOnError: true, flush: true)
        Review r7 = new Review(reviewer: acc8, reviewType: rt, account: acc4, comments: 'Good Feedback', thumbsUp: true).save(failOnError: true, flush: true)
        Review r8 = new Review(reviewer: acc7, reviewType: rt2, account: acc3, comments: 'Did not pay n time', thumbsUp: false).save(failOnError: true, flush: true)
        Bid b1 = new Bid(amount: 50000.75, bidder:acc1, listing: list1, bidDate: new Date().plus(2)).save(failOnError: true, flush: true)
        Bid b2 = new Bid(amount: 50100.00, bidder:acc5, listing: list1, bidDate: new Date().plus(3)).save(failOnError: true, flush: true)
        Bid b3 = new Bid(amount: 50200.75, bidder:acc3, listing: list1, bidDate: new Date().plus(5)).save(failOnError: true, flush: true)
        Bid b4 = new Bid(amount: 50300.75, bidder:acc4, listing: list1, bidDate: new Date().plus(7)).save(failOnError: true, flush: true)
        Bid b5 = new Bid(amount: 50400.75, bidder:acc5, listing: list1, bidDate: new Date().plus(9)).save(failOnError: true, flush: true)
        Bid b6 = new Bid(amount: 50500.75, bidder:acc1, listing: list1, bidDate: new Date().plus(11)).save(failOnError: true, flush: true)
        Bid b7 = new Bid(amount: 50600.75, bidder:acc5, listing: list1, bidDate: new Date().plus(16)).save(failOnError: true, flush: true)
        Bid b8 = new Bid(amount: 50700.75, bidder:acc3, listing: list1, bidDate: new Date().plus(16)).save(failOnError: true, flush: true)
        Bid b9 = new Bid(amount: 50800.75, bidder:acc4, listing: list1, bidDate: new Date().plus(17)).save(failOnError: true, flush: true)
        Bid b10 = new Bid(amount: 50900.75, bidder:acc6, listing: list1, bidDate: new Date().plus(19)).save(failOnError: true, flush: true)
        Bid b11 = new Bid(amount: 51000.75, bidder:acc3, listing: list1, bidDate: new Date().plus(20)).save(failOnError: true, flush: true)



        println('Accounts: ' + acc8.count().toString())
        println('Addresses: ' + add5.count().toString())
        println('Deliveries: '+del3.count().toString())
        println('Listings: '+list6.count().toString())
    }

}