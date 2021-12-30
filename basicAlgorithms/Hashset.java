import java.util.HashSet;
import java.util.Set;

class HashSetExample{

		public static void main(String[] args){
				Set<String> brands = new HashSet<>();
				brands.add("Pepsi");
				brands.add("Amazon");
				brands.add("Volvo");
				brands.add("Volvo");


				System.out.println(brands);
				System.out.println(brands.contains("Volvo"));
				brands.clear();
				System.out.println(brands);
		}
}


