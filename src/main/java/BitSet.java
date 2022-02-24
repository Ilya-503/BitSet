import java.util.*;

public class BitSet implements Iterable<Integer> {

    private final int SIZE;
    private final boolean[] container;

    public BitSet(int size) {
        if (BitSet.this.SIZE < 0) {
            throw new java.lang.NegativeArraySizeException("Size of bitset can't be negative");
        } else {
            this.SIZE = size;
            container = new boolean[BitSet.this.SIZE];
        }
    }

    public void set (int index, boolean value) {
        if (index >= SIZE) {
            throw new ArrayIndexOutOfBoundsException("Index is bigger than bitset SIZE");
        }
        container[index] = value;
    }

    public void set (int fromIndex, int toIndex, boolean value) {

        if (fromIndex >= SIZE) {
            throw new ArrayIndexOutOfBoundsException("Start index is bigger than bitset SIZE");
        }

        if (toIndex >= SIZE) {
            throw new ArrayIndexOutOfBoundsException("End index is bigger than bitset SIZE");
        }

        for (int index = fromIndex; index <= toIndex; index++) {
            container[index] = value;
        }
    }

    public int get (int index) {
        if (index >= SIZE) {
            throw new ArrayIndexOutOfBoundsException("Index is bigger than bitset SIZE");
        }
        return container[index] ? 1 : 0;
    }

    public void and (BitSet bitSet) throws Exception {
        if (SIZE != bitSet.SIZE) {
            throw new Exception("bitsets have different SIZE");
        }
        for (int index = 0; index < SIZE; index++) {
            container[index] = container[index] && bitSet.container[index];
        }
    }

    public void or (BitSet bitSet) throws Exception {
        if (SIZE != bitSet.SIZE) {
            throw new Exception("bitsets have different SIZE");
        }
        for (int index = 0; index < SIZE; index++) {
            container[index] = container[index] || bitSet.container[index];
        }
    }

    public void not () {
        for (int index = 0; index < SIZE; index++) {
            container[index] = !container[index];
        }
    }

    @Override
    public int hashCode() {
        int result = SIZE;
        for (int index = 0; index < SIZE; index++) {
            result += (int) Math.pow(2,index);
        }
        return result;
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
            return current < SIZE;
        }

        @Override
        public Integer next() {
            Integer ans = container[current] ? 1 : 0;
            current++;
            return ans;
        }
    }
}






