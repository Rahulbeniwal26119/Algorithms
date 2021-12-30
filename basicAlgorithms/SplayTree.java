import java.util.*;

class SplayTree {
	static class Node {
		int key;
		Node left, right;
	}

	static Node newNode(int key) {
		Node newNode = new Node();
		newNode.key = key;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}

	static Node rightRotate(Node x) {
		Node y = x.left;
		x.left = y.right;
		y.right = x;
		return y;
	}

	static Node leftRotate(Node x) {
		Node y = x.right;
		x.right = y.left;
		y.left = x;
		return y;
	}

	static Node insert(Node root, int k) {
		if (root == null)
			return newNode(k);
		root = splay(root, k);
		if (root.key == k)
			return root;
		Node newnode = newNode(k);
		if (root.key > k) {
			newnode.right = root;
			newnode.left = root.left;
			root.left = null;
		}

		if (root.key < k) {
			newnode.left = root;
			newnode.right = root.right;
			root.right = null;
		}

		return newnode;
	}

	static Node splay(Node root, int key) {
		if (root == null || root.key == key)
			return root;

		if (root.key > key) {
			if (root.left == null)
				return root;

			if (root.left.key > key) {
				root.left.left = splay(root.left.left, key);
				root = rightRotate(root);
			}

			else if (root.left.key < key) {
				root.left.right = splay(root.left.right, key);

				if (root.left.right != null)
					root.left = leftRotate(root.left);
			}

			return (root.left == null) ? root : rightRotate(root);
		}

		else {
			if (root.right == null)
				return root;

			if (root.right.key > key) {
				root.right.left = splay(root.right.left, key);

				if (root.right.left != null)
					root.right = rightRotate(root.right);
			} else if (root.right.key < key) {
				root.right.right = splay(root.right.right, key);
				root = leftRotate(root);
			}

			return (root.right == null) ? root : leftRotate(root);
		}
	}

	static void preOrder(Node root) {
		if (root == null)
			return;
		else {
			System.out.println(root.key + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	static void inOrder(Node root)
	{
		if(root == null)
			return;
		else
		{
			inOrder(root.left);
			System.out.println(root.key);
			inOrder(root.right);
		}
	}

	public static void main(String[] main) {
		Node root = newNode(100);
		root.left = newNode(50);
		root.right = newNode(200);
		root.left.left = newNode(40);
		root.left.left.left = newNode(30);
		root.left.left.left.left = newNode(20);
		root = insert(root, 25);
		System.out.print("Inorder  traversal of the modified Splay tree is \n");
		inOrder(root);
	}
}
