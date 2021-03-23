package com.ood.vendingmachine;

// States
class HasQuarterState implements State {
    GumballMachine machine;

    public HasQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Returning Quarter");
        machine.setState(machine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank turned...");
        machine.setState(machine.getSoldState());
    }

    @Override
    public void dispense() {
        // Dispense is an invalid action for this state
        System.out.println("No gumball dispensed");
    }
}
