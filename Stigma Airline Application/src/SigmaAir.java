
import com.google.code.geocoder.*;
import com.google.code.geocoder.model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SigmaAir implements Serializable{

    //number of cities we are accommodating for in our application (use value 100)
    public static final int MAX_CITIES = 100;
    
    //contains all cities with an airport.
    private ArrayList<City> cities;
    
    //adjacency matrix used in our application
    private double[][] connections;
    
    //next is an int matrix of city indeces
    private int[][] next;
    //dist is a double matrix which will contain the length of the shortest path
    //after the method shortest path has been called.
    private double[][] dist;
    
    //Scanner which is used to read from files line by line
    Scanner fileReader;
    
    
    
    
    //constructor for sigmaAir object, initializes all of the matrices, as well as the city arraylist
    public SigmaAir(){
        connections = new double[MAX_CITIES][MAX_CITIES];
        cities = new ArrayList<>();
        
        for (int i = 0; i < MAX_CITIES; i++){
            for (int j = 0; j < MAX_CITIES; j++){
                connections[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        
        //dist and next are MAX_CITIES * MAX_CITIES in size;
        dist = new double[MAX_CITIES][MAX_CITIES];
        next = new int[MAX_CITIES][MAX_CITIES];
    }
    
    public double distance(City source, City destination){
        latlng.LatLng src = new latlng.LatLng(source.getLatitude(),source.getLongitude());
        latlng.LatLng des = new latlng.LatLng(destination.getLatitude(),destination.getLongitude());
        
        return latlng.LatLng.calculateDistance(src, des);
    }
    
    // adds a new city if not already exist
    public void addCity(String city){
        if (hasCity(city) )
            return;
        
        if (City.cityCount == MAX_CITIES){
            System.out.println("Maximum amout of cities has been loaded! Capacity is full.");
            return;
                    
        }
        
        try{
            //initiate the Geocoder API protocol
            Geocoder geocoder = new Geocoder();
            GeocoderRequest geocoderRequest;
            GeocodeResponse geocodeResponse;
            
            geocoderRequest = new GeocoderRequestBuilder().setAddress(city).getGeocoderRequest();
            geocodeResponse = geocoder.geocode(geocoderRequest);
            List<GeocoderResult> list = geocodeResponse.getResults();
            //if the list is empty, that means there were no results for the city name search given.
            if (list.isEmpty()){
                System.out.println("No such city is found on Earth.");
                System.out.println("City \"" + city + "\" not added.\n");
                return;
            }
            
            //acquire latitude, longitude, the city name, and later assign it to the city.
            double lat = list.get(0).getGeometry().getLocation().getLat().doubleValue();
            double lng = list.get(0).getGeometry().getLocation().getLng().doubleValue();
            String name = list.get(0).getFormattedAddress();
            //in order to get proper spellings, we use the substring of the formatted address, before the first comma
            //for example, if you search for "Nwe Yrk", "New York, USA" will be the first item in the results list.
            //However, we want our city to be just called "New York" and not "Nwe Yrk" or "New York, USA",
            //thus we take the formatted address "New York, USA" and extract everything before the first
            //comma, giving me "New York" :)
            if (name.indexOf(",") != -1)
                name = name.substring(0,name.indexOf(","));
            
            City newCity = new City();
            newCity.setName(name);
            newCity.setIndexPos(cities.size());
            
            
            newCity.setLatitude(lat);
            newCity.setLongitude(lng);
            cities.add(newCity);
            
            //update the adjacency matrix
            connections[newCity.getIndexPos()][newCity.getIndexPos()] = 0;
            
            //print out successs message
            System.out.println(name + " has been added: " + String.format("(%.5f)(%.5f)",lat,lng));
        }
        catch(IOException e){System.out.println("IOException");}
        
        
    }
    
    //if the city with the given name is already in our city list, return true
    public boolean hasCity(String cityName){
        for (City city: cities){
            if (city.getName().equals(cityName))
                return true;
        }
        return false;
    }
    
    //find the city in our city list with the given name
    public City findCity(String cityName){
        for (City city: cities){
            if (city.getName().equals(cityName))
                return city;
        }
        return null;
    }
    
    //if appropriate cities are given, calculate the distance between
    //the cities, and include this entry in our adjacency table
    public void addConnection(String cityFrom, String cityTo){
        City from = findCity(cityFrom);
        City to   = findCity(cityTo);
        
        addConnection(from, to);
        
        
    }
    
    //add a connection between the two given cities, if both of them exist
    public void addConnection(City from, City to){
        if (from != null && to != null){
            double dist = distance(from,to);
            connections[from.getIndexPos()][to.getIndexPos()] = dist;
            System.out.println(String.format("%-35s(%-10f)",from.getName() + " --> " + to.getName(),dist));
        }
        else {
            System.out.println("Invalid cities. One or more cities has not been added yet.");
        }
    }
    
    
    //if appropriate cities are given, remove the entry in our adjacency table (set value to ∞)
    public void removeConnection(String cityFrom, String cityTo){
        City from = findCity(cityFrom);
        City to   = findCity(cityTo);
        
        if (from != null && to != null){
            connections[from.getIndexPos()][to.getIndexPos()] = Double.POSITIVE_INFINITY;
            System.out.println("Connection from " + cityFrom + " to " + cityTo + " has been removed.");
        }
        else {
            System.out.println("Invalid cities. One or more cities has not been added yet.\n");
        }
    }
    
    
    //print a list of city names, sorted by a specific Comparator, comp.
    public void printAllCities(Comparator comp){
        System.out.println(String.format("%-20s%-15s%-15s","City Name", "Latitude", "Longitude"));
        
        for (int i = 0; i < 60; i++)
            System.out.print("-");
        System.out.println("");
        
        ArrayList<City> tempList = new ArrayList<>();
        for (City city: cities)
            tempList.add(city);
        Collections.sort(tempList,comp);
        for (City city: tempList){
            System.out.println(city);
        }
    }
    
    //print a list of all connections existing between cities, in aformatted fashion
    public void printAllConnections(){
        System.out.println("Connections");
        System.out.println(String.format("%-40s%-20s","Route","Distance"));
        for (int i = 0; i < 60; i++)
            System.out.print("-");
        System.out.println("");
        
        //this loop prints the connections, by seeing what entries exist in the adjacency matrix
        //if connections[i][i] is anything other than 0, (meaning it must be infinity),
        //then that means that we have reached the part of the adjacency matrix that is empty,
        //and there is no reason to continue iterating through it
        //an equivalent way of doing this is replacing connections[i][i] != 0 with
        //i == City.cityCount
        for (int i = 0; i < MAX_CITIES;i++){
            if (connections[i][i] != 0)
                break;
            for (int j = 0; j < MAX_CITIES; j++){
                //if a connection exists, and if its not to the same city
                if (connections[i][j] != 0 && connections[i][j] != Double.POSITIVE_INFINITY){
                    City from = cities.get(i);
                    City to = cities.get(j);
                    System.out.println(String.format("%-40s%-20f",from.getName() + "  -->  " + to.getName(),distance(from,to)));
                }
            }
        }
                
                
        }
    
    //loads all connections from a file with the given fileName
    public void loadAllConnections(String filename){
        try{
            fileReader = new Scanner(new File(filename));
            while (fileReader.hasNext()){
                String line = fileReader.nextLine();
                String toCityName = line.substring(0,line.indexOf(","));
                String fromCityName = line.substring(line.indexOf(",") + 1, line.length());
                
                addConnection(toCityName,fromCityName);
            }
        }
        catch(FileNotFoundException f){
            System.out.println("File with the name " + filename + " was not found.\n");
        }
    }
    
    //loads all cities from a file with the given filename
    public void loadAllCities(String filename){
        try{
            fileReader = new Scanner(new File(filename));
            while (fileReader.hasNext()){
                String city = fileReader.nextLine();
                addCity(city);
            }
        }
        catch(FileNotFoundException f){
            System.out.println("File with the name " + filename + " was not found.\n");
        }
        System.out.println("");
    }
    
    
    
    //uses the floyd warshall algorithm to find the shortest path
    //returns the answer as a string, in the format
    // city1Name --> city2Name --> ... --> destCityName : pathLength
    //if the two cities do not exist, print "Invalid Cities"
    //if the cities are not connected, print out that they are not connected
    //and there is no shortest path
    public String shortestPath(String cityFrom, String cityTo){
        
        City from = findCity(cityFrom);
        City to = findCity(cityTo);
        
        if (from == null || to == null){
            return "Invalid Cities";
        }
        
        for (int i = 0; i < MAX_CITIES; i++){
            for (int j = 0; j < MAX_CITIES; j++){
                dist[i][j] = connections[i][j];
                next[i][j] = i;
            }
        }
          
        for (int k = 0; k < MAX_CITIES; k++){
            for (int i = 0; i < MAX_CITIES; i++){
                for (int j = 0; j < MAX_CITIES; j++){
                    if (dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[k][j];
                    }
                }
            }
        }

        int u = from.getIndexPos();
        int v = to.getIndexPos();
        
        ArrayList<Integer> path = new ArrayList<>();
        while (u != v){
            path.add(v);
            v = next[u][v];
        }
        path.add(u);
        
        //right now , the arraylist path contains the indeces of the cities in the path, but in reverse order
        //in the loop below, we concatenate the name of the corresponding city, but in reverse order,
        //to produce the path
        String ans = "";
        for (int i = path.size()-1; i >= 0; i--){
            ans += cities.get(path.get(i)).getName();
            if (i != 0){
                ans += " --> ";
            }
        }
        
        
        //finally, concatenate to the answer the length of this path
        ans += " : " + dist[from.getIndexPos()][to.getIndexPos()];
        
        //if the distance between these two cities is infinity, there is no connection.
        if (dist[from.getIndexPos()][to.getIndexPos()] == Double.POSITIVE_INFINITY)
            return "These two cities are not connected - there is no shortest path.";
        return ans;
        
    }
}
