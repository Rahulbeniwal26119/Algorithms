class Node {

        int key;
        Node left, right;

        Node(int item) {
                key = item;
                left = right = null;
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

        Node setLeft(int key) {
                Node node = new Node(key);
                this.setLeft(node);
                return node;
        }

        Node setRight(int key) {
                Node node = new Node(key);
                this.setRight(node);
                return node;
        }

        Node getNode() {
                return this;
        }
        int  height(Node root)
        {
               if(root == null)
                        return -1;
                else
                {
                        int leftHeight = height(root.getLeft());
                        System.out.println("LeftHeight "+ leftHeight);
                        int rightHeight = height(root.getRight());
                        System.out.println("rightHeight " + rightHeight);
                        if(leftHeight > rightHeight)
                                return leftHeight + 1;
                        else 
                                return  rightHeight + 1;
                }
                
        }
}

public class Tree {
        Node root;

        Tree(int key) {
                root = new Node(key);
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

        public static void main(String[] args) {
                Tree tree = new Tree(5);
                Node root = tree.getRoot();
                Node left = root.setLeft(10);
                Node right = root.setRight(11);
                Node left1 = left.setLeft(12);
                Node right1 = right.setRight(13);
                right1.setRight(16);                                                                          

                System.out.println("In order");
                tree.LNR(root);
                System.out.println("Pre order");
                tree.NLR(root);
                System.out.println("Post order");
                tree.LRN(root);
                System.out.println("Height of Tree is " + root.height(root) );
        }
}
