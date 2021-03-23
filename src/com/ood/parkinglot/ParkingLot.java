package com.ood.parkinglot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ParkingLot {
    String org;
    int size;
    Map<ParkingSpot, Token> parkingSpotMap;

    public ParkingLot(String org, int size) {
        this.org = org;
        this.size = size;
        parkingSpotMap = new ConcurrentHashMap<>();
        int randomNum;
        // Generate spots and tokens and add to map
        for(int i = 0; i < size; i++) {
            randomNum = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
            ParkingSpot spot = new ParkingSpot(null, new Compact(randomNum));
            Token t = new Token(spot);
            parkingSpotMap.put(spot, t);
        }

    }
}
