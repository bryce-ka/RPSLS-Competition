# RPSLS-Competition

This project implements a program that excels at playing a multi-round version of the game Rock-Paper-Scissors-Lizard-Spock (RPSLS) against opponents using nonequilibrium strategies. RPSLS is a generalization of the classic Rock-Paper-Scissors game, with two additional actions, adding more complexity and reducing the probability of tied outcomes.

I created:
- RandomBot: This bot picks a random move, then it picks
the opponents last move and repeats.

The random bot was inspired by the concept of Nash
Equilibrium and the research of (Mohtavipour and Zideh
2019) on the detection of collusive strategies in multiagent
games. The idea behind this bot was that it would maintain
randomness while also implementing a, fairly simple, strategy.
- LoseToWinBot: This bot randomly returns one of the 2
moves that would have lost to the opponent’s previous
move but repeats its previous move if it won.
The LoseToWinBot was implemented based on the paper
from (Wang, Xu, and Zhou 2014) as they found a simple
conditional response strategy (win-stay lose-shift) to be effective against human rock, paper, scissors players. This was
due to the tendency of humans to cycle through the choices
in rock, paper, scissors, which we hypothesized would be
perpetuated into the models created by others in the class.
The LoseToWinBot based its moves solely on the previous
move made by itself and its opponent. If the LoseToWinBot won the previous round the same move would be played
again. If the opponent won the previous game, the LoseToWinBot would choose a move that would lose to the opponent’s last move and due to the tendency to cycle through
moves rather than repeat the same move; the LoseToWinBot would be more likely to either win or tie the next round.
Although very different functionally from the WoLF PHC
algorithm described in (Bowling and Veloso 2001), the concept of learning fast while losing and slowly when winning
is captured pretty well by the strategy.
- comboBot: Plays NashBot, RandomBot, or LoseToWinBot based on the opponent’s last 100 moves.
The comboBot was inspired by the research of
(Wang et al. 2020) as they used a mixed strategy that contained several Markov Chain models and selected the move
from the best performing Markov chain model along with its
prediction based on a specified number of the recent rounds.
This “Focus Length” as described in (Wang et al. 2020) was
also used in a version of our comboBot allowing it to switch
between the 3 strategies it implements to use the one that
would be most effective against the most recent strategy being used by the opponent, rather than the just the most recent
move. This idea of using a mixed strategy that is informed
by the opponents past moves was also echoed in (Bowling
and Veloso 2001) and (Wang, Xu, and Zhou 2014); in which
both of their rock, paper, scissors agents implement mixed
strategies to adapt to the other player’s current and potentially changing strategy.


## Game Rules

In RPSLS, the five actions are as follows:
- Rock: represented by the hand gesture of a clenched fist.
- Paper: represented by an open hand.
- Scissors: represented by extending the index and middle fingers.
- Lizard: represented by forming a hand shape similar to a sock puppet.
- Spock: represented by the Vulcan salute from Star Trek.

The rules for determining the winner in a single round are:
- Rock crushes Scissors and crushes Lizard.
- Paper covers Rock and disproves Spock.
- Scissors cut Paper and decapitate Lizard.
- Lizard poisons Spock and eats Paper.
- Spock smashes Scissors and vaporizes Rock.

## Project Objective

The objective of this project is to create a program that can outperform opponents playing nonequilibrium strategies in a multi-round game of RPSLS. The program will use advanced algorithms and strategies to analyze the opponents' patterns, exploit weaknesses, and make intelligent decisions to maximize its chances of winning.

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository to your local machine.
2. Compile Action.java, Tournament.java, and the bots to be entered into the tournament

```java
javac bot1.java bot2.java 
```

3. Run a tournament against any two bots 
```java
Tournament bot1 bot2 num_rounds
```

## Features

- Play against the program in a multi-round game of RPSLS.
- Observe the program's performance against opponents using nonequilibrium strategies.
- Interactive user interface for a seamless gaming experience.
- Advanced algorithms for analyzing opponent patterns and making strategic decisions.
- Detailed statistics and feedback on game outcomes.

## Contributing

Contributions to this project are welcome. If you have any ideas, suggestions, or improvements, feel free to submit a pull request or open an issue. Please follow the established code style and guidelines.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code for personal and commercial purposes.

## Acknowledgements

- The rules of the Rock-Paper-Scissors-Lizard-Spock game are inspired by the TV series "The Big Bang Theory" and its creator, Sam Kass.
- The project draws inspiration from various RPSLS game-playing AI algorithms and strategies.

