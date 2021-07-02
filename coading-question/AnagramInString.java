import java.util.*;

public class AnagramInString{

		static boolean isAnagram(String s, String r){
				int temp[] = new int[128];
				if(s.length() != r.length())
						return false;
				for(int i = 0; i < s.length(); i++){
						char c = s.charAt(i);
						System.out.println(c);
						temp[c]++;
				}

				for(int i=0; i < r.length(); i++)
				{
						--temp[r.charAt(i)];
				}

				for(int i=0; i<r.length(); i++)
						if(temp[r.charAt(i)] != 0)
								return false;

				return true;
		}

		static boolean isPlaindrome(String s){
				int oddCount = 0;
				int [] table = new int[128];


				for(char c : s.toCharArray())
				{
						table[c]++;
						if(table[c] % 2 == 1) 
								oddCount++;
						else 
								oddCount--;
				}
				return oddCount <= 1;
		}

		public static ArrayList<Integer> isAnagramIndices(String s, String word){
				ArrayList<Integer> result = new ArrayList<>();
				for(int i=0; i < s.length() - word.length(); i++){
				System.out.println("in loop");
						String window = s.substring(i, s.length());
						System.out.println(window);
						System.out.println(isAnagram(window, word));
						if(isAnagram(window, word))
										result.add(i);
				}
				return result;
		}


		static public void main(String []args){
				String s = "abbaaababababa";
				String p = "ab";
				ArrayList<Integer> result = isAnagramIndices(s,p);
				for(var i : result)
						System.out.println(i);
		}
}

						
