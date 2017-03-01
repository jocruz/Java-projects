/*
1. Write a TreeNode class that contains the following fields:
* name
* selection
* message
* left
* middle
* right
* public boolean isLeaf() – returns indicator whether this node is a leaf
*/
public class TreeNode {
    
    //instance variables
    //I added a reference to the TreeNode above this node, called back, in order to keep track of menu choices.
    private String name;
    private String selection;
    private String message;
    private TreeNode left;
    private TreeNode middle;
    private TreeNode right;
    private TreeNode back;

    


    
    //Checks to see if left middle and right TreeNode references are null. If they are, the node must be a leaf.
    public boolean isLeaf(){
        return (left == null && middle == null && right == null);
    }
    
    
    //GETTERS
    public String getName(){
        return name;
    }
    
    public TreeNode getBack() {
        return back;
    }
    
    public String getMessage(){
        return message;
    }
    
    public TreeNode getMiddle(){
        return middle;
    }
    
    public TreeNode getRight(){
        return right;
    }

    public String getSelection() {
        return selection;
    }
    
     public TreeNode getLeft(){
        return left;
    }
    
    
     
     
    //SETTERS
    public void setSelection(String selection) {
        this.selection = selection;
    }
   
    public void setLeft(TreeNode node){
        left = node;
    }
    public void setRight(TreeNode node){
        right = node;
    }
    public void setMiddle(TreeNode node){
        middle = node;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    public void setName(String value){
        name = value;
    }
    
    public void setBack(TreeNode back) {
        this.back = back;
    }
    
    
    

    
}
