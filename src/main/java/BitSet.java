import java.util.*;

public class BitSet implements Iterable<Integer> {

    private final int size;
    private final boolean[] container;

    public BitSet(int size) {
        if (size < 0) {
            throw new java.lang.NegativeArraySizeException("Size of bitset can't be negative");
        } else {
            this.size = size;
            container = new boolean[size];
            Arrays.fill(container,false);
        }
    }

    public void set (int index, boolean value) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index is bigger than bitset size.");
        }
        container[index] = value;
    }

    public void set (int fromIndex, int toIndex, boolean value) {
        for (int index = fromIndex; index <= toIndex; index++) {
            container[index] = value;
        }
    }

    public int get (int index) {
        return container[index] ? 1 : 0;
    }

    public void and (BitSet bitSet) throws Exception {
        if (size != bitSet.size) {
            throw new Exception("bitsets have different size");
        }
        for (int index = 0; index < size; index++) {
            container[index] = container[index] && bitSet.container[index];
        }
    }

    public void or (BitSet bitSet) throws Exception {
        if (size != bitSet.size) {
            throw new Exception("bitsets have different size");
        }
        for (int index = 0; index < size; index++) {
            container[index] = container[index] || bitSet.container[index];
        }
    }

    public void not () {
        for (int index = 0; index < size; index++) {
            container[index] = !container[index];
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (boolean elem: container) {
            stringBuilder.append(elem ? 1 : 0);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof BitSet) {
            BitSet bitSet = (BitSet) obj;
            return Arrays.equals(bitSet.container,container);
        }
        return false;
    }

    @Override
    public java.util.Iterator<Integer> iterator() {
        return new Iterator();
    }


    class Iterator implements java.util.Iterator<Integer> {

        int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Integer next() {
            Integer ans = container[current] ? 1 : 0;
            current++;
            return ans;
        }
    }
}






