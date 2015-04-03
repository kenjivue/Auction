package auction

class AccountService {
    def updateAccount(String username, def params) {
        def user = User.findByUsername(username)
        if (!user) {
            throw new RuntimeException("No user found: $username")
        }
        def account = Account.findByUser(user)
        if (!account) {
            account = new Account(user: user)
        }

        account.email = params.email
        account.address = params.address
        account.name = params.name
        account.dateUpdated = new Date()
        account.save()
        return account
    }
    def serviceMethod() {

    }
}
