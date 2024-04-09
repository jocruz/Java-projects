# Itinerary Management System

## 📚 Overview
The Itinerary Management System is a Java application designed to manage and navigate through a list of travel stops, each defined by location, distance, and activity. This project highlights the use of linked lists, object-oriented programming, and exception handling to create a robust system for itinerary planning and management.

## 🌍 Key Features
- **Itinerary Navigation:** Allows users to traverse through the itinerary, moving forwards and backwards through the list of trip stops.
- **Trip Stop Management:** Enables adding new stops before the cursor or appending them at the end of the itinerary, as well as removing the current stop.
- **Data Integrity:** Ensures that all trip stops have valid data and handles exceptional cases, such as negative distances or null entries.
- **Dynamic List Handling:** Utilizes a doubly linked list structure to store trip stops, allowing efficient insertion and deletion operations.

## 🛠️ Technical Highlights
- **Doubly Linked List:** Implements a custom doubly linked list (`TripStopNode`) to manage the itinerary, providing flexibility and efficient access to trip stops.
- **Exception Handling:** Defines custom exceptions (`EndOfItineraryException`, `EndOfListException`) to handle specific boundary cases and ensure robust user interactions.
- **Data Validation:** Ensures the validity of trip stop data through rigorous checks, preventing illegal states and maintaining system integrity.
- **Navigation and Modification:** Offers comprehensive methods for navigating through the itinerary and modifying its content, reflecting dynamic list manipulation capabilities.

## 🗂️ File Descriptions and Functionalities

### `EndOfItineraryException.java`
- **Purpose:** Signals that the cursor has reached the end of the itinerary and cannot move forward.
- **Functionalities:**
  - Provides a standard exception structure with optional custom messages.

### `EndOfListException.java`
- **Purpose:** Indicates that an operation attempted to access beyond the list's bounds.
- **Functionalities:**
  - Similar to `EndOfItineraryException`, offers feedback for operations exceeding the list's limits.

### `Itinerary.java`
- **Purpose:** Manages the collection of `TripStop` objects in a linked list format, representing the travel itinerary.
- **Functionalities:**
  - Supports cursor movement, addition, and removal of trip stops within the list, and tracks the total number of stops and distances.

### `TripStop.java`
- **Purpose:** Represents a single stop in the itinerary, holding details like location, distance, and activity.
- **Functionalities:**
  - Encapsulates trip stop data and provides methods to get and set these details, with validation for distance.

### `TripStopNode.java`
- **Purpose:** Acts as a container for `TripStop` objects in the linked list, maintaining links to previous and next nodes.
- **Functionalities:**
  - Holds a `TripStop` object and references to adjacent nodes in the list, facilitating the linked list structure.

## 🎨 Project Significance
This project showcases my ability to design and implement a complex data structure (doubly linked list) in a real-world application. It demonstrates proficiency in Java programming, with a focus on class design, exception handling, and list manipulation, making it an excellent showcase of both theoretical knowledge and practical skills.

## 📝 Usage
The system is operated through an instance of the `Itinerary` class, where users can add, remove, and navigate through trip stops. The `TripStop` objects are managed within the `Itinerary` using the `TripStopNode` linked list structure, allowing for dynamic itinerary management.
