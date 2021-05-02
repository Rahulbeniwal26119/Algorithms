import java.util.Stack;

import org.graalvm.compiler.graph.spi.Canonicalizable.Unary;

class Node
{
    int data;
    Node left, right, parent;
    boolean color;

    Node(int data)
    {
        this.data = data;
        left = right = parent = null;
    }

}
public class RedBlack {
    final static int RED = 0;
    final static int  BLACK = 1;

    private Node root;

    void inOrderTraversal(Node root)
    {
        if(root == null)
            return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    Node BSTInsert(Node root, Node pt)
    {
        if(root == null)
            return pt;
        if(pt.data < root.data)
        {
            root.left = BSTInsert(root.left, pt);
            root.left.parent = root;
        }
        else if(pt.data > root.data)
        {
            root.right = BSTInsert(root.right, pt);
            root.right.parent = root;
        }

        return root;
    }

    int  height(Node root)
    {
        if(root == null)
            return 0;
        else 
        {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if(lheight > rheight)
                return (lheight + 1);
            else
                return  (rheight + 1);
        }
    }

    void LevelOrderTraversal(Node root)
    {
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty())
        {
            Node temp = stack.peek();
            System.out.println(temp.data);
            stack.pop();
            if(temp.left != null)
                stack.push(temp.left);
            if(temp.right != null)
                stack.push(temp.right);
        }   
    }

    void LevelOrderTraversal2(Node root)
    {
        int h = height(root);
        int i;
        for(i=1;  i<=h; i++)
        {
            printGivenLevel(root, i);
        }
    }

    void printGivenLevel(Node root, int level)
    {
        if(root == null)
            return;
        if(level == 1)
            System.out.print(root.data);
        else if(level > 1)
        {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right,level - 1);
        }
    }

    void rotateLeft(Node unbalanceNode)
    {
        Node right = unbalanceNode.right;
        Node leftChildOfRight = left.right;

        right.left = unbalanceNode;
        unbalanceNode.right = leftChildOfRight;
    }

    void rotateRight(Node unbalanceNode)
    {
        left = unbalanceNode.left;
        Node rightChildOfLeft = left.right;

        left.right = unbalanceNode;
        unbalanceNode.left = rightChildOfRight;
    }
}
