package com.shpp.p2p.cs.yyefimov.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3_2 extends KarelTheRobot {

    public void run() throws Exception {
        while (frontIsClear())
            findTheEnd();
        moveBeepersAtTheEnd();
        goToStart();
        turnLeft();
        move();
        turnRight();
        while (frontIsClear())
            findTheEnd();
        moveBeepersAtTheEnd();
        turnAround();

        findCenter();
        lookAtSouth();
        move();

        while (beepersPresent())
            pickBeeper();
        putBeeper();
    }

    private void lookAtSouth() throws Exception {
        while (notFacingSouth()) {
            turnLeft();
        }
    }

    private void findCenter() throws Exception {
        while (beepersPresent() && notFacingEast()) {
            if (beepersPresent())
                pickBeeper();
            else
                lookAtEast();
            if (beepersPresent())
                pickBeeper();
            else
                lookAtEast();
            if (notFacingEast()) {
                turnLeft();
                move();
            }
            if (notFacingEast()) {
                if (beepersPresent())
                    pickBeeper();
                turnRight();

                moveBeepersToCenter();

                turnRight();
                move();
                turnLeft();
            }
        }
    }

    private void moveBeepersToCenter() throws Exception {
        while (beepersPresent()){
            pickBeeper();
            move();
            putBeeper();
            turnAround();
            move();
            turnAround();
        }
        turnRight();
        move();
        turnLeft();
        while (beepersPresent()){
            pickBeeper();
            move();
            putBeeper();
            turnAround();
            move();
            turnAround();
        }
        move();
        turnLeft();
        move();
        turnRight();
    }

    private void turnRight() throws Exception {
        turnLeft();
        turnAround();
    }

    private void goToStart() throws Exception {
        turnAround();
        whileCanMove();
        turnAround();
    }

    private void moveBeepersAtTheEnd() throws Exception {
        turnAround();
        move();
        turnAround();
        while (beepersPresent())
        {
            pickBeeper();
            move();
            putBeeper();
            turnAround();
            move();
            turnAround();
        }
        move();
        putBeeper();
    }

    private void findTheEnd() throws Exception {
        turnAround();
        if (frontIsBlocked()) {
            putBeeper();
            turnAround();
            move();
        }
        else{
            lookAtEast();
            while (frontIsClear()){
                putBeeper();
                move();
                //pause();
                moveBeepers();
            }
        }
    }

    private void moveBeepers() throws Exception {
        turnAround();
        move();
        move();
        turnAround();
        while (beepersPresent())
        {
            pickBeeper();
            move();
            putBeeper();
            turnAround();
            move();
            turnAround();
        }
        move();
        move();
    }

    private void lookAtEast() throws Exception {
        while (notFacingEast()) {
            turnLeft();
        }
    }

    private void lookAtNorth() throws Exception {
        while (notFacingNorth()) {
            turnLeft();
        }
    }

    private void lookAtWest() throws Exception {
        while (notFacingWest()) {
            turnLeft();
        }
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    private void whileCanMove() throws Exception{
        while(frontIsClear()) {
            move();
        }
    }

}
