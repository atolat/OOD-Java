package com.ood.parkinglot;

import java.util.Date;

public class Token {
    State inUseState;
    State availableState;
    Date entryTime;
    ParkingSpot spot;
    State state;

    public Token(ParkingSpot spot) {
        this.inUseState = new InUse(this);
        this.availableState = new Available(this);
        this.spot = spot;
    }

    public State getAvailableState() {
        return this.availableState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getInUseState() {
        return this.inUseState;
    }
}
