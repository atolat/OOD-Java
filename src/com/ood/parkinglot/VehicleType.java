package com.ood.parkinglot;

public abstract class VehicleType {
    public static int idCounter;
    int id;
    public VehicleType() {
        this.id = idCounter++;
    }
}
