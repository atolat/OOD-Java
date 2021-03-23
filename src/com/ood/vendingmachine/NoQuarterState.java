package com.ood.vendingmachine;

class NoQuarterState implements State {
    GumballMachine machine;

    public NoQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Inserted Quarter - Turn crank");
        machine.setState(machine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Nothing inserted, cannot eject");
    }

    @Override
    public void turnCrank() {
        System.out.println("Insert quarter first!");
    }

    @Override
    public void dispense() {
        System.out.println("Insert quarter first!");
    }

}
