//----------------nested ArrayIterator class --------------
/** 
 * Each instance has contains an implicit 
 * reference to the containing list, allowing it to access the list's members.
 */

private class ArrayIterator implements Iterator<E>
{
        private int j = 0; // index of next element to report 
        private boolean removable = false;  // can remove be called at this time ? 
        public boolean hasNext() { return j < size; }
        public E next() throws  NoSuchElementException
        {
                if(j==size) throw new NoSuchElementException("No next element");
                removable = true;
                return data[j++];
        }
        public void remove() throws IllegalStateException 
        {
                if(!removable) throw new IllegalStateException("nothing to remove");
                ArrayList.this.remove(j-1);
                j--;
                removable = false;
        }
        public Iterator<E> iterator()
        {
                return new ArrayIterator();
        }
}

