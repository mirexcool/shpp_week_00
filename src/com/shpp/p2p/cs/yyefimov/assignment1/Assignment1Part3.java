package com.shpp.p2p.cs.yyefimov.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {

    public void run() throws Exception {
        // Checking edge cases.
        checkSize();
        /*
            If size 1x1 or 2x2 Karel will look at South
            and stops.
         */
        if (!facingSouth()) {
            //  Fill the row for our algorithm.
            fillTheRow();
            /*
                After we find the center we will turn Karel
                on South.
             */
            while (facingWest() || facingEast()) {
                /*
                    Removing beepers without last
                    central one. We're removing beepers
                    one by one on each side. We have two
                    methods what turn Karel correctly on each side.
                */
                removeBeeperFromOneSide();
                removeBeeperFromAnotherSide();
            }
        }
    }

    private void checkSize() throws Exception {
        //  Check for 1x1 size.
        if (frontIsBlocked()) {
            putBeeper();
            lookAtSouth();
        /*
            Check for 2x2 size.
            All another go through.
         */
        } else if (frontIsClear()) {
            move();
            /*
                In case 2x2 our center will be in
                first square or in second one.
             */
            if (frontIsBlocked()) {
                putBeeper();
                lookAtSouth();
            } else {
                //  If size not 2x2, we return to start
                takePreviousPosition();
            }
        }
    }

    private void fillTheRow() throws Exception {
        //  Filling the Row. Skip first and last one.
        while (frontIsClear()) {
            move();
            if (!beepersPresent())
                putBeeper();
        }
        pickBeeper();
    }

    private void removeBeeperFromAnotherSide() throws Exception {
        // Go forward while beepers are present.
        findLastBeeper();
        turnAround();
    }

    private void removeBeeperFromOneSide() throws Exception {
        turnAround();
        findLastBeeper();
    }

    private void findLastBeeper() throws Exception {
        if (frontIsClear()) {
            move();
            while (beepersPresent()) {
                move();
            }
            goBackwards();
            // Checking if we already find the center.
            checkIfCenter();
            // If not center than remove last beeper.
            if (notFacingSouth())
                pickBeeper();
        }
    }

    private void checkIfCenter() throws Exception {
        move();
        /*
            If last beeper in the world it should be
            in center and there is no more beepers
            on West and East and Karel turn to South.
            Else we return Karel on previous position.
         */
        if (!beepersPresent()) {
            goBackwards();
            move();
            if (!beepersPresent()) {
                goBackwards();
                lookAtSouth();
            }
        }
        else {
            takePreviousPosition();
        }
    }

    private void lookAtSouth() throws Exception {
        while (notFacingSouth()) {
            turnLeft();
        }
    }

    private void goBackwards() throws Exception {
        turnAround();
        move();
    }

    private void takePreviousPosition() throws Exception {
        // Same like goBackwards() but save looking side of Karel.
        turnAround();
        move();
        turnAround();
    }
    
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

}
