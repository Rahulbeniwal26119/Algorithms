

class FixedMultiStack{
		private int stackCount = 3;
		private int stackCapacity;
		private int [] values;
		private int [] size;

		// stack number starts from 0 and follow up 

		public FixedMultiStack(int stackSize){
				stackCapacity = stackSize;
				values = new int[stackSize * stackCount];
				size = new int[stackCount];
		}

		public void push(int stackNum, int value) throws FullStackException{
				if(isFull(stackNum))
						throw new FullStackException();
				size[stackNum]++;
				values[indexOfTop(stackNum)] = value;
		}

		public int pop(int stackNum) throws EmptyStackException{
				if(isEmpty(stackNum))
						throw new EmptyStackException();
				int topIndex = indexOfTop(stackNum);
				int value = values[topIndex];
				values[topIndex] = 0;
				size[stackNum]--;
				return value;
		}

		public int peek(int stackNum) throws EmptyStackException{
				if(isEmpty(stackNum))
						throw new EmptyStackException();
				return values[indexOfTop(stackNum)];
		}

		public boolean isEmpty(int stackNum){
				return size[stackNum] ==0;
		}

		public boolean isFull(int stackNum){
				return size[stackNum] == stackCapacity;
		}

		private int indexOfTop(int stackNum){
				int offset = stackNum * stackCapacity;
				int s = size[stackNum];
				return offset + s - 1;
		}
}


