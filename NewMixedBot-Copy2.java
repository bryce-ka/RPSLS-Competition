import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.lang.*;
/** Uses 4 strategies, estimates which will work the best
  * 
  * 
  * @author BA
  */
public class NewMixedBot implements RoShamBot{
    // mixed init
    private int rounds; 
    private double[] rankings;
    private Action[] prevPred;
    private Action prevMove;
     //save opponents move from last played round 
    private Action prevMoveThem; 
    //save my last move
    private Action prevMoveMe;
    //private Action secLastMove;
    public static final Random RANDOM = new Random();
    // markov init
    //private Action markLastMove;
    private int[][] markovChain;
    Map<Action, List<Action>> losesTo = new HashMap<Action, List<Action>>();
    // random init
    private Action secLastMove;

    
    public NewMixedBot(){
        this.rounds = 0;
        this.rankings = new double[4];
        this.prevPred = new Action[4];
        this.prevMove = Action.ROCK;
        this.secLastMove = Action.ROCK;
        //initalize each element
        for (int i = 0; i <=3; i++){
            this.rankings[i] = 0;
            this.prevPred[i] = Action.ROCK;
        } 
        
        //markov
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
    
    public void resetRankings(){
        for (int i = 0; i <=3; i++){
            this.rankings[i] = 0;
        }
    }
    
    public Action RunNashBot(Action lastOpponentMove){
        double coinFlip = Math.random();
        if (coinFlip <= 1.0/5.0)
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
    
    public Action RunMarkovBot(Action lastOpponentMove){
        int nextIndex = 0;
        int prevIndex = lastOpponentMove.ordinal();

          for (int i = 0; i < Action.values().length; i++) {
              if (markovChain[prevIndex][i] > markovChain[prevIndex][nextIndex]) {
              nextIndex = i;
            }
          }

          // Item probably played by the user is in nextIndex
          Action predictedNext = Action.values()[nextIndex];

          // we choose amongst item for which this probably item loses
          List<Action> options = losesTo.get(predictedNext);
          return options.get(RANDOM.nextInt(options.size()));
    }
    
    public Action PredMarkovBot(Action lastOpponentMove){
        int nextIndex = 0;
        int prevIndex = lastOpponentMove.ordinal();
        
        for (int i = 0; i < Action.values().length; i++) {
              if (markovChain[prevIndex][i] > markovChain[prevIndex][nextIndex]) {
              nextIndex = i;
            }
          }

        // Item probably played by the user is in nextIndex
        Action predictedNext = Action.values()[nextIndex];
        List<Action> options = losesTo.get(predictedNext);
        return options.get(RANDOM.nextInt(options.size()));
    }
  
    public Action RunRandomBot(Action lastOpponentMove){
        double coinFlip = Math.random();
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

    public Action RunLTWBot(Action lastOpponentMove){
        this.prevMoveThem = Action.ROCK;
        this.prevMoveMe = Action.ROCK;
            
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
    
    public double max(){
        int max = 0;
        int len = rankings.length;
        for (int i = 0; i < len; i++){
            if (rankings[i] > rankings[max]){
                max = i;
            }
        }
        return max;
    }
    
    public void predict(Action prev){
        this.prevPred[0] = RunNashBot(prev);
        this.prevPred[1] = RunRandomBot(prev);
        this.prevPred[2] = PredMarkovBot(prev);
        this.prevPred[3] = RunLTWBot(prev);
    }
    
    public void checkPred(Action lastOpponentMove){
        List<Action> goodOptions = losesTo.get(lastOpponentMove);
        // naive scoring
        for (int i=0;i<=3;i++){
        // find if past prediction beat last opp move
            if(goodOptions.get(0) == prevPred[i] || goodOptions.get(1) == prevPred[i]){
               // add 1 to rankings
                this.rankings[i] = this.rankings[i] + 1;
            }
            else{
                // if not subtract 1
                this.rankings[i] = this.rankings[i] - 1;
            }
        // multiply by 0.9
        this.rankings[i] = this.rankings[i];
        }
    }

    public Action getNextMove(Action lastOpponentMove){
        this.rounds = this.rounds + 1;
        //if first round, pick random move
        if (rounds == 1){
            this.prevMove = lastOpponentMove;
            return Action.values()[RANDOM.nextInt(Action.values().length)];
        }
        else
            // update pointers
            secLastMove = prevMove;
            predict(prevMove);
            // check predictions
            checkPred(lastOpponentMove);
            //update Markov Chain
            int prevIndex = lastOpponentMove.ordinal();
            int secLastIndex = prevMove.ordinal();
            markovChain[secLastIndex][prevIndex]++;
            //update prev move for next round
            prevMove = lastOpponentMove;
            // find best predictor
            double index = max();
            if(index == 0){
                return RunNashBot(lastOpponentMove);
            }
            else if(index == 1){
                return RunRandomBot(lastOpponentMove);
            }
            else if(index == 2){
                //i think moves might be added twice to markov chain
                return RunMarkovBot(lastOpponentMove);
            }
            else if(index == 3){
                return RunLTWBot(lastOpponentMove);
            }
            else{
                return Action.ROCK;
            }
    }
        
}
