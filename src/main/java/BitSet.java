import java.util.*;


public class BitSet<T> implements Iterator {

    private final int size;
    private ArrayList<T> container;
    private Iterator<T> iter;

    public BitSet(int size) {
        if (size < 0) {
            throw new java.lang.NegativeArraySizeException("Size of bitset can't be negative");
        } else {
            this.size = size;
            container = new ArrayList<>(size);
            iter = container.iterator();
        }
    }

    public BitSet(int size, T... arg) throws Exception {
        if (size < 0) {
            throw new java.lang.NegativeArraySizeException("Size of bitset can't be negative");
        } else {
            this.size = size;
            container = new ArrayList<>(size);
            this.add(arg);
            iter = container.iterator();
        }
    }

    public boolean contains(T obj) {
        return container.contains(obj);
    }

    public int length() {return size;}

    public T get(int index) throws Exception {
        return container.get(index);
    }

    public void add(T obj) throws Exception {
        if (container.size() == size) {
            throw new Exception("Bitset is crowded");
        }
        else {
            if (!this.contains(obj)) {
                container.add(obj);
            }
        }
    }

    public void add(T[] arr) throws Exception {
        for (T elem: arr) {
            this.add(elem);
        }
    }

    public boolean remove(T obj) {
        return container.remove(obj);
    }

    private BitSet<T> addFromArray(ArrayList<T> arrayList) throws Exception {

        BitSet<T> newBitSet = new BitSet<T>(arrayList.size());
        for (T elem: arrayList) {
            newBitSet.add(elem);
        }
        return newBitSet;
    }

    public BitSet<T> intersection(BitSet<T> bitSet) throws Exception {

        ArrayList<T> result =
                new ArrayList<>(Math.max(this.container.size(), bitSet.container.size()));

        for (T elem: this.container) {
            if (bitSet.contains(elem)) {
                result.add(elem);
            }
        }
        return addFromArray(result);
    }

    public BitSet<T> unification (BitSet<T> bitSet) throws Exception {
        ArrayList<T> result = new ArrayList<>(size + bitSet.size);
        for (T elem: this.container) {
            result.add(elem);
        }

        for (T elem: bitSet.container) {
            if (!result.contains(elem)) {
                result.add(elem);
            }
        }
        return addFromArray(result);
    }

    public BitSet<T> complement(BitSet<T> bitSet) throws Exception {
        ArrayList<T> result =
                new ArrayList<>(this.container.size());

        for (T elem: this.container) {
            if (this.contains(elem) && !bitSet.contains(elem)) {
                result.add(elem);
            }
        }
        return addFromArray(result);

    }



    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + (container != null ? container.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj instanceof BitSet<?>) {
            BitSet<T> bitSet = (BitSet<T>) obj;
            return container.equals(bitSet.container);
        }
        return false;
    }

    @Override
    public String toString() {
        return container.toString();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();

    }
    @Override
    public Object next() {
        return iter.next();
    }

}






