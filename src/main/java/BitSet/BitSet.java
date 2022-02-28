package BitSet;

import java.util.*;

public class BitSet implements Iterable<Integer> {

    private final int SIZE;
    private final boolean[] container;

    public BitSet(int size) {
        if (size < 0) {
            throw new java.lang.NegativeArraySizeException("Size of bitset can't be negative");
        }
        this.SIZE = size;
        container = new boolean[SIZE];

    }

    private void checkIllegalIndex(int index, String message) {
        if (index >= SIZE) {
            throw new ArrayIndexOutOfBoundsException(message);
        }
    }

    public void set (int index, boolean value) {
        checkIllegalIndex(index, "Index is bigger than bitset SIZE");
        container[index] = value;
    }

    public void set (int fromIndex, int toIndex, boolean value) {
        checkIllegalIndex(fromIndex, "Start index is bigger than bitset SIZE");
        checkIllegalIndex(toIndex, "End index is bigger than bitset SIZE");

        for (int index = fromIndex; index <= toIndex; index++) {
            container[index] = value;
        }
    }

    public int get (int index) {
        checkIllegalIndex(index, "Index is bigger than bitset SIZE");
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

    public int hashCode() {
        int result = SIZE;
        for(int index = 0; index < SIZE; index++) {
            result += container[index]? 31 % index : 0;
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






