class Node
{
  int data;
  Node right;
  Node left;
  public Node(int item)
  {
    data = item;
    left = right = null;
  }
}

class BinaryTree
{
  static Node root;
  public BinaryTree()
  {
    root = null;
  }
  
void printLevelOrder()
{
	int h = height(root);
	for(int i=1; i<=h; i++)
		printGivenLevel(root , i);
}
int height(Node root)
	{
		if( root==null)
			return 0;
		else 
		{
			int lheight = height(root.left);
			int rheight = height(root.right);

			if(lheight > rheight)
				return (lheight + 1);
			else 
				return (rheight + 1);
		}
}
void printGivenLevel(Node root , int level)
{
	if(root==null)
		return ;
	if(level == 1)
		System.out.println(root.data + " ");
	else if(level > 1)
	{
		printGivenLevel(root.left , level-1);
		printGivenLevel(root.right , level-1);
	}
}
public static void main(String []args)
{
	BinaryTree tree = new BinaryTree();
	tree.root = new Node(1);
	tree.root.left = new Node(2);
	tree.root.right = new Node(3);

	tree.root.left.left = new Node(4);
	tree.root.left.right = new Node(5);
	System.out.println(tree.height(root) + "is the height");
	tree.printLevelOrder();
}
}
