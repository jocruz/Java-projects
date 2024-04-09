# 🛫 Sigma Airline Application

## 🌟 Overview
The **Sigma Airline Application** is a state-of-the-art system designed for the robust management and analysis of airport networks. It facilitates airport location storage, connections management, and shortest path determinations, ideal for dynamic airport network optimization.

## 🚀 Features

- **🌐 City Management:** Utilizes the `City` class to represent global cities with detailed attributes like name, latitude, and longitude. It efficiently maintains a count and index for cities within SigmaAir's network.
- **🔍 Comparator Utilities:** Features `LatComparator`, `LngComparator`, and `NameComparator` classes for sorting cities based on latitude, longitude, and name, aiding in organized data management.
- **🌉 Network Analysis:** The core `SigmaAir` class leverages Google's Geocoding API for precise city coordinates, manages route connections through an adjacency matrix, and employs the Floyd-Warshall algorithm for optimal pathfinding.
- **👨‍💼 User Interaction:** `SigmaAirDriver` provides a user-friendly command-line interface for system interaction, enabling data management and efficient network querying.

## 🛠️ Functionality

- **🏙️ Adding Cities and Connections:** Allows for the addition of cities with automatic geographical coordinate retrieval. Establishes connections between cities to represent flight routes.
- **📂 Data Loading and Management:** Supports bulk data upload from files to seamlessly integrate city and connection information into the network.
- **📊 City Sorting and Display:** Offers functionality to list and sort cities by different criteria, providing a comprehensive network overview.
- **🗺️ Route Optimization:** Features an advanced shortest path algorithm to calculate the most efficient travel routes within the airline network.

## 🎬 Getting Started

1. **Initialize SigmaAir:** The application tries to load existing network data from `sigma_air.obj` or creates a new SigmaAir instance if not found.
2. **Manage Cities and Routes:** Through intuitive command-line prompts, add cities and connections manually or in bulk via file uploads.
3. **Query and Analyze:** Leverage the sorting and pathfinding capabilities to optimize route planning and network analysis.

## 💻 Technologies

- **Java**
- **Google Geocoding API**
- **Serializable** for data persistence
- **Command-line Interface** for user interaction

## 🌱 Future Enhancements

- **Web Interface:** Transition to a web-based platform for wider accessibility.
- **Real-time Flight Data:** Integrate live flight data for dynamic network management.
- **Advanced Analytics:** Implement comprehensive analytics for network optimization and strategic planning.

## ✨ Conclusion

The **Sigma Airline Application** is a comprehensive tool for airline network management, blending geographic data integration, efficient routing algorithms, and intuitive user interaction. It's crafted to facilitate effective airline operations and strategic planning, making it an ideal showcase for employers looking at cutting-edge software solutions in the aviation industry.
