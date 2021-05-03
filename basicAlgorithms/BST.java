class Node {
    int data;
    Node left;
    Node right;
    Node childOf;

    public Node(int data, Node left, Node right, Node parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.childOf = parent;
    }

    public int getValue() {
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

    public boolean isRoot(Node node) {
        if (node.childOf == null)
            return true;
        else
            return false;
    }
}

public class BST {
    Node root;

    public BST(int data) {
        root = new Node(data, null, null, root);
    }

    public Node getRoot() {
        return root;
    }

    private Node createNode(int data) {
        Node node = new Node(data, null, null, null);
        return node;
    }

    public void addElement(int data) throws IllegalArgumentException {
        Node newNode = createNode(data);
        Node parent = null;
        Node tempRoot = root;
        while (tempRoot != null) {
            parent = tempRoot;
            if (data < tempRoot.getValue())
                tempRoot = tempRoot.getLeft();
            else
                tempRoot = tempRoot.getRight();
        }
        if(parent == null)
        {
                root = new Node(data, null, null, null);  // if root node is null 
                root.setLeft(null);
                root.setRight(null);
                return ;
        }
        if (data < parent.getValue()) {
            newNode.setParent(parent);
            parent.setLeft(newNode);
        } else if (data > parent.getValue()) {
            newNode.setParent(parent);
            parent.setRight(newNode);
        } else
            throw new IllegalArgumentException("Binary Tree cannot have duplicate value");
    }

    void inOrderTraversal(Node root) {
        if (root == null)
            return;
        else {
	    if(root.getLeft() != null)
            inOrderTraversal(root.getLeft());

            System.out.println(root.getValue());
	    if(root.getRight() !=null)
            inOrderTraversal(root.getRight());
	    // these ifs will reduce the function call to half for a complete binary tree
        }
    }

    // check Tree.java for pre and post order as NLR , LRN

    int findSmallestElement(Node root) {
        if (root == null || root.getLeft() == null)
            return root.getValue();
        else
            return findSmallestElement(root.getLeft());
    }

    int findLargestElement(Node root) {
        if (root == null || root.getRight() == null)
            return root.getValue();
        else
            return findLargestElement(root.getRight());
    }

    int totalNodes(Node root) {
        if (root == null)
            return 0;
        else
            return totalNodes(root.getLeft()) + totalNodes(root.getRight()) + 1;
    }

    int totalExternalNodes(Node root) {
        if (root == null)
            return 0;
        if (root.getLeft() == null && root.getRight() == null)
            return 1;
        else
            return totalExternalNodes(root.getLeft()) + totalExternalNodes(root.getRight());

    }

    Node search(Node root, int value) throws IllegalArgumentException {
        if (root == null)
            throw new IllegalArgumentException("no node found");
        if (root.getValue() == value)
            return root;
        else {
            if (root.getValue() > value)
                return search(root.getLeft(), value);
            else
                return search(root.getRight(), value);
        }
    }

    int totalInternalNodes(Node root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null))
            return 0;
        else
            return totalInternalNodes(root.getLeft()) + totalInternalNodes(root.getRight()) + 1;
    }

    static Node leftMostNode(Node node)
    {
    	while(node != null && node.left != null)
		node = node.left;
	return node;
    }
	
    static Node rightMostNode(Node node)
    {
    	while(node != null  && node.right != null)
		node = node.right;
	return node;
    }
    

    Node getInOrderSuccessor(Node root)
    {
     	//case 1 : if right child of node is not null
    	if(root.right != null)
	{
		return leftMostNode(root.right);
	}
    }

    void   deleteNode(Node root, int val) throws IllegalArgumentException
    {
        Node tempNode = search(root, val);
	if(tempNode == null)
		return;
        if(tempNode.getLeft() == null && tempNode.getRight() == null)
            {
                Node parent = tempNode.getParent();
                if(parent == null)
                        root = null;
                else if(parent.getLeft().getValue() == tempNode.getValue())
                    parent.setLeft(null);
                else 
                    parent.setRight(null);
            }
        else if(tempNode.getRight() != null && tempNode.getLeft() != null)
        {
                Node succ = getInOrderSucc(tempNode);
		int temp = succ.getValue();
                tempNode.setData(succ.getValue());
		deleteNode(tempNode.left, temp);
		deleteNode(tempNode.right, temp);
        }
        else if(tempNode.getRight() != null || tempNode.getLeft() != null)
        {
            if(tempNode.getLeft() == null)
            {
                Node tempRightNode = tempNode.getRight();
                tempNode.setData(tempRightNode.getValue());
                if(tempRightNode.getRight() != null)
                {
                    tempRightNode.getRight().setParent(tempNode);
                    tempNode.setRight(tempRightNode.getRight());
                }
                else if(tempRightNode.getLeft() != null)
                {
                    tempRightNode.getLeft().setParent(tempNode);
                    tempNode.setRight(tempRightNode.getLeft());
                }
                else 
                {
                        deleteNode(tempRightNode, tempRightNode.getValue());
                }

            }
            else 
            {
                Node tempLeftNode = tempNode.getLeft();
                tempNode.setData(tempLeftNode.getValue());
                if(tempLeftNode.getRight() != null)
                {
                    tempLeftNode.getRight().setParent(tempNode);
                    tempNode.setLeft(tempLeftNode.getRight());
                }
                if(tempLeftNode.getLeft() != null)
                {
                    tempLeftNode.getLeft().setParent(tempNode);
                    tempNode.setLeft(tempLeftNode.getLeft());
                }
                if(tempLeftNode.getRight() == null && tempLeftNode.getRight() == null)
                {
                    tempLeftNode.getParent().setLeft(null);
                    deleteNode(tempLeftNode, tempLeftNode.getValue());
                }
            }
        }
    }

    int height(Node root)
    {
        if(root == null)
            return -1; // assuming height of binary tree start from zero 
        else 
        {
            int leftHeight = height(root.getLeft());
            int rightHeight = height(root.getRight());
            if(leftHeight > rightHeight)
                return leftHeight+1;
            else
                return  rightHeight+1;

        }
    }

    void mirrorImage(Node root)
    {
        if(root != null)
        {
            mirrorImage(root.getLeft());
            mirrorImage(root.getRight());
            Node temp;
            temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
    }

    int depth(Node node)
    {
        if(node.getParent() == null)
           return  0;
        else
            return  depth(node.getParent()) + 1;
    }

    //delete node will come here 

    public static void main(String[] args) {
        BST tree = new BST(10);
        Node root = tree.getRoot();
        tree.addElement(18);
        tree.addElement(48);
        tree.addElement(9);
        tree.addElement(12);
        tree.addElement(110);
        tree.addElement(0);
        tree.addElement(78);
        tree.addElement(76);
        tree.addElement(74);
        tree.addElement(112);
        tree.inOrderTraversal(root);
        tree.deleteNode(root, 78);
        tree.inOrderTraversal(root);


        // inorder traversal gives the values in sorted order 
        // so to check if  mirror image is correct or not 
        // implement inOrderTraversal before and after mirroring tree  
        // if result is increasing sorted list is first and decreasing sorted in leading then 
        // it is justification for this.
    }
}
