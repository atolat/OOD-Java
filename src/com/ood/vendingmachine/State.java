package com.ood.vendingmachine;

interface State {
    // Actions
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
