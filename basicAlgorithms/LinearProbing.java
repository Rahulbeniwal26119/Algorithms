public class LinearProbing
{
		public final int HASHSIZE = 100;
		public String hashTable[] = new String[HASHSIZE];
		int hash(String key)
		{
			int hashval = 0;
			for(int i=0; i< key.length(); i++)
					hashval = (int)key.charAt(i) +  31 * hashval;
			return hashval % HASHSIZE;
		}

		int probe(String key)
		{
				int index = hash(key);
				int i=0;
				while(hashTable[(index + i) % HASHSIZE] != null) // for quadratic probling use i * i instead to i 
				{
								i++;
				}
				return (index + i) % HASHSIZE;
		}


		public void insert(String key , String value)
		{
				int index = hash(key);
				if(hashTable[index] != "")
						index = probe(key);
				hashTable[index] = key;
		}

		public int search(String key)
		{
			int index = hash(key);
			int i=0;
			while(hashTable[(index + i) % HASHSIZE] != key)
				i++;
			
				return (index + i) % HASHSIZE;
			
		}
		public static void main(String []args)
		{
			LinearProbing ht = new LinearProbing();
			ht.insert("Rahul" , "Beniwal");
			ht.insert("Kuldeep" , "Kuldeep");
			ht.insert("Rahul" , "Beniwal");
			ht.insert("Rahul" , "Beniwal");
			ht.insert("Rahul" , "Beniwal");
			System.out.println(ht.search("Rahul"));
		}
}
