static Node findBeginning(Node head){
    Node fast = head;
    Node slow = head;

    while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                    break;
    }

    System.out.println("Collision point is " + slow.data);

    if(fast == null || fast.next == null)
            return null;

    slow = head;
    while(slow != fast){
            slow = slow.next;
            fast = fast.next;
    }

    return fast;
}
