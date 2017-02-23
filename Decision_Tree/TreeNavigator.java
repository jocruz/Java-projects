
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;

public class TreeNavigator
{
    private TreeNode root;
    private TreeNode cursor;
    boolean foundParent; // to use in the findParent and cursorToParent methods

    /**
     * Constructor to create a <code>TreeNavigator</code> <br>
     *
     * <dt>Postconditions:<dd>
     * 	A <code>TreeNavigator</code> has been created with a default root node.
     * 	The cursor points to the root.
     */
    public TreeNavigator()
    {
        cursor = root = new TreeNode();
    }

    /**
     * Creates a decision tree from a file.
     * @param treeFile
     * 	the name of the file`
     * @return
     * 	an instance of the <code>TreeNavigator</code> class with a tree
     * 	constructed from the specifications in the file.
     */


    public static TreeNavigator buildTree(String treeFile)
    {
        File theFile = new File(treeFile); //Creates new file that will
        //take the String treeFile as an argument

        Scanner sc = new Scanner(treeFile);
        try {
            while (sc.hasNext()) {
                String currentLine = sc.nextLine();
                String[] partsOfLine = currentLine.split(";"); //separate and put in an array
                String[] locationArray = partsOfLine[0].split("-"); //0-0
                TreeNode current = new TreeNode(); //will create appropriate node
                String[] keywords;

                for (int i = 0; i < locationArray.length; i++) {
                    boolean isFinalLocation = (i == locationArray.length - 1);
                    //The "isFinalLocation" is thee end of the Array. "=="

                    if (isFinalLocation && i == 0) //the root
                    {
                        if (partsOfLine[2].equals("nonleaf")) {
                            keywords = partsOfLine[1].split(","); //if it's a non leaf, what ever the data is
                            //drop it all in keywords and split it by ","
                        }
                    }

                    else{
                        keywords = new String [1];
                        keywords[0] = partsOfLine[1];
                    }
                    current.setKeywords(keywords);


                }

            }

        }

        catch(FileNotFoundException e){

        }


    }

    /**
     *
     *public String getPath(String text)
     * ○ Gets the current path of the cursor. For example, if cursor referred to a TreeNode at position “Garfield” 
     * in the example below, this method should return “NOT red, NOT coyote,wolf, IS cat, IS orange, DECISION: Garfield”
     * ○ Note the comma above: This is how you can show multiple keywords.
     *
     * Find the path to the current leaf from the root of the decision tree.
     * @return
     * 	a string showing the path to the current leaf from the root
     */


    public String getPath()
    {

    }

    /**
     * Move the cursor to the root node of the decision tree.
     *
     * <dt>Postconditions:<dd>
     * 	The cursor is at the root and its contents are printed.
     */
    public void resetCursor(){
        cursor = root;
        System.out.println("Cursor moved. Cursor is now at root.");
        String keyWordsToPrint = "";
        for (int i = 0; i < cursor.getKeywords().length; i++){

            keyWordsToPrint += cursor.getKeywords()[i];

            if (i != cursor.getKeywords().length-1){
                keyWordsToPrint += ", ";
            }

            }
           System.out.println("Current node keywords: " + keyWordsToPrint);

    }


    /**
     * Move the cursor to the root node of the decision tree without printing.
     *
     * <dt>Postconditions:<dd>
     * 	The cursor is at the root.
     */

    public void silentMoveToRoot(){
        cursor = root;
    }


    /**
     * Moves the cursor to the left child.
     *
     * @throws Exception
     * 	indicates that there is no left child
     *
     * <dt>Postconditions:<dd>
     *	The cursor now points to the left child and its contents are printed.
     *
     */
    public void cursorLeft() throws Exception
    {
        if (cursor.getLeft() == null){
            throw new Exception("There is no left child");
        }

        cursor = cursor.getLeft();
        String cursorLocation;

        if (cursor == root){
            cursorLocation = "Root, ";
        }
        else if (cursor.isLeaf()){
            cursorLocation = "leaf, ";
        }

        else{
            cursorLocation = " internal node, ";
        }

        String cursorContents;

        if (cursor.isLeaf()){
            cursorContents = "messege is '" + cursor.toString() + "'.";
        }

        else {
            cursorContents = cursor.toString();
        }

        System.out.println("Cursor moved. Cursor is at " + cursorLocation + cursorContents);
    }


    public void cursorRight () throws Exception
    {
        if(cursor.getLeft() == null){
            System.out.println("There are no right child.");
        }

        cursor = cursor.getRight();
        String cursorLocation;

        if(cursor == root){
            cursorLocation = "Root, ";
        }
        else if (cursor.isLeaf()){
            cursorLocation = "Leaf, ";
        }

        else{
            cursorLocation = " internal node, ";
        }

        String cursorContents = "";

        if (cursor.isLeaf()){
            cursorContents = "messege is '" + cursor.toString() + "'.";
        }

        else {
            cursorContents = cursor.toString();
        }

        System.out.println("Cursor moved to " + cursorLocation + cursorContents);

    }


    }
    /**
     * Accessor method to get the cursor node.
     * @return
     * 	the <code>cursor</code> of the decision tree
     *
     * <dt>Preconditions:<dd>
     * 	<code>cursor</code> is not null
     *
     * <dt>Postconditions:<dd>
     * 	<code>cursor</code> has been returned.
     */
    public TreeNode getCursor()
    {
        return cursor;
    }

    /**
     * Change the keywords of the node <code>cursor</code> is pointing to.
     * @param text
     * 	the new keywords for the cursor
     */
    public void editCursor(String text)
    {
        String [] keywords = text.split(",");
        cursor.setKeywords(keywords);
    }

    /**
     * Move the <code>cursor</code> to its parent node
     *
     * <dt>Postconditions:<dd>
     * 	<code>cursor</code> now points to the parent of the previous cursor.
     */
    public void cursorToParent() // Extra credit (cannot use parent reference
    // in TreeNode class)
    {
        foundParent = false;
        findParent = (root);
    }

    /**
     * Recursive helper method to find the parent of a node in a decision tree
     * @param current
     * 	The node to find the parent of
     * @return
     * 	the parent of <code>current</code>
     */
    private TreeNode findParent(TreeNode current)
    {
        if (cursor == root){
            return root; //has no parent; base case
        }

        if(current.getLeft() == cursor || current.getRight() == cursor){
            foundParent = true;
            cursor = current;
        }

        if(current.getLeft() != null && !foundParent){
            findParent(current.getLeft());
        }

    }
}




