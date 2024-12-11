# Magical Arena

## Overview

Magical Arena is a tournament-style battle game where players with different attributes (health, strength, and attack) fight against each other in an arena. Players attack in turns, and their actions are determined by dice rolls. The game continues until one player's health drops to 0.

## How to Play

1. **Players**: The game involves multiple players. Each player has attributes such as health, strength, and attack.

2. **Combat**: Two players are selected randomly to face each other in combat. The player with the lower health attacks first. During their turn, both players roll dice to determine the effectiveness of their attack and defense. The attacker deals damage based on their attack value multiplied by the dice roll, while the defender defends based on their strength value multiplied by the dice roll. The net damage is subtracted from the defender's health.

3. **Winning**: The game continues until one player's health reaches 0. The player whose health reaches 0 loses, and the other player wins the match.

## Requirements

- **Java Version**: The project is compatible with JDK 17 or higher.
- **Docker** (Optional): You can use Docker to run the application without worrying about environment compatibility.
- **JUnit 5.9**: For unit testing
## Classes Design

### 1. **Arena**
- **Arena** is the main interface for the game, which includes methods for starting the tournament and managing matches.
- **MagicalArena**: Implements the `Arena` interface and manages the gameplay between two players.
- **ArenaFactory**: A factory class used to create the arena based on the chosen arena type.
- **RandomPlayerSelector**: Responsible for selecting two random players from the available list.

### 2. **Player**
- **Player**: Interface that defines basic player attributes and actions, such as health, attack, defense, and damage handling.
- **BasicPlayer**: Implements the `Player` interface and represents a basic player type with a specified health, attack, and defense.
- **PlayerFactory**: A factory class for creating different types of players.

### 3. **Dice**
- **Dice**: Interface that defines the dice rolling behavior.
- **SixSidedDice**: Implements a 6-sided dice used by players for attacking and defending.
- **DiceFactory**: A factory class used to create the dice based on the chosen type.

## Project Structure
- src/main/java (Main.java): Contains the main source code files which is inside org.magical_arena package.
- src/test/java (PlayerTest.java, DiceTest.java and ArenaTest.java: Contains the test source code files which is inside org.magical_arena package.
- pom.xml: Maven project configuration file.
- src/main/resources/arena_config.txt The game uses a configuration file to specify the arena settings, dice type, player types, and their attributes.


## How to Run
Option 1: Run in Your Local Java Environment
1. Ensure you have JDK 17 or higher installed.
2. Import the Project
    - Open Eclipse IDE.
    - Go to File -> Import -> Existing Maven Projects.
    - Browse to the project directory and select it.
    - Click Finish.
3. Run the Application:
   - Run the Main.java file (located in src/main/java) as a Java application to start the game.

Option 2: Run Using Docker 
1. Build the Docker Image:
   - docker build -t arena-app .

2. Run the Docker Container:
   - docker run --rm arena-app


## Unit Tests
The project includes unit tests to ensure the correctness of the code. The tests use JUnit 5.9.3.
To Run the Unit Tests (e.g., PlayerTest, DiceTest, or ArenaTest).