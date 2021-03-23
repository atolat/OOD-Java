package com.ood.vendingmachine;

class GumballMachine implements State {
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
        } else {
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
            count--;
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
