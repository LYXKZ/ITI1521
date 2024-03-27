//                              -*- Mode: Java -*- 
// Customer.java --- models a customer, determines the initial number of items
// Author          : Marcel Turcotte
// Created On      : Sat Mar  3 07:58:50 2007
// Last Modified By: Marcel Turcotte
// Last Modified On: Sat Mar  3 07:59:08 2007
// ITI 1121/1521. Introduction to Computer Science II

public class Customer {

    // Constant

    private static final int MAX_NUM_ITEMS = 25;

    // Instance variables

    private int arrivalTime;
    private int numberOfItems;
    private int initialNumberOfItems;

    // Constructor

    public Customer( int arrivalTime ) {
        this.arrivalTime = arrivalTime;
        numberOfItems =  (int) ( ( MAX_NUM_ITEMS - 1 ) * Math.random() ) + 1;
        initialNumberOfItems = numberOfItems;
    }

    // Access methods

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getNumberOfServedItems() {
       return initialNumberOfItems - numberOfItems;
    }

    public void serve() {
        numberOfItems--;
    }
}
