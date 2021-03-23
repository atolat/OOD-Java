package com.ood.parkinglot;

public class Available implements State{
    Token token;

    public Available(Token token) {
        this.token = token;
    }

    @Override
    public void issue() {
        System.out.println("Issuing Token...");
        token.setState(token.getInUseState());
    }

    @Override
    public void checkout() {
        System.out.println("Cannot checkout, not issued...");
    }

}
