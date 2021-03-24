//  create a array of boolean (length  = number of characters a language)
//  if length of string > length of characterArray return false , as there 
//  must be some duplicate cases 
//
//  put characterArray[ASCIIRelativeIndex] = true if a chacter is encountered first 
//  if there is any reassigning at already occupied index in boolean array then string is not unique 
// time Complexity O(n) and space is O(1) or O(c)
 class uniqueCharacters
{
	static 	boolean isUniqueChars(String str)
	{
		if(str.length() > 128) // as there are 128 character in ASCII charset 
			return false;
		boolean charSet[] = new boolean[128];
		for(int i=0; i<str.length(); i++)
		{
			int value = str.charAt(i);
			if(charSet[value] == false)
				charSet[value] = true;
			else
				return false;
		}
		return true;
	}

	public static void main(String []args)
	{
		String str = "new Strig";
		System.out.println(isUniqueChars(str));
	}
}



