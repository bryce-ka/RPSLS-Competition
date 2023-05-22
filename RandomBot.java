
/** A Random Rock-Paper-Scissors player.
  * 
  * @author PJ and BA
  */
public class RandomBot implements RoShamBot {
 
    /** Returns an action according to the mixed strategy (1/3, 1/3, 1/3).
      * 
      * @param lastOpponentMove the action that was played by the opponent on
      *        the last round (this is disregarded).
      * @return the next action to play.
      */
    private int rounds;
    private Action prevMove;
    private Action secLastMove;
    
    public RandomBot() {
        this.rounds = 0;
    }
    
    public Action getNextMove(Action lastOpponentMove) {
        rounds++;
        double coinFlip = Math.random();
        if (rounds == 1)
            this.prevMove = lastOpponentMove;
        else
            secLastMove = prevMove;
            prevMove = lastOpponentMove;
        
        if (rounds % 2 == 0)
            return this.secLastMove;
        
        else if (coinFlip <= 1.0/5.0)
            return Action.ROCK;
        else if (coinFlip <= 2.0/5.0)
            return Action.PAPER;
        else if (coinFlip <= 3.0/5.0)
            return Action.SCISSORS;
        else if (coinFlip <= 4.0/5.0)
            return Action.LIZARD;
        else 
            return Action.SPOCK;
    }
    
}