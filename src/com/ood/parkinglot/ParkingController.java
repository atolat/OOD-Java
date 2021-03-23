package com.ood.parkinglot;

public class ParkingController {
    ParkingLot parkingLot;

    public ParkingController(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Token getToken() {
        // Return an available token based on some policy
        // Update token state to in-use
        return null;
    }

    public void checkout(){
        // Complete payment
        // Update token state to available

    }





    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("ABC",50);
    }
}
