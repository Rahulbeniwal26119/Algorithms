Node partition(Node node , int x){
    Node beforeStart = null;
    Node beforeEnd = null;
    Node afterStart = null;
    Node afterEnd = null;

    while(node != null){
            Node next = node.next;
            node.next = null;
            if(node.data < x){
                    if(beforeStart == null){
                            beforeStart = node;
                            beforeEnd = beforeStart;
                    }
                    else {
                            beforeEnd.next = node;
                            beforeEnd = node;
                    }
            }
            else {
                    if(afterStart == null){
                            afterStart = node;
                            afterEnd = afterStart;
                    }
                    else{
                            afterEnd.next = node;
                            afterEnd = node;
                    }
            }
            node = next;
    }
    if(beforeStart == null)
            return afterStart;
    beforeEnd.next = afterStart;
    return beforeStart;
}