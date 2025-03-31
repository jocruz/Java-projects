# 🎲 Baccarat Game Simulation

## Overview
The Baccarat Game is a Java-based simulation that encapsulates the essence of the traditional card game with a comprehensive graphical user interface (GUI). This project showcases the integration of Java Swing for the GUI, demonstrating the ability to create interactive and user-friendly applications.

## Key Features
- **Interactive GUI**: Utilizes Java Swing to provide a dynamic and engaging user interface.
- **Game Mechanics**: Implements the rules of Baccarat, allowing for realistic gameplay including betting, card dealing, and scoring.
- **Betting System**: Features a simulated purse for placing bets, with updates based on game outcomes.

## Technical Structure
- **Java Swing for GUI**: Demonstrates the use of Java Swing components like `JPanel`, `JButton`, `JLabel`, and custom event handling for a rich user interface.
- **Game Logic Implementation**: Shows how game rules and mechanics are coded within Java, offering a practical example of applying programming skills to game development.

## Code Highlights
- **Card Dealing Logic**:
  ```java
  public void drawCard() {
      // Logic to draw a card and update hands and GUI components
  }
  public void drawBankCard() {
      // Logic for drawing a card for the computer's hand
  }
  ```
  These methods demonstrate the core functionality of card drawing in the game, integrating with the GUI to display the drawn cards.

- **Betting and Round Management**:
  ```java
  b41.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { refreshDisplay("b41"); }
  });
  ```
  This snippet shows how betting buttons are wired with action listeners to update the game state and GUI in response to user interactions.

- **Sum Calculation**:
  ```java
  public static int sum_hand(int[][] hand, int noOfCards){
      // Sum calculation logic for a hand
  }
  ```
  Essential for determining the score of a hand in Baccarat, this method calculates the sum of the cards' values, considering the unique scoring rules of Baccarat.

## Running the Game
Compile and run `Baccarat_GUI.java` to launch the game. Interact with the GUI to place bets, deal cards, and play rounds of Baccarat against the computer.

## Future Enhancements
- **Enhanced Betting Features**: Introduce options like betting on ties or player/banker pairs to enrich the gameplay.
- **Multiplayer Functionality**: Add network capabilities for multiplayer sessions.
- **Improved Graphics and Animations**: Upgrade the GUI with enhanced graphics and animations for a more immersive experience.
