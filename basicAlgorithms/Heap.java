// insetion start at the end of heap position
import java.util.ArrayList;
import java.util.Iterator;

public class Heap{


		static void insert(ArrayList heap, int key){
				int size = heap.size();
				heap.add(key);

				while(size > 0 && key > (int)heap.get( size % 2 == 0 ? (size/2 -1) : size / 2)){
						heap.set(size, (int)heap.get( size % 2 == 0 ? (size/2 -1) : size / 2));
						size = size % 2 == 0 ? size/2 - 1 : size/2;
				}
				heap.set(size, key);
		}

		static void iterate(ArrayList heap){
				Iterator it = heap.iterator();
				while(it.hasNext())
						System.out.print(it.next() + "\t");
		}


		public static void main(String []args){
				ArrayList<Integer> heap = new ArrayList<>();
				insert(heap,10);
				insert(heap,20);
				insert(heap,8);
				insert(heap,30);
				insert(heap,60);
				insert(heap,90);
				insert(heap,10);
				iterate(heap);
		}
}
