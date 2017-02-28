
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Scanner;

public class SigmaAirDriver {
    
    //stdin reads from user, sigmaAir is our SigmaAir object
    static Scanner stdin;
    static SigmaAir sigmaAir;
    
    //initialize sigmaAir, and load it from the .obj file (if it exists)
    public static void initSigmaAir(){
        try {
            FileInputStream file = new FileInputStream("sigma_air.obj");
            ObjectInputStream fin = new ObjectInputStream(file);
            sigmaAir = (SigmaAir)fin.readObject();
            fin.close();
            System.out.println("sigma_air.obj succesfully loaded into sigmaAir.");
	} 
        catch(ClassNotFoundException | IOException c){
            //If the exception thrown is anything other than a FileNotFoundException,
            //print the stackTrace (we shouldn't be experiencing these)
            if (!c.getClass().getName().equals("java.io.FileNotFoundException")){
                c.printStackTrace();
            }
            System.out.println("sigma_air.obj not found.");
            System.out.println("Creating new SigmaAir...");
            sigmaAir = new SigmaAir();
        }
    }
    
    
    //similar to my previous implementation of readUserOption(),
    //reads in the users choice, and uses a switch statement to call
    //the appropriate method
    //if the user chooses E, a submenu will appear and the user's input
    //will be read from that menu until they specifically choose to quit that menu,
    //which will bring them back to this main menu.
    public static boolean readUserOption(){
        System.out.print("Enter your choice: ");
        String input = stdin.nextLine();
        System.out.println("");
        input = input.toUpperCase();
        switch(input){
            case "A": addCity(); break;
            case "B": addConnection(); break;
            case "C": loadCities(); break;
            case "D": loadConnections(); break;
            case "E": printCitiesMenu(); 
            while (readSubMenuOption())
                printCitiesMenu();
            
            break;
            case "F": printConnections(); break;
            case "G": removeConnection(); break;
            case "H": findShortestPath(); break;
                
            case "Q": quit();
            default: System.out.println("Option " + input + " not recognized. Please try again.\n"); 
        }
        return true;
    }
    
    //display the menu
    public static void displayMenu(){
        System.out.println(
                "A) Add A City" + '\n' +
                "B) Add A Connection"  + '\n' +
                "C) Load Cities" + '\n' +
                "D) load Connections" + '\n' +
                "E) Print Cities" + '\n' +
                "F) Print Connections" + '\n' +
                "G) Remove Connection" + '\n' +
                "H) Find Shortest Path" + '\n' +
                "Q) Quit" + '\n'    
        );
    }
    
    
    //construct the Scanner
    //initialize sigmaAir
    //displayMenu
    //read the users input until they quit
    public static void main(String[]args){
        stdin = new Scanner(System.in);
        initSigmaAir();
        
        displayMenu();
        while (readUserOption()){
            displayMenu();
        }
        
    }

    //prompt user for city name and call sigmaAir's addCity method
    private static void addCity() {
        System.out.print("Enter the name of the city:");
        String cityName = stdin.nextLine();
        System.out.println("");

        sigmaAir.addCity(cityName);
        System.out.println("");
                
                
    }
 
    //prompt user for city name and call sigmaAir's addConnection method
    private static void addConnection() {
        System.out.print("Enter source city:");
        String srcName = stdin.nextLine();
        System.out.println("");
        System.out.print("Enter destination city:");
        String destName = stdin.nextLine();
        System.out.println("");
        
        sigmaAir.addConnection(srcName, destName);
        System.out.println("");
        
    }

    //prompt user for name of file, and use sigmaAir's loadCities method
    private static void loadCities() {
        System.out.print("Enter name of file to load cities from: ");
        String fileName = stdin.nextLine();
        System.out.println("");
        sigmaAir.loadAllCities(fileName);
        System.out.println("");
    }

    //prompt user for name of file, and use sigmaAir's loadConnections method
    private static void loadConnections() {
        System.out.print("Enter name of file to load connections from: ");
        String fileName = stdin.nextLine();
        System.out.println("");
        sigmaAir.loadAllConnections(fileName);
        System.out.println("");
        
    }

    //print the submenu
    private static void printCitiesMenu() {
        System.out.println(
                "EA) Sort by City Name" + '\n' +
                "EB) Sort by Latitude"  + '\n' +
                "EC) Sort by Longitude" + '\n' +
                "Q) Quit" + '\n'    
        );
            
    }
    
    //read the users choice for the submenu
    public static boolean readSubMenuOption(){
        System.out.print("Enter your choice: ");
        String input = stdin.nextLine();
        System.out.println("");
        input = input.toUpperCase();
        switch(input){
            case "EA": printCities(new NameComparator()); break;
            case "EB": printCities(new LatComparator()); break;
            case "EC": printCities(new LngComparator()); break;
            case "Q": return false;
            default: System.out.println("Option " + input + " not recognized. Please try again."); 
        }
        return true;
    }
    
    //print a list of the cities sorted by the given Comparator
    private static void printCities(Comparator comp){
        sigmaAir.printAllCities(comp);
        System.out.println("");
    }

    //print a list of the connections
    private static void printConnections() {
        sigmaAir.printAllConnections();
        System.out.println("");
    }

    //prompt the user for two city names, and remove the connection between them if it exists.
    //otherwise, tell the user they've inputted invalid city names.
    private static void removeConnection() {
        System.out.println("Enter source city:");
        String srcName = stdin.nextLine();
        System.out.println("Enter destination city:");
        String destName = stdin.nextLine();
        System.out.println("");
        
        sigmaAir.removeConnection(srcName, destName);
    }

    //prompt the user for two city names and call sigmaAir's findShortestPath() method.
    private static void findShortestPath() {
        System.out.println("Enter source city:");
        String srcName = stdin.nextLine();
        System.out.println("Enter destination city:");
        String destName = stdin.nextLine();
        
        System.out.println("");
        String path = sigmaAir.shortestPath(srcName, destName);
        System.out.println(path + "\n");
        
    }
    
    //quit the program and save sigmaAir to a file, sigma_air.obj
    private static void quit(){
                try {
            FileOutputStream file = new FileOutputStream("sigma_air.obj");
            ObjectOutputStream fout = new ObjectOutputStream(file);
            fout.writeObject(sigmaAir);
            fout.close();
            System.out.println("SigmaAir is being saved into \"sigma_air.obj\"."
                    + "\nProgram terminating normally...");
            System.exit(1);
            
        } 
        catch(IOException io){
            io.printStackTrace();
            System.out.println("SigmaAir not saved successfully. Delete \"sigma_air.obj\" for best results. Program terminating...");
            System.exit(0);
        }
        
    }

}
