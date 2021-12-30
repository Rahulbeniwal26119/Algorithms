import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Node
{
        int data;
        Node left, right;

        public Node(int data)
        {
                this.data = data;
                this.left = this.right = null;
        }
}

class LeftViewOfTree
{
        int maxLevel = 0;
        void leftViewiOfBinaryTree(Node root, int level)
        {
                if(root == null)
                        return;
                if(maxLevel < level)
                {
                      
                        System.out.println(root.data);
                        maxLevel = level;
                }

                leftView(root.left, level + 1 );
                leftView(root.right, level + 1 );
        }
        void leftView(Node root, int level, List<Integer> list)
        {
                if(root == null)
                        return ;
                if(maxLevel <= level)
                {
                        list.add(root.data);
                        level = maxLevel;
                }
                        leftView(root.left, level+1, list);
        }

        void rightView(Node root, int level, List<Integer> list)
        {
                if(root == null)
                        return ;
                if(maxLevel < level)
                {
                        list.add(root.data);
                        level = maxLevel;
                }
                rightView(root.right, level+1, list);
        }

}

public class LeftSubTree
{
        public static void main(String []args)
        {
                Node root = new Node(1);
                root.left = new Node(2);
                root.right = new Node(3);
                root.left.left = new Node(4);
                root.left.right  = new Node(5);
                root.right.left = new Node(7);
                root.right.right = new Node(8);
                List<Integer> list = new ArrayList<>();
                LeftViewOfTree ins = new LeftViewOfTree();
                ins.leftView(root, 0, list);
                Collections.reverse(list);
                ins.maxLevel = 0;
                ins.rightView(root, 0 , list);
                for(int i : list)
                        System.out.print(i + " ");
        }
}
