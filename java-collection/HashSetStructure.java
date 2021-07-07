import java.util.*;

class HashSetStructure{

		public static void main(String []args){
				HashSet<Integer> h = new HashSet<>();
				h.add(1);
				h.add(2);
				h.add(3);
				h.add(4);
				h.add(5);

				System.out.println(h);
				System.out.println(h.contains(1));

				h.remove(5);
				System.out.println(h);

				Iterator<Integer> i= h.iterator();
				while(i.hasNext())
				{
						System.out.println(i.next());
				}
		}
}


