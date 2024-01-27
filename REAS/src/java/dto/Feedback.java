
package dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class Feedback {
    private String feedbackID;
    private String accID;
    private String auctionID;
    private LocalDateTime feedbackDate;
    private int star;
    private String detail;

    public Feedback() {
    }

    public Feedback(String feedbackID, String accID, String auctionID, LocalDateTime feedbackDate, int star, String detail) {
        this.feedbackID = feedbackID;
        this.accID = accID;
        this.auctionID = auctionID;
        this.feedbackDate = feedbackDate;
        this.star = star;
        this.detail = detail;
    }

    public String getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public LocalDateTime getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(LocalDateTime feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Feedback{" + "feedbackID=" + feedbackID + ", accID=" + accID + ", auctionID=" + auctionID + ", feedbackDate=" + feedbackDate + ", star=" + star + ", detail=" + detail + '}';
    }
}
