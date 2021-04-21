class Node {

        int key;
        Node parent;
        Node left, right;

        Node(int item, Node Pred) {
                key = item;
                left = right = null;
                parent = Pred;
        }

        Node whoIsParent()
        {
                if(parent == null)
                        // throw new IllegalStateException("Root donot  has  parent");
                        return null;
                else 
                        return parent;
        }

        boolean isRoot() {
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

        int height(Node root) {
                if (root == null)
                        return -1;
                else {
                        int leftHeight = height(root.getLeft());
                        leftHeight += 1;
                        int rightHeight = height(root.getRight());
                        rightHeight += 1;
                        if (leftHeight > rightHeight)
                                return leftHeight;
                        else
                                return rightHeight;
                }
        }

        int totalNodes(Node root) {
                if (root == null)
                        return 0;
                else
                        return totalNodes(root.getLeft()) + totalNodes(root.getRight()) + 1;
        }

        int totalExternalNode(Node root) {
                if (root == null)
                        return 0;
                else if (root.getLeft() == null && root.getRight() == null)
                        return 1;
                else
                        return totalExternalNode(root.getLeft()) + totalExternalNode(root.getRight());
        }

        int totalInternalNodes(Node root) {
                if (root == null || (root.getLeft() == null && root.getRight() == null))
                        return 0;
                else
                        return totalInternalNodes(root.getLeft()) + totalInternalNodes(root.getRight()) + 1;
        }

        void mirrorImage(Node root) {
                Node temp;
                if (root != null) {
                        mirrorImage(root.getLeft());
                        mirrorImage(root.getRight());
                        temp = root.getLeft();
                        root.setLeft(root.getRight());
                        root.setRight(temp);
                }
        }

        int depth(Node node)
        {
                if(node == null)
                        return -1;
                else 
                        return depth(node.whoIsParent()) + 1;
        }
}
