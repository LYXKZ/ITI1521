// SecurityAgent.java --- is responsible for a DoorLock and remembers its Combination
// Author          : Marcel Turcotte
// Created On      : Mon Jan 26 14:26:51 2004
// Last Modified By: turcotte
// Last Modified On: Wed Feb  4 13:53:01 2015

import java.util.Random;

public class SecurityAgent {

    // Instance variables.
    // A SecurityAgent is responsible for a particular DoorLock,
    // it must also memorize the secret Combination so that
    // it can re-activate the lock.

    private Combination secret;
    private DoorLock myLock;

    // Constructor.
    public SecurityAgent() {
        Random generator = new Random();
    
        int first = generator.nextInt(5) + 1;
        int second = generator.nextInt(5) + 1;
        int third = generator.nextInt(5) + 1;

        secret = new Combination( first,second,third );
        myLock = new DoorLock( secret );
    }

    // Give access to the dock; returns a reference
    // to the DoorLock object.

    public DoorLock getDoorLock() {
        return myLock;
    }

    // Re-activates the DoorLock.

    public void activateDoorLock() {
        myLock.activate( secret );
    }

}
