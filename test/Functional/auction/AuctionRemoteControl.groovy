package auction

/**
 * Created by Kenji on 4/3/2015.
 */
import grails.util.Holders
import groovyx.remote.client.RemoteControl
import groovyx.remote.transport.http.HttpTransport

class AuctionRemoteControl extends RemoteControl {
    static public final RECEIVER_PATH = "grails-remote-control"
    AuctionRemoteControl() {
        super(new HttpTransport(getFunctionalTestReceiverAddress(), Thread.currentThread().contextClassLoader), Thread.currentThread().contextClassLoader)
    }
    private static String getFunctionalTestReceiverAddress() {
        def base = getFunctionalTestBaseUrl()
        if (!base) {
            throw new IllegalStateException("Cannot get receiver address for functional testing as functional test base URL is not set. Are you calling this from a functional test?")
        }

        base.endsWith("/") ? base + RECEIVER_PATH : base + "/" + RECEIVER_PATH
    }

    static String getFunctionalTestBaseUrl() {
        Holders.config?.grails?.serverURL?.replace('null', '/Auction/') ?: 'http://localhost:8080/Auction/'
    }
}