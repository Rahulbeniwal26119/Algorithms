// To check the permutation of palindrome , first to check if it was a part of palindrome then a
// string is palindrome iff it has all character are of even frequency or atmost one odd frequency
// situated at the center of the string
public class checkingPermutationOfPalindrome
{
	boolean isPermutationOfPalindrome(String phrase)
	{
		int table[] = charFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}

	boolean checkMaxOneOdd(int [] table)
	{
		boolean foundOdd = false;
		for(int count : table)
		{
			if(count % 2 == 1 )
			{
				if(foundOdd)
				return false;
				foundOdd = true;
		}
		}
		return true;

	}
	// only for small character 
	int getCharNumber(Character c)
	{
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int value = Character.getNumericValue(c);
		if(a <= val && val <= z)
			return val - 'a';
		return -1;
	}

	int[] buildCharFrequencyTable(String phrase)
	{
		int []table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1 ];
		for(char c : phrase.toCharArray())
		{
			int x = getCharNumberic(c);
			if(x != -1)
				table[x]++;
		}
		return table;
	}

}

// b a dfjfdasj fasfdjadfslkjfdasjkfjds 
