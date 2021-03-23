package com.ood.vendingmachine;

class SoldOutState implements State {
    GumballMachine machine;

    public SoldOutState(GumballMachine machine) {
        this.machine = machine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("Sold Out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sold Out");
    }

    @Override
    public void turnCrank() {
        System.out.println("Sold Out");
    }

    @Override
    public void dispense() {
        System.out.println("Sold Out");
    }
}
