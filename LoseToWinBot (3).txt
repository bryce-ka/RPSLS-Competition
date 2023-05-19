
 

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class LoseToWinBot implements RoShamBot {
 
    /** Returns an action according to the mixed strategy (0.5, 0.5, 0, 0, 0).
      * 
      * @param lastOpponentMove the action that was played by the opponent on
      *        the last round (this is disregarded).
      * @return the next action to play.
      */
    //save opponents move from last played round 
    private Action prevMoveThem; 
    //save my last move
    private Action prevMoveMe;
    // creates a dict to determine game outcomes 
    Map<Action, List<Action>> losesTo = new HashMap<Action, List<Action>>();
    
    public LoseToWinBot(){
        this.prevMoveThem = Action.ROCK;
        this.prevMoveMe = Action.ROCK;
        
        //add outcomes to dict (game rules)
        this.losesTo.put(Action.ROCK, Arrays.asList(Action.PAPER, Action.SPOCK));
        this.losesTo.put(Action.PAPER, Arrays.asList(Action.SCISSORS, Action.LIZARD));
        this.losesTo.put(Action.SCISSORS, Arrays.asList(Action.ROCK, Action.SPOCK));
        this.losesTo.put(Action.LIZARD, Arrays.asList(Action.SCISSORS, Action.ROCK));
        this.losesTo.put(Action.SPOCK, Arrays.asList(Action.PAPER, Action.LIZARD));  
    }
        
        
    public Action getNextMove(Action lastOpponentMove) {
        List<Action> goodOptions = losesTo.get(prevMoveThem);
        
        if(goodOptions.get(0) == prevMoveMe || goodOptions.get(1) == prevMoveMe){
            this.prevMoveThem = lastOpponentMove;
            return prevMoveMe; 
            }
        else{
            this.prevMoveThem = lastOpponentMove;
            double coinFlip = Math.random();
            if(lastOpponentMove == Action.ROCK){
                if (coinFlip <= 1.0/2.0){
                    this.prevMoveMe = Action.LIZARD;
                    return Action.LIZARD;
                }
                else{
                    this.prevMoveMe = Action.SCISSORS;
                    return Action.SCISSORS;
                }
            }
            else if(lastOpponentMove == Action.PAPER){
                if (coinFlip <= 1.0/2.0){
                    this.prevMoveMe = Action.ROCK;
                    return Action.ROCK;
                }
                else{
                    this.prevMoveMe = Action.SPOCK;
                    return Action.SPOCK;
                }
            }
            else if(lastOpponentMove == Action.SCISSORS){
                if (coinFlip <= 1.0/2.0){
                    this.prevMoveMe = Action.LIZARD;
                    return Action.LIZARD;
                }
                else{
                    this.prevMoveMe = Action.PAPER;
                    return Action.PAPER;
                }   
            }
            else if(lastOpponentMove == Action.LIZARD){
                if (coinFlip <= 1.0/2.0){
                    this.prevMoveMe = Action.SPOCK;
                    return Action.SPOCK;
                }
                else{
                    this.prevMoveMe = Action.PAPER;
                    return Action.PAPER;
                }
            }
            else if(lastOpponentMove == Action.SPOCK){
                if (coinFlip <= 1.0/2.0){
                    this.prevMoveMe = Action.ROCK;
                    return Action.ROCK;
                }
                else{
                    this.prevMoveMe = Action.SCISSORS;
                    return Action.SCISSORS;
                }
            }

            return null;
        }
    
}
}