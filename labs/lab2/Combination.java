public class Combination {

    int a;
    int b;
    int c;

    // Constructor
    public Combination( int first, int second, int third ) {
        this.a = first;
        this.b = second;
        this.c = third;
    }

    // An instance method that compares this object
    // to other.
    // Always check that other is not null, i)
    // an error would occur if you tried to
    // access other.first if other was null, ii)
    // null is a valid argument, the method should
    // simply return false.

    public boolean equals( Combination other ) {
        if (other == null) {
            return false;
        } else if (this.a == other.a && this.b == other.b && this.c == other.c) {
            return true;
        }
        return false;
    }

    // Returns a String representation of this Combination.

    public String toString() {
        return this.a + ":" + this.b + ":" + this.c;
    }

}