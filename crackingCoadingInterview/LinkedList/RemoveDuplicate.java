		public void deleteDups(Node n){

				HashSet<Integer> set = new HashSet<>();
				Node previous = null;
				while(n != null){
						if(set.contains(n.data)){
								previous.next = n.next;
						}
						else {
								set.add(n.data);
								previous = n;
						}
						n = n.next;
				}
		}

		public void deleteDupNoBuffer(Node head){
				Node current = head;
				while(current != null){
						Node runner = current;
						while(runner.next != null)
						{
								if(runner.next.data == current.data){
										runner.next = runner.next.next;
								}
								else {
										runner = runner.next;
								}
						}
						current = current.next;
				}
		}

