class Node
{
    int  data;
    Node left;
    Node right;
    Node childOf;

    public Node(int  data, Node left, Node right, Node parent)
    {
        this.data = data;
        this.left = left;
        this.right = right;
        this.childOf = parent;
    }

    public int  getValue() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return childOf;
    }

    public void setParent(Node childOf) {
        this.childOf = childOf;
    }

    public boolean isRoot(Node node)
    {
        if (node.childOf == null)
            return true;
        else 
            return false;
    }
}
public class BST
{
    Node root;
    public BST(int  data)
    {
        root = new Node(data, null , null , root);
    }
    
    public Node getRoot()
    {
        return root;
    }

    private Node createRoot(int  data)
    {
        Node node = new Node(data , null, null, null);
        return node;
    }

    public void addElement(int  data) throws IllegalArgumentException
    {
        Node newNode = createRoot(data);
        Node parent = null;
        Node tempRoot = root;
        while(tempRoot != null)
        {
            parent = tempRoot;
            if(data < tempRoot.getValue())
                tempRoot  = tempRoot.getLeft();
            else 
                tempRoot  = tempRoot.getRight();
        }
        if(data < parent.getValue())
        {
            newNode.setParent(parent);
            parent.setLeft(newNode);
        }
        else if(data > parent.getValue())
        {
            newNode.setParent(parent);
            parent.setRight(newNode);
        }
        else 
            throw new IllegalArgumentException("Binary Tree cannot have duplicate value");
    }

    void midOrderTraversal(Node root)
    {
        if(root == null)
            return;
        else{
            midOrderTraversal(root.getLeft());
            System.out.println(root.getValue());
            midOrderTraversal(root.getRight());
        }
    }

    public static void main(String[] args) {
        BST tree = new BST(10);
        Node root = tree.getRoot();
        tree.addElement(18);
        tree.addElement(48);
        tree.addElement(9);
        tree.addElement(12);
        // tree.addElement(12);
        tree.midOrderTraversal(root);
    }
}