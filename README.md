# RPSLS-Competition

This project implements a program that excels at playing a multi-round version of the game Rock-Paper-Scissors-Lizard-Spock (RPSLS) against opponents using nonequilibrium strategies. RPSLS is a generalization of the classic Rock-Paper-Scissors game, with two additional actions, adding more complexity and reducing the probability of tied outcomes.

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
Tournament bot1.java bot2.java num_rounds
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

