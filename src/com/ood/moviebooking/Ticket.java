package com.ood.moviebooking;

import java.util.Date;

public class Ticket {
    private static int idCounter = 0;
    private int id;
    private String owner;
    private Date bookingTime;
    private int numberOfSeats;
    private Shows bookedShow;

    public Ticket() {
        idCounter += 1;
        this.id = idCounter;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Shows getBookedShow() {
        return bookedShow;
    }

    public void setBookedShow(Shows bookedShow) {
        this.bookedShow = bookedShow;
    }
}
