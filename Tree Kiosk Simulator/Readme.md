# 🍴 Kiosk Ordering System

## 🌟 Overview
The Kiosk Ordering System is a Java-based application designed to simulate a self-service kiosk for placing orders, implemented through a command-line interface. It utilizes a tree structure to manage the menu and user selections.

## 🚀 Features

- **📂 Tree-Based Menu Structure:** Organizes menu items in a tree format, allowing for nested choices and a hierarchical order.
- **📚 Dynamic Menu Loading:** Load menu items from a file to create a flexible and updatable tree structure.
- **🖥️ User Interaction:** Offers a simple text-based interface for users to navigate through the menu and place orders.
- **🧾 Session Management:** Handles individual service sessions, guiding the user from the main menu to the final order summary.

## 📁 File Descriptions

- **`Kiosk.java`**: The main class that provides the user interface for interacting with the menu and managing the service session.
- **`Tree.java`**: Manages the tree structure representing the menu, including nodes addition, menu printing, and session handling.
- **`TreeNode.java`**: Represents a single item in the menu tree, holding information about the item and its relationship to other items in the tree.

## 🎯 Functionality Breakdown

- **Loading the Tree (`Kiosk.java`)**: Initializes the menu tree from a specified file, creating a new `Tree` object.
- **Printing the Menu (`Tree.java`)**: Displays the entire menu in a structured format, showcasing available options and navigating through the tree.
- **Starting a Service Session (`Tree.java`)**: Begins an ordering session, allowing the user to make selections based on the loaded tree and culminating in the final order summary.
- **Quitting the Program (`Kiosk.java`)**: Ends the session and exits the application.

## 💡 Use Cases

1. **Menu Management**: Load and display various menu configurations for different service scenarios.
2. **Order Placement**: Users navigate through the menu, making selections that lead to a final order.
3. **Service Simulation**: Simulate the process of order placement in a kiosk-like setting, from start to finish.

## 🔄 Interaction and Flow

1. **Load Menu**: Start by loading the menu from a file to populate the tree structure.
2. **Print Menu**: Display the menu to the user, showing all available options and selections.
3. **Service Session**: Interactively walk through the menu, allowing the user to make choices and build their order.
4. **Complete Order**: Finalize the session by presenting a summary of the order and the total cost.
