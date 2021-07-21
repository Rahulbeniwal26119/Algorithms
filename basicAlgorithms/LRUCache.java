import java.util.*;

class LRUCache{
    Set<Character> cache;
    int capacity;

    public LRUCache(int capacity){
        this.cache = new LinkedHashSet<Character>(capacity);
        this.capacity = capacity;
    }

    public boolean get(char key){
        if(!cache.contains(key)){
            return false;
        }
        cache.remove(key);
        cache.add(key);
        return true;
    }

    public void refer(char key){
        if(get(key) == false)
            put(key);
    }

    public void display(){
        LinkedList<Character> list = new LinkedList<>(cache);
        Iterator<Character> itr = list.descendingIterator();
        while(itr.hasNext())
            System.out.println(itr.next() + " ");
    }

    public void put(char key){
        if(cache.size() == capacity){
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }
        cache.add(key);
    }

    public static void main(String ...args){
        LRUCache ca = new LRUCache(5);
        ca.refer('a');
        ca.refer('b');
        ca.refer('c');
        ca.refer('a');
        ca.refer('d');
        ca.refer('e');
        ca.refer('b');
        ca.display();
    }
}
