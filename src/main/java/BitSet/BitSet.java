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

    private void checkIllegalIndex(int index, String valueName) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(valueName + " can't be negative");
        }
        if (index >= SIZE) {
            throw new ArrayIndexOutOfBoundsException(valueName + " is bigger than bitset size");
        }
    }

    private void checkBitSetsSizes(BitSet bitSet) throws Exception {
        if (SIZE != bitSet.SIZE) {
            throw new Exception("bitsets have different SIZE");
        }
    }

    public void set (int index, boolean value) {
        checkIllegalIndex(index, "Index");
        container[index] = value;
    }

    public void set (int fromIndex, int toIndex, boolean value) {
        checkIllegalIndex(fromIndex, "Start index");
        checkIllegalIndex(toIndex, "End index");
        for (int index = fromIndex; index <= toIndex; index++) {
            container[index] = value;
        }
    }

    public int get (int index) {
        checkIllegalIndex(index, "Index");
        return container[index] ? 1 : 0;
    }

    public void and (BitSet bitSet) throws Exception {
        checkBitSetsSizes(bitSet);
        for (int index = 0; index < SIZE; index++) {
            container[index] = container[index] && bitSet.container[index];
        }
    }

    public void or (BitSet bitSet) throws Exception {
        checkBitSetsSizes(bitSet);
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
        long tmp;
        for(int index = 0; index < SIZE; index++) {
            if (container[index]) {
                tmp = Double.doubleToLongBits(index);
                tmp = tmp << 3;
                result += tmp % 100;
            }
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






