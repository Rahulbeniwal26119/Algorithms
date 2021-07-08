static boolean isPalindrome(Node head) {
    Node reversed = reverseAndClone(head);
    return isEqual(head, reversed);
}

static Node reverseAndClone(Node node) {
    Node head = null;
    while (node != null) {
        Node n = new Node(node.data);
        n.next = head;
        head = n;
        node = node.next;
    }
    return head;
}

static boolean isEqual(Node l1, Node l2) {
    while (l1 != null && l2 != null) {
        if (l1.data != l2.data)
            return false;
        l1 = l1.next;
        l2 = l2.next;
    }
    return l1 == null && l2 == null;
}