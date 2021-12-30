// if s1 is divided into two part x and y and s2 is yx so yx is always a substring os xyxy
public class CheckRotation {
		public static boolean checkRotation(String s1, String s2){
				int len = s1.length();
				if(len == s2.length() && len > 0){
						String s1s1 = s1 + s1;
						return isSubstring(s1s1,s2);
				}
				return false;
		}

		public static boolean isSubstring(String s1 , String s2){
				int len1 = s1.length();
				int len2 = s2.length();
				int index1,index2;
				index1=index2=0;
				while(len1 > 0 && len2 > 0)
				{
						if(s1.charAt(index1) == s2.charAt(index2)){
								++index2;
								--len2;
						}
						++index1;
						--len1;
				}
				if(len2 == 0)
						return true;
				else 
						return false;
		}

		public static void main(String []args){
				String s1 = "Rahul";
				String s2 = "hulRa";
				System.out.println(checkRotation(s1,s2));
		}
}



