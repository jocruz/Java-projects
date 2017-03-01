/*
3. Write a Kiosk class that contains a main method and the following menu
options:
* (L) – Load the contents of a tree from a file. You should create a new
Tree.
* (P) – Prints the menu in a neat tabular format.
* (S) – Starts a service session. Ask for the user's order, and print the
order at the end.
* (Q) – Terminates the program.
*/

import java.io.FileNotFoundException;
import java.util.Scanner;
public class Kiosk {
    
    //static variables representing the Scanner, the tree, and whether the tree has been loaded or not.
    static Scanner stdin;
    static Tree tree;
    static boolean treeLoaded = false;
    
    //Reads the user input and executes the appropriate code.
    //returns true as long as user wants to continue with the program.
    //would return false when the user wants to quit, but the user can just quit instead,
    //so the fact that this returns a boolean is unncessary.
    //however, this is how i did it.
    public static boolean readUserOption(){
        System.out.println("Enter your choice: ");
        String input = stdin.next();
        input = input.toUpperCase();
        switch(input){
            case "L": loadTree(); break;
            case "P": 
                if (treeLoaded)
                    printMenu(); 
                else System.out.println("The menu has not been loaded yet, please load a menu first.\n"); 
                break;
            case "S": 
                if (treeLoaded)
                    startService();
                else System.out.println("The menu has not been loaded yet, please load a menu first.\n"); 
                break;
            case "Q": quit(); break;
            default: System.out.println("Option " + input + " not recognized. Please try again."); 
        }
        return true;
    }
    
    //display the menu
    public static void displayMenu(){
        System.out.println(
                "L) Load a Tree" + '\n' +
                "P) Print Menu"  + '\n' +
                "S) Start Service" + '\n' +
                "Q) Quit" + '\n'    
        );
    }
    
    //asks the user for the name of the input file, and then loads a tree from that input file.
    //catches a FileNotFoundException if the input file is not found.
    public static void loadTree(){
        
        System.out.println("Enter the name of the file: ");
         String fileName = stdin.next();
       try {
            tree = new Tree(fileName);
            treeLoaded = true;

                    
        }
        catch(FileNotFoundException f){
            f.printStackTrace();
            System.out.println(fileName + " NOT FOUND.");
                    
            System.out.println("Try a different file please.");
        }
       
        System.out.println("Menu has been updated! \n");
    }
    
    //calls the Tree classes printMenu method.
    public static void printMenu(){
             tree.printMenu("");
    }
    
    //calls the Tree clasess beginSession() method.
    public static void startService(){
       tree.beginSession();
    }
    
    //quits
    public static void quit(){
        System.exit(1);
    }
    
    
    //main method
    //Creates a scanner
    //displays the menu
    //as long the user wants to continue with the program (doesnt quit),
    //keep asking for input 
    //display the menu each time.

    public static void main(String[]args){
        stdin = new Scanner(System.in);
       displayMenu();
       while(readUserOption()){
           displayMenu();
       };
        
        
        
        
       
        
    }
}
