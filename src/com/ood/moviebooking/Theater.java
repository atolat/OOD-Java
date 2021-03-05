package com.ood.moviebooking;

import java.util.ArrayList;

public class Theater {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String location;
    private int capacity;
    private ArrayList<Shows> shows;

    public Theater(String name, String location, int capacity) {
        idCounter += 1;
        this.id = idCounter;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.shows = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Shows> getShows() {
        return shows;
    }
}
