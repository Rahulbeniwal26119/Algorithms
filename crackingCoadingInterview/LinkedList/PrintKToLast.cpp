node* nthToLast(node *head, int k, int &i){
		if(head == NULL)
				return NULL;
		node *nd = nToLast(head->next, k, i);
		i+=1;
		if(i == k)
				return head;
		return nd;
}

node *nthToLast(node *head, int k){
		int i =0;
		return headToLast(head, k, i);
}
