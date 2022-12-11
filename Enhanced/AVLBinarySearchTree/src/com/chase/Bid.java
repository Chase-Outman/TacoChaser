//============================================================================
// Name        : Bid.java
// Author      : Chase Outman
// Version     : 1.0
// Description : Bid class that creates a bid object with the following atributes
//               Bid Id, Title, Fund, and Amount
//============================================================================
package com.chase;

//This the Bid object class that stores the bid id, title, fund, and final bid amount for each bid object
public class Bid {
    private String bidId;
    private String title;
    private String fund;
    private String amount;

    //setter for bid id
    public void setBidId(String bidId) {
        this.bidId = bidId;
    }
    //setter for title
    public void setTitle(String title) {
        this.title = title;
    }
    //setter for fund
    public void setFund(String fund) {
        this.fund = fund;
    }
    //setter for amount
    public void setAmount(String amount) {
        this.amount = amount;
    }
    //getter for bid id
    public String getBidId() {
        return bidId;
    }
    //getter for title
    public String getTitle() {
        return title;
    }
    //getter for fund
    public String getFund() {
        return fund;
    }
    //getter for amount
    public String getAmount() {
        return amount;
    }
}
