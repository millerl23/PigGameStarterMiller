package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameInfo;

public class PigGameState extends GameInfo {

    private int turnID;
    private int player1pts;
    private int player2pts;
    private int ptsToAdd;
    private int dieVal;

    public PigGameState(){
        turnID = 0;
        player1pts = 0;
        player2pts = 0;
        ptsToAdd = 0;
        dieVal = 0;

    }

    public PigGameState(PigGameState state){
        turnID = state.turnID;
        player1pts = state.player1pts;
        player2pts = state.player2pts;
        ptsToAdd = state.ptsToAdd;
        dieVal = state.dieVal;
    }

    public void swapTurns(){
        if (turnID == 0){
            turnID = 1;
        }
        else if (turnID ==1){
            turnID = 0;
        }
    }

    // Setters
    public void setTurnID(int ID){
        turnID = ID;
    }
    public void setPlayer1pts(int pts){
        player1pts = pts;
    }
    public void setPlayer2pts(int pts){
        player2pts = pts;
    }
    public void setPtsToAdd(int pts){
        ptsToAdd = pts;
    }
    public void setDieVal(int val){
        dieVal = val;
    }

    // Getters
    public int getTurnID(){
        return turnID;
    }
    public int getPlayer1pts(){
        return player1pts;
    }
    public int getPlayer2pts(){
        return player2pts;
    }
    public int getPtsToAdd(){
        return ptsToAdd;
    }
    public int getDieVal(){
        return dieVal;
    }

}
