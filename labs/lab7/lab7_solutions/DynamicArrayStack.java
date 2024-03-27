import java.util.EmptyStackException;

/**
 * ITI 1121. Introduction à l'informatique II
 * ITI 1521. Introduction to Computer Science II
 *
 * @author Marcel Turcotte, Université d'Ottawa/University of Ottawa
 */

public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor

    public DynamicArrayStack( int capacity ) {
        if (capacity < DEFAULT_INC) {capacity = DEFAULT_INC;}
        elems = (E[]) new Object[ capacity ];
        top = 0;
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty

    public boolean isEmpty() {

        // Same as:
        // if ( top == 0 ) {
        //     return true;
        // } else {
        //     return false;
        // }

        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it

    public E peek() throws EmptyStackException{

        // pre-conditions: ! isEmpty()
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack

    public E pop() {
        // pre-conditions: ! isEmpty()
        if(isEmpty()){
            throw new EmptyStackException();
        }
        // *first* decrements top, then access the value!
        E saved = elems[ --top ];

        elems[ top ] = null; // scrub the memory!

        // When your array is full, a new array with DEFAULT_INC
        // plus elements will be created and filled with the elements
        // of the previous array.
        if (elems.length - (top+1) == DEFAULT_INC) {
            E[] temp = (E[]) new Object[ elems.length - DEFAULT_INC ];
            for ( int i=0; i<top; i++ ) {
                temp[ i ] = elems[i];
            }
            elems=temp;
        }
        return saved;
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.

    public void push( E element ) {

        // When an array has DEFAULT_INC elements less than its size,
        // the array must automatically be shrunk.
        if (top == elems.length) {
            E[] temp = (E[]) new Object[ top + DEFAULT_INC ];
            for ( int i=0; i<top; i++ ) {
                temp[ i ] = elems[i];
            }
            elems=temp;
        }

        // *first* stores the element at position top, then increments top
        elems[ top++ ] = element;
    }
    
    @SuppressWarnings( "unchecked" )

    public void clear() {

        elems = (E[]) new Object[DEFAULT_INC]; // New array with min size DEFAULT_INC

        top = 0;

    }

}
