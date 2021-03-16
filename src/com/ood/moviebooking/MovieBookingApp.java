package com.ood.moviebooking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MovieBookingApp {
    ArrayList<Theater> theaters;
    static Map<String, ArrayList<Shows>> movieMap;
    private void generateMovieMap(){
        for (Theater theater: theaters) {
            ArrayList<Shows> showArray = theater.getShows();
            for (Shows show : showArray) {
                if (show != null) {
                    if (movieMap.containsKey(show.getMovie().getName())) {
                        movieMap.get(show.getMovie().getName()).add(show);
                    } else {
                        ArrayList<Shows> movieShowList = new ArrayList<>();
                        movieShowList.add(show);
                        movieMap.put(show.getMovie().getName(), movieShowList);
                    }
                }
            }
        }
    }

    public MovieBookingApp(ArrayList<Theater> theaters) {
        this.theaters = theaters;
        this.movieMap = new HashMap<>();
        generateMovieMap();
        System.out.println(movieMap);
    }

    public ArrayList<Shows> searchShows(String movieName){
        if (movieMap.containsKey(movieName)) {
            return movieMap.get(movieName);
        } else{
            return null;
        }
    }
    public static void main(String[] args) {
        /* --------Data generation code ----START ----------------- */

        // Creating Guest User
        GuestUser guest = new GuestUser("Guest");

        // Creating Registered User
        RegisteredUser reg_a = new RegisteredUser("User A");

        // Creating Registered User --> Saurabh
        RegisteredUser reg_b = new RegisteredUser("User B");

        // Creating Movie object --> Iron Man
        Movie ironMan = new Movie("Iron Man", Language.ENGLISH,Genre.ACTION);

        // Creating Movie object --> Avengers: End Game
        Movie avengers = new Movie("Avengers: End Game", Language.ENGLISH,Genre.ACTION);

        // Creating Movie object --> The Walk To Remember
        Movie walkToRemember = new Movie("The Walk To Remember", Language.ENGLISH,Genre.ROMANCE);

        // Creating Movie object --> HouseFull2
        Movie housefull = new Movie("HouseFull 2", Language.HINDI,Genre.COMEDY);

        // Creating Theater
        Theater theater_1 = new Theater("ABC","San Jose",30);

        // Creating Another Theater
        Theater theater_2 = new Theater("XYZ","Fremont",40);




        // Creating four shows for movies
        Shows show1=null, show2=null, show3=null, show4=null;
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");

        try {
            // Creating Show for Movie Iron Man on 7 Jun 2020 @ 9:00 AM
            String dateInString = "Friday, Jun 7, 2020 09:00:00 AM";
            Date date = formatter.parse(dateInString);
            show1 = new Shows(date,ironMan,theater_1);

            // Creating Show for Movie HOUSEFULL on 7 Jun 2020 @ 12:00 PM
            dateInString = "Friday, Jun 7, 2020 12:00:00 PM";
            date = formatter.parse(dateInString);
            show2 = new Shows(date,housefull,theater_1);

            // Creating Show for Movie WALK TO REMEMBER on 7 Jun 2020 @ 09:00 AM
            dateInString = "Friday, Jun 7, 2020 09:00:00 AM";
            date = formatter.parse(dateInString);
            show3 = new Shows(date,walkToRemember,theater_2);

            // Creating Show for Movie WALK TO REMEMBER on 7 Jun 2020 @ 12:00 PM
            dateInString = "Friday, Jun 7, 2020 12:00:00 PM";
            date = formatter.parse(dateInString);
            show4 = new Shows(date,walkToRemember,theater_2);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        /* --------Data generation code ---- END ----------------- */

        // Now We have two theaters with their shows, lets add these theaters to our Book My Show app
        ArrayList<Theater> theaterArrayList= new ArrayList<>();
        theaterArrayList.add(theater_1);
        theaterArrayList.add(theater_2);
        MovieBookingApp bookMyShow = new MovieBookingApp(theaterArrayList);

        // Searching Book My Show for all the shows of movie WALK TO REMEMBER
        ArrayList<Shows> searchedShow = bookMyShow.searchShows("The Walk To Remember");
        // Above code returns two shows of WALK TO REMEMBER
        /*
        searchedShow --> [Show{id=3, showTime=Sun Jun 07 09:00:00 IST 2020,
        movie=The Walk To Remember, theater=Big Cinema, availableSeats=40},
        Show{id=4, showTime=Sun Jun 07 12:00:00 IST 2020, movie=The Walk To Remember,
        theater=Big Cinema, availableSeats=40}]
        */

        Shows bookingShow = searchedShow.get(0);

        // Ticket Booking Thread for the request made by AYUSH for 10 Seats
        TicketBookingThread t1 = new TicketBookingThread(bookingShow,reg_a,10);

        // Ticket Booking Thread for the request made by SAURABH for 10 Seats
        TicketBookingThread t2 = new TicketBookingThread(bookingShow,reg_b,10);

        // Start both the Ticket Booking Threads for execution
        t1.start();
        t2.start();

        // Waiting till both the thread completes the execution
        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Ticket ticket1 = t1.getTicket();
        Ticket ticket2 = t2.getTicket();

        System.out.println(ticket1);
        System.out.println(ticket2);

        // Now, 20 seats are booked for this show and 20 seats are available,

        TicketBookingThread t3 = new TicketBookingThread(bookingShow,reg_a,15);
        TicketBookingThread t4 = new TicketBookingThread(bookingShow,reg_b,10);

        // Start both the Ticket Booking Threads for execution
        t3.start();
        t4.start();

        // Waiting till both the thread completes the execution
        try {

            t4.join();
            t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Ticket ticket3 = t3.getTicket();
        Ticket ticket4 = t4.getTicket();

        System.out.println(ticket3);
        System.out.println(ticket4);

        /* Running this program several times, we will notice that
        if t3 enters the bookTicket function first,
        then ticket is allocated to Ayush,
        otherwise ticket is allocated to Saurabh.
         */

    }
}
