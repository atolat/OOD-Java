package com.ood.vendingmachine;
// Gumball machine to demonstrate state machine pattern
// This pattern provides a way to model state machine transitions
// Every state is a class that implements the transition actions


public class VendingMachineTest {
    public static void main(String[] args) {
        GumballMachine machine = new GumballMachine(10);
        System.out.println(machine);
        machine.insertQuarter();
        machine.turnCrank();

        System.out.println(machine);

        machine.insertQuarter();
        machine.turnCrank();

        System.out.println(machine);

        machine.insertQuarter();
        machine.turnCrank();

        System.out.println(machine);

    }

}
