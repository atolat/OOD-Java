package com.ood.parkinglot;

public abstract class VehicleType {
    public static int idCounter;
    int lic_number;
    int id;
    public VehicleType(int lic_number) {
        this.id = idCounter++;
        this.lic_number = lic_number;
    }
}
