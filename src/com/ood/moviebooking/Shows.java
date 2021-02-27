package com.ood.moviebooking;

import java.util.Date;

public class Shows {
    private static int idCounter = 0;
    private int id;
    private Date showTime;
    private Movie movie;
    private Theater theater;
    private int availableSeats;

    public Shows(Date showTime, Movie movie, Theater theater) {
        idCounter += 1;
        this.id = idCounter;
        this.showTime = showTime;
        this.movie = movie;
        this.theater = theater;
        this.availableSeats = theater.getCapacity();
        theater.getShows().add(this);
    }

    public synchronized Ticket bookTicket(RegisteredUser user, int seats) {
        if (availableSeats >= seats && seats > 0) {
            Ticket ticket = new Ticket();
            availableSeats -= seats;
            ticket.setOwner(user.getName());
            ticket.setBookedShow(this);
            ticket.setBookingTime(new Date());
            ticket.setNumberOfSeats(seats);
            System.out.println("Successfully booked ticket");
            user.bookingHistory.add(ticket);
            return ticket;
        } else {
            System.out.println("No seats available");
            return null;
        }
    }

    public Date getShowTime() {
        return showTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", showTime=" + showTime +
                ", movie=" + movie.getName() +
                ", theater=" + theater.getName() +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
