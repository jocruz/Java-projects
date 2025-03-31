# ⚾ Baseball Card Collection Project

## Overview
The Baseball Card Collection project is a comprehensive Java application designed to manage a collection of baseball cards. It allows users to add, remove, copy, and trade baseball cards between two collections, each with a maximum capacity of 100 cards. This project is a testament to object-oriented programming principles, data management, and user interaction through a console-based menu-driven interface.

## Key Features
- **Card Management:** Users can add new cards with details such as player name, manufacturer, year, size, and price.
- **Collection Operations:** Supports copying cards within or between collections, updating card details, and removing cards from the collection.
- **Trade Mechanism:** Allows trading of cards between two distinct collections, enabling dynamic interaction with the card inventory.
- **Search and Retrieval:** Provides functionality to locate cards in the collection based on detailed attributes and retrieve card information efficiently.
- **Value Calculation:** Calculates the total value of each collection, highlighting the financial aspect of the card collection.
- **Exception Handling:** Implements custom exception handling to manage full collection scenarios, ensuring robust error management.

## Technical Highlights
- **Data Structures:** Utilizes arrays to store and manage the collection of `BaseballCard` objects, demonstrating effective use of basic data structures in Java.
- **Object-Oriented Design:** Features well-defined classes with encapsulation, constructors, accessors, mutators, and methods like `clone()` and `equals()` for deep copying and equality checking, illustrating strong OOP practices.
- **Exception Handling:** Custom exception `FullCollectionException` is defined and used to handle specific error scenarios, ensuring the application's stability and reliability.
- **User Interface:** A command-line interface (CLI) with a menu-driven system for user interaction, showcasing efficient user input and output handling.

## File Descriptions and Functionalities

### `BaseballCard.java`
- **Purpose:** Defines the `BaseballCard` class representing individual baseball cards.
- **Functionalities:**
  - Stores card details (player name, manufacturer, year, price, size).
  - Provides methods to get and set card attributes.
  - Implements `clone()` for object duplication and `equals()` to compare card objects.

### `CardCollection.java`
- **Purpose:** Manages a collection of `BaseballCard` objects within a fixed-size array.
- **Functionalities:**
  - Adds, removes, and retrieves cards from the collection.
  - Supports trading cards between collections.
  - Checks for card existence and prints the collection details.

### `CollectionManager.java`
- **Purpose:** Serves as the user interface and command center to interact with the card collections.
- **Functionalities:**
  - Menu-driven interface to perform actions like add, copy, remove, trade cards, and more.
  - Implements collection operations through user inputs.
  - Displays detailed information about the collections and individual cards.

### `FullCollectionException.java`
- **Purpose:** Custom exception class to handle scenarios when the card collection reaches its maximum capacity.
- **Functionalities:**
  - Extends the `Exception` class to provide specific error handling related to collection size limits.

## Project Significance
This project encapsulates the essence of Java programming with a focus on object-oriented design, data management, and user-centric operations. It serves as an excellent representation of my ability to construct interactive and functional applications while adhering to software development best practices.

## Usage
The application is operated via a command-line interface where users can interact with the menu to perform various operations on the baseball card collection, such as adding, copying, trading, and managing cards within the collections.
