public int printKthToLast(Node head, int k){
        if(head == null) return 0;
        int index = printKthToLast(head.next, k) + 1;
        System.out.println(index);
        if(index == k)
                System.out.println(k + "th to last node is " + head.data);
        return index;
}
