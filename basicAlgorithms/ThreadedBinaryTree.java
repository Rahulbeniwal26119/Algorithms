class Node  
 {
        int data;
        Node left, right;
        boolean leftThread, rightThread;

        public Node(int data)
        {
                this(data, null, null, true, true);
        }

        public Node(boolean leftThread, boolean rightThread)
        {
                this.data = Integer.MAX_VALUE;
                this.left = this;
                this.right  = this;
                this.leftThread = leftThread;
                this.rightThread = rightThread;
        }

        public Node(int data, Node left, Node right, boolean leftThread, boolean rightThread)
        {
                this.data = data;
                this.left = left;
                this.right  = right;
                this.leftThread = leftThread;
                this.rightThread = rightThread;
        }
}

public class ThreadBinaryTree
{
        private Node root;

        public ThreadBinaryTree()
        {
                root = new Node(true, false);
        }

        public void clear()
        {
                root = new Node(true, false);
        }

        public void insert(int element)
        {
                Node ptr = findNode(root, element);
                if(ptr == null)
                        return ;
                if(ptr.data < element)
                {
                        Node nptr = new Node(element, ptr, ptr.right, true, true);
                        ptr.right = nptr;
                        ptr.rightThread = false;
                }
                else 
                {
                        Node ptr = new Node(element, ptr.left, ptr, true, true);
                        ptr.left = nptr;
                        ptr.leftThread = false;
                }
        }

        public Node findNode(Node root, int element )
        {
                if(root.data < element)
                {
                        if(root.rightThread)
                                return r;
                        return findNode(root.right, element); 
                }
                else if(root.data > element)
                {
                        if(root.leftThread)
                                return root;
                        return findNode(root.left, element);
                }
                else 
                        return null;
        }

        public boolean search(int element)
        {
                return findNode(root, element) == null;
        }


        public void inOrder()
        {
                Node temp = root;
                for(;;)
                {
                        temp = insucc(temp);
                        if(tmp == root)
                                break;
                        System.out.print(temp.data + " ");
                }
        }

        public Node insucc(Node node)
        {
                Node temp;
                temp = node.right;
                if(!node.rightThread)
                        while(!node.leftThread)
                                temp = temp.left;
                return temp;
        }
}