
public class TreeNode
{
    private String[] keywords;
    private TreeNode left;
    private TreeNode right;

    public String[] getKeywords(){
    return keywords;
}

    public void setKeywords(String[] Keywords){
        this.keywords = Keywords;
    }

    public TreeNode getLeft(){
        return left;
    }

    public void setLeft(TreeNode Left){
    this.left = Left;
}

    public TreeNode getRight(){
        return right;
    }

    public void setRight(TreeNode Right){
        this.right = Right;
    }

    public boolean isLeaf()
    {
        if (right == null && left == null)
            return true;

        return false;
    }



}
