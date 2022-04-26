/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Bidding Model Class
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
package com.example.cardbidders;
// This class sets up a table for bids placed by users on auctions as wel las constructors and getters
// & setters and toString method
public class BiddingModel {

    private int id;
    private String card;
    private String person;
    private String email;
    private int amount;
    // Constructor with all items of the table
    public BiddingModel(int id, String card, String person, String email, int amount) {
        this.id = id;
        this.card = card;
        this.person = person;
        this.email = email;
        this.amount = amount;
    }
    // Empty Constructor
    public BiddingModel() {
    }
    // Constructor without ID
    public BiddingModel(String card, String person, String email, int amount) {
        this.card = card;
        this.person = person;
        this.email = email;
        this.amount = amount;
    }
    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    /**
     * this method creates a String from
     * database items to de displayed
     * @return String
     */
    @Override
    public String toString() {
        return "Bid:" +
                "id=" + id +
                ", card='" + card + '\'' +
                ", person='" + person + '\'' +
                ", email='" + email + '\'' +
                ", amount=" + amount;
    }
}
