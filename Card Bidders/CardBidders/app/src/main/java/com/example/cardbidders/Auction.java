/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Auction Class
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
package com.example.cardbidders;
// This class contains the constructor, getter & setters for Auctions
public class Auction {

    private String card_name;
    private String description;
    private int value;
    private int image;

    public Auction(String card_name, String description, int value, int image) {
        this.card_name = card_name;
        this.description = description;
        this.value = value;
        this.image = image;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() { return value; }

    public void setValue(int value) {
        this.value = value;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
