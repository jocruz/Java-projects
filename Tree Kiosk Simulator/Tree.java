
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
2. Write a Tree class that should contain a reference to the root of the tree.
Implement the following methods:
* public Tree – Constructor for the Tree, you may include a Constructor
with parameters
* public TreeNode findNode(String name) – returns a reference to node if
it exists in the tree, null otherwise
* public boolean addNode(String name, String selection, String message,
String parentName) – adds a new node under the node with the given parent
label name; returns true of a node is added, false otherwise
* public void printMenu(String parentInfo) – prints the combination of the
whole selection menu; should include item selection, and price
* public void beginSession() – initiates ordering service; starting from the
root of the tree and prompts users for inputs; choose the branch of the tree that
the user is interested in. Print the order and the price when a leaf is reached.
HINT: When printing the menu, use the argument to store the selection of all
previous nodes. When you reach a leaf node, print the price along with all the
previous information.
*/
public class Tree {
    
    //root represents the root of the tree
    public TreeNode root;
    //leaves stores all of the leaves of the tree.
    public TreeNode[] leaves = new TreeNode[1000];
    //index is a helper variable which denotes the actual amount of leaves filled into the leaves array
    //used in method findLeaves()
    public int index = 0;
    //leaves should only be calculated once for a given tree, so this boolean flag ensures that
    public boolean leavesFound = false;
    
    
    
    //Constructor for the Tree, accepts the name of the file from which to read
    //throws a filenotFoundException, in case an incorrect file name is passed in.
    public Tree(String fileName) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader inStream = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(inStream);
        
        try {
            // the first few lines refer to the root, we will parse them outside of the loop to make things simpler
            String data = reader.readLine();
            root = new TreeNode();
            root.setName(data);
            root.setSelection(reader.readLine());
            root.setMessage(reader.readLine());
            
            
            //as long as there is still content to be read
            while ((data = reader.readLine()) != null){
                //the way I designed the code, the string data contains the name of node and how many children it has
                // thus, the last character represents that amount, so we extract it.
                int numChildren = data.charAt(data.length() - 1) - '0';
                
                //for as many children as this node has, add appropriate nodes, by parsing the file
                for (int i = 0; i < numChildren; i++){
                    String name = reader.readLine();
                    String selection = reader.readLine();
                    String message = reader.readLine();
                    
                    //the name of the parent is also found in the string data, and can be extracted using substring
                    String parentName = data.substring(0,data.length() - 2);
                    
                    //add the node and store the boolean value in val.
                    boolean val = addNode(name, selection, message, parentName);

                    //if addNode returns false, that means that an incorrectly formatted input file has been given, and program will terminate.
                    if (!val){
                        System.out.println("INCORRECTLY FORMATTED INPUT FILE. Program terminating...");
                        System.exit(1);      
                    }
                }
            }

            
            //catch the input output exception
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //prints a "preorder" traversal of the tree (not quite because of the middle nodes)
    //not requisite for the assignment, used during testing.
    public static void printPreOrder(TreeNode root){
        if (root.getLeft() != null){
            printPreOrder(root.getLeft());
        }
        
        if (root.getMiddle() != null){
            printPreOrder(root.getMiddle());
        }
        System.out.println(root.getSelection());
        
        if (root.getRight() != null){
            printPreOrder(root.getRight());
        }
        
    }
    
    //findNode calls a recursive helper method findNode(name,root) which recursively searches for the node with the given name.
    public TreeNode findNode(String name){
        return findNode(name,root);
    }
    
    //if the given name is not equal to the name of any of the nodes in the subtree of the root, then the method will return null.
    //So the method checks every subtree of the root, the left, middle, and right, and returns whichever is not null. In the instance 
    //that there are two nodes of the same name, the one that occurs leftmost will be returned.
    public TreeNode findNode(String name, TreeNode root){
       if (root.getLeft() != null){
           TreeNode left = findNode(name,root.getLeft());
           if (left != null)
               return left;
       }
       if (root.getMiddle() != null){
           TreeNode mid =  findNode(name,root.getMiddle());
           if (mid != null)
               return mid;
       }
       if (root.getRight() != null){
           TreeNode right =  findNode(name,root.getRight());
           if (right != null)
               return right;
       }
       else if (root != null){
           if (root.getName().equals(name))
               return root;
           else return null;
       }
       return null;
    }
    
    
    //adds a node with the following parameters as a child of the node with the give parentName
    public boolean addNode(String name, String selection, String message, String parentName){
        TreeNode node = new TreeNode();
        node.setName(name);
        node.setSelection(selection);
        node.setMessage(message);
        
        //to make life easier, we find the parent by using findNode.
        TreeNode parent = findNode(parentName);
        //set the back reference of the node to the parent, so that we can keep track of selections later.
        node.setBack(parent);
        
        //to avoid any nasty null pointer exceptions. if parent is null, then that means that an incorrectly formatted tree was input.
        //checks first the left, then the middle, then the right, and sets the child node to the first available reference. if all references
        // are not null, then this also represents an incorrectly formatted tree, and the method will return false.
        if (parent != null){
            if (parent.getLeft() == null){
                parent.setLeft(node); 
                //System.out.println(name + " added to left of " + parentName); 
                return true;
            }
            else if (parent.getMiddle() == null){
                parent.setMiddle(node); 
                //System.out.println(name + " added to middle of " + parentName); 
                return true;
            }
            else if (parent.getRight() == null){
                parent.setRight(node); 
                //System.out.println(name + " added to right of " + parentName);
                return true;
            }
            else return false;
        }
        else return false;
    }
    
    //prints the menu
    public void printMenu(String parentInfo){
        //first we print the static part of the menu that is the same for every tree
        System.out.println("\nMenu:");
        System.out.println(String.format("%-30s%-60s", "Dining Price", "Selection")); 
        System.out.println(String.format("%-110s", "============================================================================================"));
        
        //I print the menu by calculating all of the leaves, and then going back up until the node below the root, and 
        //I add on the selection to a auxilliary String variable line, and print line once when done.
        //If the leaves havent been calculated yet, find them.
        if (!leavesFound)
            findLeaves();
        
        
        //for as many leaves as there are
        for (int i = 0; i < index; i++){
            // we dont want to modify whats in the leaves array, so create a variable named back which will change as we add onto line.
            TreeNode back = leaves[i];
            String line = "";
            
            //as long as the parent of the parent of back is not null (as long as back's parent is not root)
            // add on the current Nodes selection to line, and set back equal to its parent.
            while (back.getBack().getBack() != null){
                line = back.getSelection() +(line.isEmpty()?"":", ") +  line;
                
                back = back.getBack();
            }
            //print the line in a formatted fashion.
            System.out.println(String.format("%-30s%s",back.getSelection(), line));
            System.out.println(leaves[i].getMessage());
        }
        
        System.out.println("\n");
        
        
    }
    
    //calls helper recursive method findLeaves
    public void findLeaves(){
        findLeaves(root);
        leavesFound = true;
    }
    
    //iterates through every node in the tree, and if the node doesn;t have any children, (isLeaf() is true),
    // then it adds it to the array of leaves. This method is only ever called once per given tree.
    public void findLeaves(TreeNode node){
        if (node.isLeaf())
            leaves[index++] = node;
        else {
            if (node.getLeft() != null)
                findLeaves(node.getLeft());
            if (node.getMiddle() != null)
                findLeaves(node.getMiddle());
            if (node.getRight() != null)
                findLeaves(node.getRight());
        }
    }
    
    
    
    //begins the session
    public void beginSession(){
        Scanner input = new Scanner(System.in);
        TreeNode current = root;
        String totalSelection = "";
        //we want to print the total selection at the end, so we will add on to a string variable called totalSelection.
        //totalSelection will contain an unformatted representation of the selection, it will consist of the users selections
        //seperated by "@" signs, and because the amount of levels that we have is variable, at the end of the method
        //I split totalSelection into an array (delimited by "@") and use a loop to print it in a formatted fashion.
        
        
        
        //do while the current Node is not a leaf. So we go down the tree and process user input, until we get to a leaf, then
        // we print the users totalSelection.
        do {
            //Print out the menu message (prompt asking user whatver they want)
            System.out.println(current.getMessage());
            
            //If a child exists, display it as a menu option.
            if (current.getLeft() != null){
                System.out.println("1 " + current.getLeft().getSelection());
            }
            if (current.getMiddle() != null){
                System.out.println("2 " + current.getMiddle().getSelection());
            }
            if (current.getRight() != null){
                System.out.println("3 " + current.getRight().getSelection());
            }
            //we can also go back and quit at any time.
            //if the user attempts to go back before any selections have been made, he will not be allowed to do so.
            System.out.println("B Back");
            System.out.println("0 Exit Session\n");
            
            //put in a while loop to allow for re-reading user input in case of erroneous or invald input
            while(true){
                String userSelection = input.nextLine();
                userSelection = userSelection.toUpperCase();
                
                //if the user input anything other of length 1, it cannot be a proper menu choice.
                if (userSelection.length() > 1){
                    System.out.println("Invalid Selection, please try again.");
                    continue;
                }
                
                //if user input 1, and the left child exists, add on to the totalSelection and go down the tree.
                else if (userSelection.charAt(0) == '1' && current.getLeft() != null){
                    totalSelection += current.getLeft().getSelection() + "@";
                    current = current.getLeft();
                    break;
                }
                //if user input 2, and the middle child exists, add on to the totalSelection and go down the tree.
                else if (userSelection.charAt(0) == '2' && current.getMiddle() != null){
                    totalSelection += current.getMiddle().getSelection() + "@";
                    current = current.getMiddle();
                    break;
                }
                //if user input 3, and the right child exists, add on to the totalSelection and go down the tree.
                else if (userSelection.charAt(0) == '3' && current.getRight() != null){
                    totalSelection += current.getRight().getSelection() + "@";
                    current = current.getRight();
                    break;
                }
                //if user input B, and we're not at the root, go to the previous node by setting the current node
                //equal to its back reference( the parent Node), and appropriately modify the totalSelection string.
                //If we have made only one selection, then we must use different code to set back the totalSelection variable,
                //and thus i put an if statement that checks to see if the amount of "@" is greater than 1.
                else if (userSelection.charAt(0) == 'B' && current.getBack() != null){
                    if (occurencesOf('@',totalSelection) > 1){
                    totalSelection = totalSelection.substring(0, totalSelection.lastIndexOf("@",totalSelection.length() - 2) + 1);
                    }
                    else totalSelection = "";
                    current = current.getBack();
                    break;
                }
                //if user inputs 0, exit.
                else if (userSelection.charAt(0) == '0'){
                    System.out.println("Exiting Session");
                    System.exit(1);
                }
                // if user inputs B and he cannot go back, print out to them that they cant do that.
                // otherwise, it is invalid input, and the loop will execute again asking for new input.
                else {
                    if (userSelection.charAt(0) == 'B'){
                        System.out.println("You have made no selections, cannot go back.");
                    }
                    
                    else {
                        System.out.println("You have entered an invalid option, please try again.");
                    }
                }
            }
            
        } while (!current.isLeaf());
        
        
        
        //split totalSelection by "@" character and print out the selections in a formatted manner.
        //This way the last selection doesnt have a comma after it.
        String[] vals = totalSelection.split("@");
        System.out.print("The order at " + vals[0] +": "); 
        for (int i = 1; i < vals.length; i++){
            System.out.print(vals[i]);
            if (i != vals.length - 1)
                System.out.print(", ");
        }
        System.out.println(" has been sent to the kitchen.");
        System.out.println("The total amount is: " + current.getMessage() + '\n');

    }
    
    
    //auxilliary helper method counts occurences of a character in a given string.
    public int occurencesOf(char ch, String string){
        int sum = 0;
        for (int i = 0 ; i < string.length(); i++){
            if (string.charAt(i) == ch)
                sum++;
        }
        return sum;
    }
    
    

}
