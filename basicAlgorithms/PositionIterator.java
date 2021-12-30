private class PositionIterator implements Iterator<Position<E>>
{
        private Position<E> cursor = first(); // position of next element to report 
        private Position<E> recent = null; // position of last reported element 
        public boolean hasNext() { return (cursor != null); }
        public Position<E> next() throws NoSuchElementException
        {
                if(cursor == null) throw new NoSuchElementException("nothing left");
                recent = cursor;
                cursor = after(cursor);
                return recent;
        }
        public void remove() throws IllegalStateException
        {
                if(recent == null) throw new IllegalStateException("nothing to report");
                LinkedPositionalList.this.remove(recent);
                recent = null;
        }
}
private class PositionIterable implements Iterable<Position<E>>
{
        public Iterator<Position<E>> iterator() 
        {
                return new PositionIterator();
        }
        public Iterable<Position<E>> positions()
        {
                return new PositionIterable();
        }
}

private class ElementIterator Implements Iterator<E> 
{
        Iterator<Position<E>> posIterator = new PositionIterator();
        public boolean hasNext() { return posIterator.hasNext();}
        public E next() { return posIterator.next().getElement();}
        public void remove()  { posIterator.remove();}
}
public Iterator<E> iterator() { return new ElementIterator();}


