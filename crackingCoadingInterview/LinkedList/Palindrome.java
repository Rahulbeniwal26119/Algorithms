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

static boolean isPalindrome2(Node head){
    Node fast = head;
    Node slow = head;

    Stack<Integer> stack = new Stack<>();
    while(fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
    }

    if(fast != null)
            slow = slow.next;
    while(slow != null){
            int top = stack.pop();
            if( top != slow.data)
                    return false;
            slow = slow.next;
    }
    return true;
}
