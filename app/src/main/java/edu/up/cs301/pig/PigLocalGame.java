package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState state;
    /**
     * This actor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if (state.getTurnID() == playerIdx){
            return true;
        }
        else return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigHoldAction){
            int addPoints = state.getPtsToAdd();
                if (state.getTurnID() == 0){
                    state.setPlayer1pts(state.getPlayer1pts() + addPoints);
                }
                else if (state.getTurnID() == 1){
                    state.setPlayer2pts(state.getPlayer2pts() + addPoints);
                }
                state.setPtsToAdd(0);
                state.swapTurns();
            return true;
        }

        else if (action instanceof PigRollAction){
            Random rand = new Random();
            int die = 1 + rand.nextInt(6);
            if ( die != 1 ){
                state.setPtsToAdd(state.getPtsToAdd() + die);
            }
            else {
                state.setPtsToAdd(0);
                state.swapTurns();
            }

            return true;
        }
        //TODO  You will implement this method
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState toSend = new PigGameState(state);
        p.sendInfo(toSend);
        //TODO  You will implement this method
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (state.getPlayer1pts() >= 50){
            return "Player 1 won with " + state.getPlayer1pts() + " points.";
        }
        else if (state.getPlayer2pts() >= 50){
            return "Player 2 won with " + state.getPlayer2pts() + " points.";
        }
        //TODO  You will implement this method
        return null;
    }

}// class PigLocalGame
