
package dto;

public class AuctionWinningHistory {
    private String auctionWinID;
    private String auctionHisID;
    private String accID;
    private long finalPrice; 

    public AuctionWinningHistory() {
    }

    public AuctionWinningHistory(String auctionWinID, String auctionHisID, String accID, long finalPrice) {
        this.auctionWinID = auctionWinID;
        this.auctionHisID = auctionHisID;
        this.accID = accID;
        this.finalPrice = finalPrice;
    }

    public String getAuctionWinID() {
        return auctionWinID;
    }

    public void setAuctionWinID(String auctionWinID) {
        this.auctionWinID = auctionWinID;
    }

    public String getAuctionHisID() {
        return auctionHisID;
    }

    public void setAuctionHisID(String auctionHisID) {
        this.auctionHisID = auctionHisID;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public long getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(long finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "AuctionWinningHistory{" + "auctionWinID=" + auctionWinID + ", auctionHisID=" + auctionHisID + ", accID=" + accID + ", finalPrice=" + finalPrice + '}';
    }
}
