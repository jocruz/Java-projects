# 🃏 Stackotaire Solitaire Game Project

## Overview
The Stackotaire Solitaire game is a Java-based simulation of the classic Solitaire (Klondike) card game. It represents cards and stacks of cards within the game, allowing for operations such as drawing from the stock, moving cards between tableau and foundation stacks, and automatically moving eligible cards to the foundation.

## Key Features
- **Card Representation:** Each card is defined by its suit, value, and face-up status, with methods to manage these properties.
- **Dynamic Stacks:** Implements stacks for different game areas (stock, waste, foundation, tableau) with operations like push, pop, and stack visualization.
- **Game Logic:** Facilitates typical Solitaire moves, including drawing cards, moving between stacks, and automatic moves to the foundation.
- **User Interaction:** Command-line interface for gameplay, allowing moves through textual commands and options to restart or quit the game.

## Technical Highlights
- **Object-Oriented Design:** Utilizes classes to represent game elements (cards, stacks) and game logic, showcasing encapsulation and method overriding (e.g., `push` and `pop` in `CardStack`).
- **Stack Utilization:** Inherits from Java's `Stack` class in `CardStack` to manage card movements and stack-related actions efficiently.
- **Game Flow Control:** Includes a main game loop with command parsing and execution, handling user inputs and game state transitions.
- **Error Handling:** Implements checks and balances to prevent illegal game actions, providing feedback for invalid moves.

## File Descriptions and Functionalities

### `Card.java`
- **Purpose:** Represents a playing card with suit, value, and face-up status.
- **Functionalities:**
  - Initialize cards with suit, value, and face orientation.
  - Methods to set and get card properties (e.g., `setSuit`, `getValue`).
  - Supports checking card color and compatibility for game logic.

### `CardStack.java`
- **Purpose:** Extends `Stack<Card>` to represent stacks of cards in the game with a specific type (stock, waste, foundation, tableau).
- **Functionalities:**
  - Custom push and pop to manage card stacking.
  - Implements `printStack` to visually render the stack based on its type.
  - Inherits standard stack behaviors with game-specific extensions.

### `Stackotaire.java`
- **Purpose:** Contains the game's main method and logic, facilitating gameplay through a command-line interface.
- **Functionalities:**
  - Handles game setup, card shuffling, and distribution into stacks.
  - Processes user commands for game actions (draw, move, restart, etc.).
  - Monitors and determines game state (e.g., win condition).

## Project Significance
This project demonstrates comprehensive use of object-oriented programming concepts in a familiar game context. It highlights the ability to create an interactive application with complex logic and user interaction, encapsulated within a structured and modular codebase.

## Usage
Run `Stackotaire.java` to start the game. Use command-line inputs to interact with the game, following on-screen prompts and instructions for various commands like `draw`, `move`, `restart`, and `quit`. The game's logic and flow are controlled through these inputs, mimicking the traditional Solitaire experience in a text-based format.
