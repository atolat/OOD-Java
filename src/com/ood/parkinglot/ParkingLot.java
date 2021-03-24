package com.ood.parkinglot;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ParkingLot {
    String org;
    int size;
    Map<ParkingSpot, Token> parkingSpotMap;
    Queue<Token> pq = new LinkedList<>();

    public ParkingLot(String org, int size) {
        this.org = org;
        this.size = size;
        parkingSpotMap = new ConcurrentHashMap<>();
        // Generate spots and tokens and add to map
        for(int i = 0; i < size; i++) {
            ParkingSpot spot = new ParkingSpot(null, new Compact());
            Token t = new Token(spot);
            parkingSpotMap.put(spot, t);
            pq.add(t);
        }

    }

    public Token getToken() throws Exception {
        Token t;
        if (pq.size() != 0) {
            t = pq.poll();
            t.issue();
        } else {
            throw new Exception("Parking Full");
        }
        return t;
    }

    public void returnToken(Token t){
        t.checkout();
        pq.add(t);
    }

    public int getCapacity() {
        return size;
    }

    public int getVacantCount() {
        return pq.size();
    }
}
