import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class TreeSetExample{

		public static void main(String[] args){
				TreeSet<String> brands = new TreeSet<>();
				brands.add("IBM");
				brands.add("Google");
				brands.add("Volvo");
				brands.add("Grey");

				System.out.println(brands);
				System.out.println(brands.descendingSort());
				System.out.println(brands.first());
		}
}


