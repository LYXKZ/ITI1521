//                              -*- Mode: Java -*- 
// Cashier.java --- models a cashier, collects statistics
// Author          : Marcel Turcotte
// Created On      : Sat Mar  3 07:58:00 2007
// Last Modified By: Marcel Turcotte
// Last Modified On: Sat Mar  3 08:48:48 2007
// ITI 1121/1521. Introduction to Computer Science II

public class Cashier {

    // Constant

    private static final String nl = System.getProperty( "line.separator" );

    // Instance variables

    private Queue<Customer> queue;
    private Customer currentCustomer;

    private int totalCustomerWaitTime;
    private int customersServed;
    private int totalItemsServed;
   
    // constructor

    public Cashier(){

        queue = new ArrayQueue<Customer>();

        totalCustomerWaitTime = 0;
        customersServed = 0;
        totalItemsServed = 0;
    }

    public void addCustomer( Customer c ) {
        queue.enqueue( c );
    }

    public int getQueueSize() {
        return queue.size();
    }

    public void serveCustomers( int currentTime ){

        if ( currentCustomer == null && queue.isEmpty() ) {
            return;
        }

        // Either currentCustomer is not null or the queue is not empty!

        if ( currentCustomer == null ){
            
            currentCustomer = queue.dequeue();

            totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();

            customersServed++;

        }

        // Give a unit of service

        currentCustomer.serve();

        // If current customer is finished, send it away

        if ( currentCustomer.getNumberOfItems() == 0 ) {
            totalItemsServed += currentCustomer.getNumberOfServedItems();
            currentCustomer = null;    
        }
    }

    public int getTotalCustomerWaitTime() {      
        return totalCustomerWaitTime;      
    }    

    public int getTotalItemsServed() {      
        return totalItemsServed;
    }    

    public int getTotalCustomersServed() {
        return customersServed;    
    }

    // private int totalCustomerWaitTime;
    // private int customersServed;
    // private int totalItemsServed;
   
    public String toString() {

        StringBuffer results = new StringBuffer();

        results.append( "The total number of customers served is " );
        results.append( customersServed );
        results.append( nl );

        results.append( "The average number of items per customer was " );
        results.append( totalItemsServed / customersServed );
        results.append( nl );

        results.append( "The average waiting time (in seconds) was " );
        results.append( totalCustomerWaitTime / customersServed );
        results.append( nl );

        return results.toString();
    }

}
