# 🛫 Sigma Airline Application

## Overview
The **Sigma Airline Application** is a comprehensive system for managing and analyzing airport networks. It integrates geographic data for airports, manages connections, and calculates the most efficient routes.

## Features

- ** City Management:** Manages global cities with detailed attributes such as name, latitude, and longitude.
- ** Comparator Utilities:** Provides sorting functionality for cities based on latitude, longitude, and name.
- ** Network Analysis:** Maintains an efficient route network using an adjacency matrix and implements the Floyd-Warshall algorithm for shortest path calculations.
- ** User Interface:** Offers a command-line interface for interactive management of the airline network.

## File Descriptions

- **`City.java`**: Defines the `City` class with attributes for city name, geographical coordinates, and utility methods for city management.
- **`LatComparator.java`**: Implements a comparator for sorting cities based on latitude.
- **`LngComparator.java`**: Provides a comparator for ordering cities by longitude.
- **`NameComparator.java`**: Contains a comparator for sorting cities alphabetically by name.
- **`SigmaAir.java`**: The core class that manages the airline network, including city addition, connection management, and shortest path finding.
- **`SigmaAirDriver.java`**: The main driver class that provides a command-line interface for interacting with the SigmaAir system.

## Getting Started

- Initialize the SigmaAir application, which loads or creates a new airline network.
- Use the command-line interface to manage cities, connections, and analyze the network.

## Technologies

- Java for core application development.
- Google Geocoding API for fetching city coordinates.
- Serialization for data persistence.

## Future Enhancements

- Develop a web interface for broader accessibility.
- Integrate real-time flight data for dynamic network management.
- Expand analytics for comprehensive network optimization.

## Conclusion

The Sigma Airline Application is a robust tool designed for effective management and optimization of airline networks, showcasing advanced programming, data handling, and analytical capabilities.
