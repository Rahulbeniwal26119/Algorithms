    if(llist == NULL)
    {
        llist = new DoublyLinkedListNode(data);
        llist->prev = llist->next = NULL;
        return llist;
    }
    else 
    {
        DoublyLinkedListNode *tempHead = llist;
        DoublyLinkedListNode *newNode  = new DoublyLinkedListNode(data);
        DoublyLinkedListNode *prevPtr = NULL;
        while(llist != NULL && llist->data <= data )
        {
            prevPtr = llist;
            llist = llist->next;
        }   
        cout << "Hello" << endl;
        if(prevPtr == NULL)
        {
            cout << "  null case " << endl;            
            newNode->prev = NULL;
            newNode->next = llist;
            llist->prev = newNode;
            return newNode;
        }     
        else if(prevPtr->next == NULL)
        {
            cout << "last node case " << endl;
            
            prevPtr->next = newNode;
            newNode->prev = prevPtr;
            newNode->next = NULL;
            return tempHead;
        }
        else {
            cout << "any node case  " << endl;            
            DoublyLinkedListNode *next = prevPtr->next; 
            prevPtr->next  = newNode;
            newNode->prev = prevPtr;
            newNode->next = next;
            next->prev = newNode;
            return tempHead;
        }
    }
