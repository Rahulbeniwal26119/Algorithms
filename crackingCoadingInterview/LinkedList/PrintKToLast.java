public int printKthToLast(Node head, int k){
        if(head == null) return 0;
        int index = printKthToLast(head.next, k) + 1;
        System.out.println(index);
        if(index == k)
                System.out.println(k + "th to last node is " + head.data);
        return index;
}

Node nthToLastIterative(Node head, int k){
        Node p1 = head;
        Node p2 = head;

        for(int i=0; i < k; i++){
                        if(p1 == null) return null;
                        p1 = p1.next;
        }

        while(p1 != null){
                        p1 = p1.next;
                        p2 = p2.next;
        }
        return p2;
}


class Index{
        public int value=0;
}

public Node kthToLast(Node node, int k){
        Index idx = new Index();
        return kthToLast(head, k , idx);
}

Node kthToLast(Node head, int k, Index  idx){
        if(head == null)
                        return null;
        Node node = kthToLast(head.next, k , idx);
        if(node == null)
                        System.out.println("null");
        else 
                        System.out.println(node.data);

        idx.value+=1;
        if(idx.value == k)
                        return head;
        return node;
}