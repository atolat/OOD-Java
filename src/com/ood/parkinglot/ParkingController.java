package com.ood.parkinglot;

public class ParkingController {
    ParkingLot parkingLot;

    public ParkingController(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Token getToken() {
        // Return an available token based on some policy
        Token token = null;
        try {
            token = parkingLot.getToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public void checkout(Token t){
        // Complete payment
        // Call payment service with token
        // Return token to queue
        parkingLot.returnToken(t);
    }





    public static void main(String[] args) {
        // Create a parking lot
        ParkingLot parkingLot = new ParkingLot("ABC",5);

        // Create a parking controller
        ParkingController pc = new ParkingController(parkingLot);

        Token t1 = pc.getToken();
        pc.checkout(t1);
    }
}
