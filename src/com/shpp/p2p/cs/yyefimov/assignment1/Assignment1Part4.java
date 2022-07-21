package com.shpp.p2p.cs.yyefimov.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {

    public void run() throws Exception {
        // Filling first column.
        buildFirstColumn();
        /*
            Check if we need to stop while.
            We stop when we look on North
            and the right side is blocked.
         */
        ourBreak();
        while (!facingWest()) {
            // Find next column to fill.
            findNewColumn();
            // Fill the column like chess.
            buildColumn();
            // Check if we need to stop while.
            ourBreak();
        }
    }

    private void buildFirstColumn() throws Exception {
        /*
            This method holds edge cases if
            world is 1*N or N*1
         */
        if (leftIsBlocked()) {
            putBeeperLikeChess();
            lookAtNorth();
        }
        else {
            lookAtNorth();
            /*  Method putting the beepers
                like chess.
             */
            putBeeperLikeChess();
        }
    }

    private void findNewColumn() throws Exception {
        /*
            When column was filled we go back
            and go to the next column.
         */
        turnAround();
        whileCanMove();
        turnLeft();
        move();
    }

    private void ourBreak() throws Exception {
        if (rightIsBlocked()){
            turnLeft();
        }
    }

    private void buildColumn() throws Exception {
        /*
            Check the column for odd or even.
            If at the border from left beeper is present
            we skipp first square or start from first one.
         */
        lookAtWest();
        move();
        if (beepersPresent()) {
            stepBackAndLookAtNorth();
            move();
            putBeeperLikeChess();
        }else{
                stepBackAndLookAtNorth();
                putBeeperLikeChess();
        }
    }

    private void stepBackAndLookAtNorth() throws Exception {
        turnAround();
        move();
        lookAtNorth();
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

    private void putBeeperLikeChess() throws Exception {
        if (frontIsBlocked()){
            putBeeper();
        }
        /*
            While front is clear we are putting
            beepers like we need(chess).
        */
        while (frontIsClear()){
            putBeeper();
            move();
            if (frontIsClear()){
                move();
                if (frontIsBlocked()){
                    putBeeper();
                }
            }
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
