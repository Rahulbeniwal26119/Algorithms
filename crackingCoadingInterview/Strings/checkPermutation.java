// let two string are A and B , these can be permuation if , first they are of same length and made by same number of chacracters 

public class  checkPermutation 
{
	static	String sort(String s)
	{
		char[] charArray  = s.toCharArray();
		java.util.Arrays.sort(charArray);
		return new String(charArray);
	}

	static 	boolean permutationM1(String a , String b)
	{
		// complexity is about O(nlog) from time 
		if(a.length() != b.length())
			return false;
		return sort(a).equals(sort(b));
	}
	
	static boolean permutationM2(String a , String b)
	{
		if(a.length() != b.length())
			return false;

		int array[] = new int[128];
		char s_array[] = a.toCharArray();
		for( char c : s_array)
		{
			array[c]++;
		}


		for(int i=0; i<b.length(); ++i)
		{
			char c = b.charAt(i);
			array[c]--;
			if(array[c] < 0)
				return false;
		}
		return true;
	}

	public static void main(String [] args)
	{
		System.out.println(permutationM1("Rahul", "luhaR"));
		System.out.println(permutationM2("Rahul", "luhar"));
	}
}




