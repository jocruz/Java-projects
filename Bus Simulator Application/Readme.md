# Bus Simulator Project

## 📚 Overview
The Bus Simulator is a sophisticated Java application designed to model the operations of a bus system. It simulates the movement of buses along specified routes, managing passengers boarding, alighting, and transitioning between stops. This project exemplifies the use of simulation, object-oriented programming, and data structures to create a dynamic and interactive model of a public transportation system.

## 🚌 Key Features
- **Dynamic Simulation:** Simulates real-time bus movements, passenger arrivals, and the boarding/alighting process.
- **Route Management:** Supports multiple bus routes with distinct paths and stops.
- **Passenger Dynamics:** Manages passenger groups with varying sizes, destinations, and arrival times.
- **Efficiency Analysis:** Calculates average wait times and total groups served to evaluate system performance.
- **Probability Modeling:** Uses probability for passenger arrivals and actions, enhancing the realism of the simulation.

## 🛠️ Technical Highlights
- **Probabilistic Events:** Utilizes the `BooleanSource` class to model the likelihood of passenger arrivals based on predefined probabilities.
- **Queue Management:** Employs `PassengerQueue` to manage passengers at each stop, reflecting real-world line scenarios.
- **Object-Oriented Principles:** Incorporates classes like `Bus` and `Passenger` to encapsulate attributes and behaviors of simulation entities.
- **Simulation Engine:** The `Simulator` class acts as the central control unit, orchestrating the entire simulation process and managing time progression.

## 🗂️ File Descriptions and Functionalities

### `BooleanSource.java`
- **Purpose:** Models random events (like passenger arrivals) based on a given probability.
- **Functionalities:**
  - Provides a method `occurs()` to determine if an event happens at a given time step based on probability.

### `Bus.java`
- **Purpose:** Represents a bus in the simulation with attributes like route, capacity, and current stop.
- **Functionalities:**
  - Manages bus state (resting, en route, or at a stop) and handles passenger boarding and alighting.
  - Tracks the bus's progress along its route, including rest times and travel between stops.

### `Passenger.java`
- **Purpose:** Represents passengers in the simulation, each with a destination and group size.
- **Functionalities:**
  - Stores information about the passenger group, including size, destination, and time of arrival at the bus stop.

### `Simulator.java`
- **Purpose:** Controls the simulation, managing the flow of time and interactions between buses and passengers.
- **Functionalities:**
  - Initializes the simulation environment, including buses and bus stops.
  - Advances the simulation through time, processing passenger arrivals, bus movements, and passenger transfers.

## 🎨 Project Significance
This project showcases the ability to apply complex programming concepts and data structures to simulate real-world systems. It demonstrates a deep understanding of event-driven programming, object-oriented design, and probability theory, making it an excellent example of practical and theoretical computer science skills.

## 📝 Usage
The simulation is configured and run through the `Simulator` class, where parameters like number of buses, bus capacity, and passenger arrival probabilities can be set. The simulator progresses in time steps, updating the state of each bus and bus stop, and calculates performance metrics like average waiting time and total passengers served.
