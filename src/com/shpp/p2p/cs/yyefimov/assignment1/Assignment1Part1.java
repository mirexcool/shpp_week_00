package com.shpp.p2p.cs.yyefimov.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {

    public void run() throws Exception {
        // We need to split our work for 3 methods.
        goToBeeper();
        pickBeeper();
        goToStart();
    }

    private void goToStart() throws Exception {
        // Turn around for 180 degrees.
        turnAround();
        // Go forward until wall.
        whileCanMove();
        // Method what allows us to turn right.
        turnRight();
        move();
        turnRight();
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    private void goToBeeper() throws Exception {
        // Finding beeper.
        whileCanMove();
        turnRight();
        move();
        turnLeft();
        move();
        move();
    }

    private void whileCanMove() throws Exception {
        // Go forward until wall.
        while(frontIsClear())
            move();
    }

    private void turnRight() throws Exception {
        turnAround();
        turnLeft();
    }


}
