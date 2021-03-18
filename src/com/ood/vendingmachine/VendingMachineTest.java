package com.ood.vendingmachine;
// Gumball machine to demonstrate state machine pattern
// This pattern provides a way to model state machine transitions
// Every state is a class that implements the transition actions

interface State{
    // Actions
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}

// States
class HasQuarterState implements State{
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

class SoldState implements State{
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

class SoldOutState implements State{
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


class GumballMachine implements State{
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State soldOutState;
    int count;
    State state;

    public GumballMachine(int numberOfGumBalls) {
        // Instance variables for all the states
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        this.count = numberOfGumBalls;

        if (numberOfGumBalls > 0) {
            this.state = noQuarterState;
        } else{
            this.state = soldOutState;
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public void releaseBall() {
        System.out.println("Vending gumball");
        if (count != 0) {
            count --;
        } else {
            this.setState(soldOutState);
        }
    }



    public int getCount() {
        return count;
    }


    @Override
    public void insertQuarter() {
        state.insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    @Override
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    @Override
    public void dispense() {
        state.dispense();
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "count=" + count +
                '}';
    }
}



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
