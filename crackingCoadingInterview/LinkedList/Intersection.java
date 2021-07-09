static Node findIntersection(Node list1, Node list2){
    if(list1 == null || list2 == null) return null;

    Result result1 = getTailAndSize(list1);
    Result result2 = getTailAndSize(list2);

    if(result1.tail != result2.tail)
            return null;

    Node shorter = result1.size < result2.size ? list1 : list2;
    Node longer = result1.size < result2.size ? list2 : list1;

    longer = getKNode(longer, Math.abs(result1.size - result2.size));
    while(shorter != longer)
    {
            shorter = shorter.next;
            longer = longer.next;
    }

    return longer;
}

public static class Result{
    public Node tail;
    public int size;
    public Result(Node tail, int size){
            this.tail = tail;
            this.size = size;
    }
}

public  void linkLast(Node next){
    tail.next = next;
    tail = next;
}


static Result getTailAndSize(Node head){
    if(head == null) return null;
    int size = 1;
    Node current = head;
    while(current.next != null)
    {
            size++;
            current = current.next;
    }
    return new Result(current, size);
}

static Node getKNode(Node head, int k){
    Node current = head;
    while(k > 0 && current != null){
            current = current.next;
            k--;
    }
    return current;
}
