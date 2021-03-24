// we can use a bit as the 'z' - 'A' = 57 so we can use a 64 bit long datatype 
// and represent the occurance of a character (either uppercase or lowercase) 
// as 1 and check with | if result is 1 that means character are repeat
// else see the approach 
// time complexity is O(n) and space is O(1)
 class uniqueCharactersM2
{
	static boolean  isUniqueChars(String str)
	{
		long checker = 0; // 64 bit long 
		for(int i=0; i<str.length(); i++)
		{
			int val = str.charAt(i) - 'A';
			if((checker & ( 1  << val) ) > 0)
				return false;
			checker |= ( 1 << val);
		}
		return true;
	}

	public static void main(String []args)
	{
		// algorithm is not sure to work for spaces 
		String str = "t A s";
		System.out.println(isUniqueChars(str));
	}
}
