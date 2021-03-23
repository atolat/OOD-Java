package com.ood.parkinglot;

public class ParkingSpot {
    public static int idCounter;
    AccessibilityType a11y;
    SizeType size;
    int id;

    public ParkingSpot(AccessibilityType a11y, SizeType size) {
        this.a11y = a11y;
        this.size = size;
        this.id = ++idCounter;
    }

    public AccessibilityType getA11y() {
        return a11y;
    }

    public void setA11y(AccessibilityType a11y) {
        this.a11y = a11y;
    }

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
