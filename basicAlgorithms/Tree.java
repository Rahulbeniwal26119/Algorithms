class Node {

        int key;
        Node parent;
        Node left, right;


        Node(int item, Node Pred) {
                key = item;
                left = right = null;
                parent = Pred;
        }


        boolean isRoot()
        {
                return parent == null;
        }


        void setLeft(Node newNode) {
                left = newNode;
        }

        void setRight(Node newNode) {
                right = newNode;
        }

        int getKey() {
                return key;
        }

        Node getLeft() {
                return left;
        }

        Node getRight() {
                return right;
        }

        Node setLeft(int key, Node Pred) {
                Node node = new Node(key, Pred);
                this.setLeft(node);
                return node;
        }

        Node setRight(int key, Node Pred) {
                Node node = new Node(key, Pred);
                this.setRight(node);
                return node;
        }

        Node getNode() {
                return this;
        }

        

        
}

public class Tree {
        Node root;

        Tree(int key) {
                root = new Node(key, null); // set pred to null
        }

        Tree() {
                root = null;
        }

        Node getRoot() {
                return root;
        }

        void LNR(Node root) throws NullPointerException {
                if (root == null)
                        return;
                LNR(root.getLeft());
                System.out.println(root.getKey());
                LNR(root.getRight());
        }

        void NLR(Node root) {
                if (root == null)
                        return;
                System.out.println(root.getKey());
                NLR(root.getLeft());
                NLR(root.getRight());
        }

        void LRN(Node root) {
                if (root == null)
                        return;
                LRN(root.getLeft());
                LRN(root.getRight());
                System.out.println(root.getKey());
        }

        int  height(Node root)
        {
               if(root == null)
                        return -1;
                else
                {
                        int leftHeight = height(root.getLeft());
                        int rightHeight = height(root.getRight());
                        if(leftHeight > rightHeight)
                                return leftHeight + 1;
                        else 
                                return  rightHeight + 1;
                }
                
        }

        int totalNodes(Node root)
        {
                if(root == null)
                        return 0;
                else 
                        return totalNodes(root.getLeft()) + totalNodes(root.getRight()) + 1;
        }

        int totalExternalNode(Node root)
        {
                if(root == null)
                        return 0;
                else if( root.getLeft() == null && root.getRight() == null)
                        return 1;
                else 
                        return totalExternalNode(root.getLeft()) + totalExternalNode(root.getRight());        
        }

        int totalNodes(Node root)
        {
                if(root == null)
                        return 0;
                else 
                        return totalNodes(root.getLeft()) + totalNodes(root.getRight()) + 1;
        }

        public static void main(String[] args) {
                Tree tree = new Tree(5);
                Node root = tree.getRoot();
                Node left = root.setLeft(10, root);
                Node right = root.setRight(11, root);
                Node left1 = left.setLeft(12, left);
                Node right1 = right.setRight(13, left);
                right1.setRight(16, right1);                                                                          

                System.out.println("In order");
                tree.LNR(root);
                System.out.println("Pre order");
                tree.NLR(root);
                System.out.println("Post order");
                tree.LRN(root);
                System.out.println("Height of Tree is " + tree.height(root) );
                System.out.println(left.isRoot());
                System.out.println(root.isRoot());
                System.out.println(tree.totalNodes(root));
                System.out.println(tree.totalExternalNode(root));
        }
}
