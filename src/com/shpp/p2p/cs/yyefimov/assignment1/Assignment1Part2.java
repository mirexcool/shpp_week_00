package com.shpp.p2p.cs.yyefimov.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {

    public void run() throws Exception {
        //  Do our work while not finished.
        while (!facingWest()) {
            /*
                Method what can build the column
                at start we build a column first.
            */
            buildColumn();
            //  Method to find new column.
            findNewColumn();
        }
    }

    private void findNewColumn() throws Exception {
        turnAround();
        whileCanMove();
        turnAround();
        /*
            The brake for our "while",
            if our Karel looks on West
            we need to stop. During the other methods
            we never look on West.
         */
        ourBreak();
        //  Checking if we need to stop write now.
        if (!facingWest()) {
            turnRight();
            //  Next column in 4 moves.
            for (int i = 0; i < 4; i++) {
                move();
            }
        }
    }

    private void buildColumn() throws Exception {
        //  Turn Karel to the North.
        while (notFacingNorth()) {
            turnLeft();
        }
        //  Building the column.
        while (frontIsClear()){
            if (!beepersPresent())
                putBeeper();
            move();
        }
        //  The last one we need to hold by hands.
        if (!beepersPresent())
            putBeeper();
    }

    private void turnRight() throws Exception {
        turnAround();
        turnLeft();
    }

    private void ourBreak() throws Exception {
        /*
            Before finding new column
            we are checking the sequence.
            If we meet the wall, we need to stop.
        */
        if (rightIsBlocked()){
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
