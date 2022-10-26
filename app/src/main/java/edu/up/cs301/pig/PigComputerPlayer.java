package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    private Random rand = new Random();
    private int ID;
    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name, int _ID) {
        super(name);
        ID = _ID;
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState state = new PigGameState((PigGameState)info);
        if (ID != state.getTurnID()){
            return;
        }

        int chance = rand.nextInt(2);

        GameAction action;

        if (chance == 0){
            action = new PigRollAction(this);
        }
        else {
            action = new PigHoldAction(this);
        }

        game.sendAction(action);

        // TODO  You will implement this method
    }//receiveInfo

}
