public class HashChaining {
	public final int HASHSIZE = 100;

	public static class NList {
		String key;
		String value;
		NList next;
	}

	private NList hashtab[];

	HashChaining() {
		hashtab = new NList[HASHSIZE];
	}

	int hash(String key) {
		int hashval = 0;
		for (int i = 0; i < key.length(); i++)
			hashval = (int) key.charAt(i) + 31 * hashval;
		return hashval % HASHSIZE;
	}

	NList lookup(String key) {
		NList np;
		for (np = hashtab[hash(key)]; np != null; np = np.next) {
			if (key.equals(np.key))
				return np;
		}
		return null;
	}

	void install(String key, String value) {
		NList np;
		int hashval;

		if ((np = lookup(key)) == null) {
			np = new NList();
			np.key = key;
			np.value = value;
			hashval = hash(key);
			if (hashtab[hashval] != null) {
				NList head = hashtab[hashval];
				while (head.next != null) {
					head = head.next;
				}
				head.next = np;
				np.next = null;
			} else {
				hashtab[hashval] = np;
			}
		}
	}

	public static void main(String[] args) {
		HashChaining hashTable = new HashChaining();
		hashTable.install("Rahul", "Beniwal");
		hashTable.install("Kuldeep", "Singh");
		hashTable.install("lord", "krishna");
	}
}
