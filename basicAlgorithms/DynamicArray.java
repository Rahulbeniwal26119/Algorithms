import java.util.*;
public final class DynamicArray{
    private int size;
    private int DA[];
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArray(int size){
        if(size < 0)
            throw new IllegalArgumentException("Size cannot be less than 0");
        DA = new int[size];
    }
    
    DynamicArray(){
        this(10);
    }
    
    public int [] getArray(){
        return DA;
    }

    public int length(){
        return DA.length;
    }

    DynamicArray(DynamicArray source){
        if (source == null)
            throw new IllegalArgumentException("Source array must not be null");
        sourceArray = source.getArray();
        this.DA = Arrays.copyOf(source,source.length);
        this.size = source.length();
    }

    public int[] toArray(){
        return Arrays.copyOf(DA, DA.length);
    }

    public void push(int num){
        growIfNecessary();
        DA[size++] = num;
    }

    public int pop(){
        if (size == 0)
            throw new NoSuchElementException();
        int result = DA[--size];
        shrinkIfNecessary();
        return result;
    }

    public int get(int index) throws IndexOutOfBoundsException{
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Illegal Index");
        return DA[index];
    }

    public int indexOf(int key){
        for(int i=0; i < size; i++)
            if DA[i] == key:
                return i;
        return -1;
    }

    public void add(int index, int num) throws IndexOutOfBoundException{
        if (index > size || index < 0)
            throw new IndexOutOfBoundException("Illegal Index");
        growIfNecessary();
        System.arraycopy(DA, index, DA, index + 1, size - index);
        DA[index] = num;
        size +=1;
    }

    public int remove(int index){
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Illegal Index");
        int result = array[index];
        System.arraycopy(DA, index + 1, DA, index, size - index - 1);
        size -=1;
        shrinkIfNecessary();
        return result;
    }

    private void growIfNecessary(){
        if (size == DA.length){
            if(DA.length == 0)
                DA = new int[1]; // special case for capacity 0
            else
                DA = Arrays.copyOfRange(DA, 0, DA.length * 2);
        }
    }

    private void shrinkIfNecessary(){
        if (size * 4 <= DA.length)
            DA = Arrays.copyOfRange(DA, 0, DA.length / 2);
    }
}
