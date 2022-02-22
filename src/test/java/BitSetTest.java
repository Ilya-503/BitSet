


import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.*;

public class BitSetTest {

    @Test
    public void set() {
        BitSet bitSet = new BitSet(5);
        bitSet.set(2,4,true);
        bitSet.set(3,false);
        bitSet.set(0,true);
        assertEquals(bitSet.toString(), "10101");
    }

    @Test
    public void get() {
        BitSet bitSet = new BitSet(3);
        bitSet.set(1,true);
        assertEquals(bitSet.get(0),0);
        assertEquals(bitSet.get(1),1);
    }

    @Test
    public void and() throws Exception {
        BitSet bitSet1 = new BitSet(5);
        BitSet bitSet2 = new BitSet(5);

        bitSet1.set(0,3,true);
        bitSet2.set(2,4,true);
        bitSet1.and(bitSet2);

        assertEquals(bitSet1.toString(), "00110");

    }

    @Test (expected = Exception.class)
    public void or() throws Exception {
        BitSet bitSet1 = new BitSet(5);
        BitSet bitSet2 = new BitSet(5);

        bitSet1.set(0,3,true);
        bitSet2.set(2,3,true);
        bitSet1.or(bitSet2);

        assertEquals(bitSet1.toString(), "11110");

        BitSet bitSet3 = new BitSet(3);
        bitSet1.or(bitSet3);

    }

    @Test
    public void not() throws Exception {
        BitSet bitSet1 = new BitSet(5);

        bitSet1.set(0,3,true);
        bitSet1.not();

        assertEquals(bitSet1.toString(), "00001");
    }

    @Test
    public void iterator() {
        BitSet bitSet1 = new BitSet(5);
        bitSet1.set(1,true);
        Iterator<Integer> iterator = bitSet1.iterator();

        assertEquals(iterator.next(), (Integer) 0);
        assertEquals(iterator.next(), (Integer) 1);
        assertTrue(iterator.hasNext());

    }


}
