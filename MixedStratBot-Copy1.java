// import java.util.Arrays;
// import java.util.Random;
// /** Uses 4 strategies, estimates which will work the best
//   * 
//   * 
//   * @author PJ
//   */
// public class MixedStratBot implements RoShamBot{
//     private static final int numPre = 54;
//     private static final int numMeta = 24;
//     private static final int[] limits = {50, 20, 10};
//     private static final String[] moves = {"", "", ""};
//     private static final String[] p = new String[numPre];
//     private static final String[] m = new String[numMeta];
//     private static final int[][] pScore = new int[8][numPre];
//     private static final int[] mScore = new int[numMeta];
//     private static final double[] threat = {0, 0, 0};
//     private static final String[] outcomes = {"R", "P", "S"};
//     //private static final String[] beat = {"P", "S", "R"};
//     private static final String[] centrifuge = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
//     private static int length;
//     private static int outcome;
//     private static int oldOutcome;
    
//     private int rounds;
//     Map<Action, List<Action>> losesTo = new HashMap<Action, List<Action>>();
    
//     public void init() {
//         this.limits = [50,20,10]
//         // initialize losesTo Map
//         this.losesTo.put(Action.ROCK, Arrays.asList(Action.PAPER, Action.SPOCK));
//         this.losesTo.put(Action.PAPER, Arrays.asList(Action.SCISSORS, Action.LIZARD));
//         this.losesTo.put(Action.SCISSORS, Arrays.asList(Action.ROCK, Action.SPOCK));
//         this.losesTo.put(Action.LIZARD, Arrays.asList(Action.SCISSORS, Action.ROCK));
//         this.losesTo.put(Action.SPOCK, Arrays.asList(Action.PAPER, Action.LIZARD));
//     }
    
//     public MixedStratBot() {
//         this.rounds = 0;
        
//     }
    
//     /** Returns the next action that this bot will take. */
//     public Action getNextMove(Action lastOpponentMove){
        
//     }


//     public static void main(String[] args) {
//         play(args.length > 0 ? args[0] : "");
//     }

//     private static void play(String input) {
//         String output2 = "", output = "";
//         if (input.isEmpty()) {
//             length = 0;
//             outcome = 0;
//             Arrays.fill(moves, "");
//             Arrays.fill(p, randomChoice(outcomes));
//             Arrays.fill(m, randomChoice(outcomes));
//             Arrays.stream(pScore).forEach(scores -> Arrays.fill(scores, 3));
//             Arrays.fill(mScore, 3);
//             Arrays.fill(threat, 0);
//         } else {
//             oldOutcome = outcome;
//             outcome = (beat[input].equals(output2) ? 1 : 0) - (input.equals(beat[output2]) ? 1 : 0);
//             threat[oldOutcome + 1] *= 0.957;
//             threat[oldOutcome + 1] -= 0.042 * outcome;
//             for (int i = 0; i < numPre; i++) {
//                 pScore[0][i] = (int) (0.8 * pScore[0][i] + ((input.equals(p[i]) ? 1 : 0) - (input.equals(beat[beat[p[i]]]) ? 1 : 0)) * 3);
//                 pScore[1][i] = (int) (0.8 * pScore[1][i] + ((output.equals(p[i]) ? 1 : 0) - (output.equals(beat[beat[p[i]]]) ? 1 : 0)) * 3);
//                 pScore[2][i] = (int) (0.87 * pScore[2][i] + (input.equals(p[i]) ? 3.3 : 0) - (input.equals(beat[p[i]]) ? 0.9 : 0) - (input.equals(beat[beat[p[i]]]) ? 3 : 0));
//                 pScore[3][i] = (int) (0.87 * pScore[3][i] + (output.equals(p[i]) ? 3.3 : 0) - (output.equals(beat[p[i]]) ? 0.9 : 0) - (output.equals(beat[beat[p[i]]]) ? 3 : 0));
//                 pScore[4][i] = (int) ((pScore[4][i] + (input.equals(p[i
