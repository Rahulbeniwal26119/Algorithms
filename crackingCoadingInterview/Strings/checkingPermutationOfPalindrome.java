// To check the permutation of palindrome , first to check if it was a part of palindrome then a
// string is palindrome iff it has all character are of even frequency or atmost one odd frequency
// situated at the center of the string
public class checkingPermutationOfPalindrome
{
	static boolean isPermutationOfPalindrome(String phrase)
	{
		int table[] = charFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}

	static boolean checkMaxOneOdd(int [] table)
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
	static int getCharNumber(Character c)
	{
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int value = Character.getNumericValue(c);
		if(a <= val && val <= z)
			return val - 'a';
		return -1;
	}

	static int[] buildCharFrequencyTable(String phrase)
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

	static boolean isPermutationMethod2(String s){
			int countOdd = 0;
			for(char c : s.toCharArray()){
					int x = getCharacterNumber(c);
					if(x != -1)
					{
							table[x]++;
							if(table[x] % 2 == 1)
								   oddCount++;
							else 
									oddCount--;
					}
			}
			return oddCount <= 1;
	}

	boolean isPermutationMethod3(String s){
			int bitVector = createBitVector(s);
			return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}

	int createBitVector(String s){
			int bitVector = 0;
			for(char c : s.toCharArray())
			{
					int x = getCharNumber(c);
					bitVector = toggle(bitVector, x);
			}
			return bitVector;
	}

	int toggle(int bitVector, int index){
			if(index < 0)
					return bitVector;
			int mask = 1 << index;
			if((bitVector & mask) == 0)
					bitVector |= mask;
			else 
					bitVector &= ~mask;
	}

	static boolean checkExactlyOneBitSet(int bitVector){
			return (bitVector & (bitVector - 1)) == 0;
	}







