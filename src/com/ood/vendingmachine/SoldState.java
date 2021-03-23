package com.ood.vendingmachine;

class SoldState implements State {
    GumballMachine machine;

    public SoldState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait...already dispensing");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Cannot eject...already dispensing");
    }

    @Override
    public void turnCrank() {
        System.out.println("Please wait...already dispensing");
    }

    @Override
    public void dispense() {
        machine.releaseBall();
        if (machine.getCount() > 0) {
            machine.setState(machine.getNoQuarterState());
        } else {
            machine.setState(machine.getSoldOutState());
        }
    }
}
