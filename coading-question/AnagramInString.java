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
				static public void main(String []args){
				String s = "abaa";
				String p = "baaaa";
				System.out.println(isAnagram(s,p));
				System.out.println( isPlaindrome(s));
		}
}

						
