class Node
{
        int key, height;
        Node left, right;

        Node(int d)
        {
                key = d;
                height = 1;
        }
}

public class AVLTree
{
        Node root;

        int height(Node n)
        {
                return n == null ? 0 : n.height;
        }

        int max(int a, int b)
        {
                return a > b ? a : b;
        }

        Node rightRotate(Node unbalanced)  // LL rotation case balance factor is > 1
        {
                Node left = unbalanced.left;
                Node rightChildOfLeft = left.right;

                //perform rotation 
                left.right = unbalanced;
                unbalanced.left = rightChildOfLeft;

                unbalanced.height = max(height(unbalanced.left, unbalanced.right)) + 1;
                //Now left node is balanced so
                Node balanced = left; 
                balanced.height = max(height(balanced.left, balanced.right));

                return balanced;
        }

        Node leftRotate(Node unbalanced) // RR rotation case balance factor is < -1
        {
                Node right = unbalanced.right;
                Node leftChildOfRight = right.left;

                // perform the rotation 

                right.left = unbalanced;
                unbalanced.right = leftChildOfRight;

                unbalanced.height = max(height(unbalanced.left, unbalanced.right));
                // right makes the tree balanced
                Node balanced = right;
                balanced.height = max(height(balanced.left, balanced.right));

                return unbalanced;
        }

        int getBalance(Node n)
        {
                n == null ? 0 : height(n.left) - height(n.right);
        }

        Node insert(Node root, int key)
        {
                if(root == null) // root may be of sub tree or whole tree
                        return new Node(key);
                if(key < root.key)
                        node.left = insert(root.left , key);
                else if(key > root.key)
                        node.right = insert(root.right, key);
                else 
                        return root;

                root.height = 1 + max(height(root.left) , height(root.right));

                int balance = getBalance(root);

                if(balance > 1 && key < root.left.key)
                        return rightRotate(root);
                if(balance < -1 && key > root.right.key)
                        return leftRotate(root);
                if(balance > 1 && key > root.left.key)
                {
                        root.left = leftRotate(root.left)
                                return rightRotate(root);
                }
                if(balance < -1 && key < root.right.key)
                {
                        root.right = rightRotate(node.right);
                        return leftRotate(root);
                }

                return node;
        }
}







