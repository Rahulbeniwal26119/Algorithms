class Node{
        String value;
        String key;
        Node next;

        Node(String key, String value){
            this.value = value;
            this.key = key;
            this.next = null;
        }
    }

class LL{

    Node root = null;
    Node last = null;

    public void add(String key, String value){
        var node = new Node(key, value);
        node.next = null;
        if(root == null)
            root = last = node;
        else{
            last.next = node;
            last = node;
        }
    }
}
 class HashTable{
    int HASH_TABLE_SIZE = 10;
    LL hashTable[] = new LL[HASH_TABLE_SIZE];

    public static int hashFunction(String key){
        int hashValue = 0;
        for(int i=0; i < key.length(); i++){
            int ascii = (int)key.charAt(i);
            hashValue = hashValue + ascii;
        }
        return hashValue % 10;
    }

    void insert(String key, String value){
        int hashValue = hashFunction(key);
        if(hashTable[hashValue] != null){
            hashTable[hashValue].add(key, value);
        }
        else{
            LL newLL = new LL();
            newLL.root =  newLL.last = new Node(key, value);
            hashTable[hashValue] = newLL; 
        }
    }

    String lookUp(String key){
        int hashValue  = hashFunction(key);
        if(hashTable[hashValue] != null){
            LL linkedList = hashTable[hashValue];
            Node ptr = linkedList.root;
            while(ptr != null){
                if(ptr.key == key)
                    return ptr.value;
                else
                    ptr = ptr.next;
            }
        }
        return "Key is not installed";
    }
}

class Main{
    public static void main(String[] args){
        HashTable h = new HashTable();
        h.insert("Rahul", "Beniwal");
        h.insert("Ram", "Ram");
        h.insert("maR", "maR");
        System.out.println(h.lookUp("Rahul"));
        System.out.println(h.lookUp("Ram"));
        System.out.println(h.lookUp("maR"));
    }
}
