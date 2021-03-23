package com.ood.parkinglot;

public class InUse implements State {
    Token token;

    public InUse(Token token) {
        this.token = token;
    }

    @Override
    public void issue() {
        System.out.println("Already in-use, cannot issue...");
    }

    @Override
    public void checkout() {
        System.out.println("Complete payment, moving to available");
        token.setState(token.getAvailableState());
    }
}
