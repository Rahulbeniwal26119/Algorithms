public interface Position<E>
{
/**
 * Returns the element stored at this position
 * 
 * @return the stored element 
 * @throws IllegalStateException if positive no longer valid 
 */
        E getElement() throws IllegalStateException;
}

