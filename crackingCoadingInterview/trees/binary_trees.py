class Node:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

    def is_leaf(self):
        return not any([self.left, self.right])

inserted = []
class Tree:
    def __init__(self, root):
        self.root = root

    def get_root(self):
        new_root = Node(root.value, root.left, root.right)
        return new_root

    def insert(self, value):
        if not isinstance(value, Node):
            node = Node(value)
        else:
            node = value
        temp_root = self.root
        while not temp_root.is_leaf():
            parent = temp_root
            if temp_root.value > node.value:
                temp_root = temp_root.left
            else:
                temp_root = temp_root.right
            if temp_root is None:
                # Found the parent
                temp_root = parent
                break

        if temp_root.value < node.value:
            temp_root.right = node
            inserted.append(node)
        else:
            temp_root.left = node
            inserted.append(node)

        return self.root

    def in_order(self, root):
        # cut down recursive call to almost half
        if root.left:
            self.in_order(root.left)
        if root:
            print(root.value)
        if root.right:
            self.in_order(root.right)
        return

root = Node(40)
tree = Tree(root)
nodes = [30, 50, 25, 55, 45, 60]
for val in nodes:
    tree.insert(val)
print(root)
#tree.in_order(root.left.value)
print(inserted)
