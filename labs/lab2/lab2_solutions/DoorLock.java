// DoorLock.java --- models a DoorLock ("has a" Combination)
// Author          : Marcel Turcotte
// Created On      : Mon Jan 26 14:26:19 2004
// Last Modified By: Marcel Turcotte
// Last Modified On: Thu Jan 10 10:20:47 2008

public class DoorLock {

    // Constant.
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables.
    private Combination combination;
    private boolean open;
    private boolean activated;
    private int numberOfAttempts;

    // Constructor.
    public DoorLock( Combination combination ) {
        this.combination = combination;
        open = false;
        activated = true;
        numberOfAttempts = 0;
    }

    // Access methods.

    public boolean isOpen() {
        return open;
    }

    public boolean isActivated() {
        return activated;
    }

    // Notice that numberOfAttempts is compared to
    // MAX_NUMBER_OF_ATTEMPTS only when its value has been
    // incremented, Also, numberOfAttempts should be set to zero when
    // activated is false.  Problems related to the combined action of
    // these two variables have caused problems for some students.

    public boolean open( Combination combination ) {
        if (activated) {
            if ( this.combination.equals( combination ) ) {
                open = true;
                numberOfAttempts = 0;
            } else {
                numberOfAttempts++;
                if ( numberOfAttempts >= MAX_NUMBER_OF_ATTEMPTS ) {
                    activated = false;
                    numberOfAttempts = 0;
                }
            }
        }
        return activated && open;
    }

    public void activate( Combination c ) {
        if (combination.equals(c)) {
            activated = true;
        }
    }
}
