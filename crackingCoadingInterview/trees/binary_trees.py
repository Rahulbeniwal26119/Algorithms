class Node:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = None

    def is_leaf(self):
        return not any([self.left, self.right])

    def has_one_child(self):
        return any([self.left, self.right])

    def has_two_child(self):
        return all([self.left, self.right])

    def is_root(self):
        return self.parent == None

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
        else:
            temp_root.left = node

        node.parent = temp_root
        return self.root

    def in_order(self, root, space, ty=''):
        # cut down recursive call to almost half
        space+=4

        if root.right:
            self.in_order(root.right, space, 'right')
        if root:
            if ty == 'right':
                sym = '/'
            elif ty == 'left':
                sym = '\\'
            else:
                sym = ''

            if ty == 'left':
                print(' ' * (space - 2), sym)
            for i in range(space):
                print(" ", end='')
            print(root.value)
            if ty == 'right':
                print(' ' * (space - 2 ), sym, '\\')
        if root.left:
            self.in_order(root.left, space, 'left')
        return

    def pre_order(self, root, space):
        space+=1
        if root:
            print("\n")
            for i in range(space):
                print("/", end='')
            print(root.value)
        if root.left:
            self.pre_order(root.left, space)
        if root.right:
            self.pre_order(root.right, space)
        return

    def post_order(self, root):
        if root.right:
            self.post_order(root.right)
        if root.left:
            self.post_order(root.left)
        if root:
            print(root.value)

    def delete(self, value, root):
        if root is None:
            return
        node = None
        while root:
            if root.value == value:
                node = root
            elif root.value < value:
                root = root.right
            else:
                root = root.left
        if node is None:
            raise Exception(f"{value} doesnot exists in tree")

        # Check if node is leaf Node
        if node.is_leaf():
            parent = node.parent
            left = parent.left
            right = parent.right

            # check if node is left or right node
            if node == left:
                parent.left = None
            else:
                parent.right = None

        elif node.has_one_child():
            valid_child = node.left if node.left else node.right
            if node.is_root():
                self.root = valid_child
                node = None
            else:
                parent = node.parent
                # check if deleted node if either left child or right child of parent node
                if parent.left == node:
                    parent.left = valid_node
                else:
                    parent.right = valid_node
        else:
            left = node.left
            right = node.right
            if node.is_root():
                right_left = right.left
                right.left = left
                # append the right_left to the end of right.left
                while left.right is not None:
                    left = left.right
                left.right = right_left
            else:
                parent = node.parent
                # check if node is in left or right or parent
                if parent.left == node:




root = Node(40)
tree = Tree(root)
nodes = [30, 50, 25, 55, 46, 45, 60]
for val in nodes:
    tree.insert(val)
print(root)
tree.in_order(root, 0)
# tree.pre_order(root, 0)
# print(inserted)

