public class MorrisTraversal
{
        public static class Node
        {
                int data;
                Node left;
                Node right;
        }

        public void inOrderTraversal(Node root)
        {
                Node pre;
                if(root == null)
                        return;
                Node curr = root;
                while(curr != null)
                {
                        if(curr.left == null)
                        {
                                System.out.println(curr.data+ " " );
                                curr = curr.right;
                        }
                        else 
                        {
                                pre = curr.left;
                                while(pre.right != null && pre.right != curr)
                                        pre = pre.right;
                                if(pre.right == null)
                                {
                                        pre.right = curr;
                                        curr = curr.left;
                                }
                                else 
                                {
                                        pre.right = null;
                                        System.out.println(curr.data + " " );
                                        curr = curr.right;
                                }
                        }
                }
        }
}


