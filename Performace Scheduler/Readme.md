# 🎭 Performance Scheduler System

## Overview
The Performance Scheduler System is a Java application that manages a schedule of performances using a linked list structure. It enables users to add, remove, display, and navigate through performances, demonstrating the dynamic and flexible nature of linked lists in managing ordered data.

## Key Features
- **Dynamic Scheduling:** Users can add performances to the end of the list or directly after the current node, allowing for flexible schedule management.
- **Cursor Navigation:** Provides functionality to move forward and backward through the performance list, enabling easy navigation and management of the schedule.
- **Performance Management:** Supports insertion, deletion, and retrieval of performance details at the current cursor position.
- **List Navigation:** Allows jumping to any position in the list, facilitating quick access to specific performances.

## Technical Highlights
- **Linked List Implementation:** Utilizes a custom linked list (`PerformanceNode` and `PerformanceList`) to manage performances, showcasing efficient data manipulation techniques.
- **Exception Handling:** Incorporates custom exceptions (`EmptyListException`, `NoCursorException`) to handle edge cases and enhance user experience.
- **Data Integrity and Validation:** Ensures all performance data are valid and handles cases of empty or null entries gracefully.
- **Interactive User Interface:** Provides a menu-driven interface for users to interact with the performance schedule, demonstrating practical application of linked list operations.

## File Descriptions and Functionalities

### `EmptyListException.java`
- **Purpose:** Thrown when operations are attempted on an empty list.
- **Functionalities:**
  - Custom exception to handle cases where list operations cannot proceed due to the absence of nodes.

### `NoCursorException.java`
- **Purpose:** Thrown when there is an attempt to access or manipulate a nonexistent cursor in the list.
- **Functionalities:**
  - Custom exception to address situations where cursor-related actions are invalid.

### `PerformanceList.java`
- **Purpose:** Manages a linked list of `PerformanceNode` objects, representing the schedule of performances.
- **Functionalities:**
  - Implements methods for adding, removing, and displaying performances, as well as navigating through the list.

### `PerformanceNode.java`
- **Purpose:** Represents an individual performance in the list.
- **Functionalities:**
  - Stores details about the performance and links to the next and previous nodes in the list.

### `PerformanceScheduler.java`
- **Purpose:** Serves as the main interface for the user to interact with the performance list.
- **Functionalities:**
  - Provides a menu-driven system for adding, removing, and navigating performances, and displays the schedule in a user-friendly format.

## Project Significance
This project demonstrates the practical use of linked lists in application development, emphasizing data structure manipulation, user input handling, and dynamic data management. It serves as an effective showcase of my skills in implementing complex data structures and creating interactive applications in Java.

## Usage
The system is operated via a command-line interface, where users can add performances, navigate through the schedule, and modify the list of performances as needed. The system maintains the order and details of each performance, offering a comprehensive view of the scheduled events.
