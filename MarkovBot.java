import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.lang.*;

/** Markov Chain Implementation of RPSLS
  *  
  * 
  * @author PJ and BA
  */
public class MarkovBot implements RoShamBot{
    private int rounds;
    private Action secLastMove;
    private int[][] markovChain;
    // int[secLastMove][lastOpponentMove]
    public static final Random RANDOM = new Random();
    
    // create map to store loses to arrays
    Map<Action, List<Action>> losesTo = new HashMap<Action, List<Action>>();
    
    
    public void init() {
        // init markov chain
        this.secLastMove = Action.SCISSORS;
        int length = Action.values().length;
        this.markovChain = new int[length][length];

        for (int i = 0; i < length; i++) {
          for (int j = 0; j < length; j++) {
            this.markovChain[i][j] = 0;
          }
        }
        // init losesTo
        this.losesTo.put(Action.ROCK, Arrays.asList(Action.PAPER, Action.SPOCK));
        this.losesTo.put(Action.PAPER, Arrays.asList(Action.SCISSORS, Action.LIZARD));
        this.losesTo.put(Action.SCISSORS, Arrays.asList(Action.ROCK, Action.SPOCK));
        this.losesTo.put(Action.LIZARD, Arrays.asList(Action.SCISSORS, Action.ROCK));
        this.losesTo.put(Action.SPOCK, Arrays.asList(Action.PAPER, Action.LIZARD));
    }
    
    public MarkovBot() {
        this.rounds = 0;
        // init markov chain and losesTo
        init();
    }
    /** Returns the next action that this bot will take. */
    public Action getNextMove(Action lastOpponentMove){
        this.rounds = this.rounds + 1;

        //if first round, pick random move
        if (rounds < 1) {
            init();
            return Action.values()[RANDOM.nextInt(Action.values().length)];
        }
        // add to matrix based on last move
        int prevIndex = lastOpponentMove.ordinal();
        int secLastIndex = secLastMove.ordinal();
        markovChain[secLastIndex][prevIndex]++;

        int nextIndex = 0;
        for (int i = 0; i < Action.values().length; i++) {
            if (markovChain[prevIndex][i] > markovChain[prevIndex][nextIndex]) {
                nextIndex = i;
            }
        }
        // Item probably played by the user is in nextIndex
        Action predictedNext = Action.values()[nextIndex];
        // System.out.println("NEXT PREDICTED MOVE");
        // System.out.println(nextIndex);

        // we choose amongst item for which this probably item loses
        List<Action> options = losesTo.get(predictedNext);
        secLastMove = lastOpponentMove;
        return options.get(RANDOM.nextInt(options.size()));
        }
        
    }