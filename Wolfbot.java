// import java.util.Random;
// public class Wolfbot implements RoShamBot {
 
//     /** Returns an action according to the WoLF PHC algorithm for rock, paper, scissors, lizard, spock.
//       * 
//       * @param lastOpponentMove the action that was played by the opponent on
//       *        the last round (this is disregarded).
//       * @return the next action to play.
//       */

//     Random random = new Random();
    
//     int alpha; 
//     int deltaL;
//     int deltaW;
//     int [][] qTable = new int[5][5];
//     int [][] piTable = new int[5][5];
//     int move = 0; 
//     int numActions;

//     public Action getNextMove(Action lastOpponentMove) {
        
//         // mixed strategy for getting next move
//         Random random = new Random();
//         double use_thres = random.nextFloat();
//         if (threshold > use_thresh){ //RANDOM ACTION 
//             int choose_action = random.nextInt(5)
//             if (choose_action == 0){
//                 return Action.ROCK;
//             }
//             if (choose_action == 1){
//                 return Action.PAPER;
//             }
//             if (choose_action == 2){
//                 return Action.SPOCK;
//             }
//             if (choose_action == 3){
//                 return Action.LIZARD;
//             }
//             else{
//                 return Action.SCISSORS;
//             }
//         }
//         else{ // POLICY ACTION 
//             double rand = Math.random();
//             for (int action=0; action<numActions; action++) {
//                 if(rand < prob[action]){
//                     return action;
//                 }
                    
//                 else
//                     rand = rand- prob[action];
//                 }
// 	            }
//         }
//     }







//     double[] probability;
//     double[] value;
//     int Ai = 0; 
//     double PiBar = 0.0; 
    
//     int [][] pi = new int[5][5];
    
//     for (int i = 0; i < 5; i++) {
//         for (int j = 0; j < 5; j++) {
//             qTable[i][j] = 0;
//         }
//     }

    

    
// }