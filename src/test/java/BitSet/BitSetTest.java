package BitSet;

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
        assertEquals("10101", bitSet.toString());
    }

    @Test
    public void get() {
        BitSet bitSet = new BitSet(5);
        bitSet.set(1,true);
        assertEquals(0, bitSet.get(0));
        assertEquals(1, bitSet.get(1));
        bitSet.set(3,0,true);
        assertEquals("01000", bitSet.toString());
    }

    @Test
    public void and() throws Exception {
        BitSet bitSet1 = new BitSet(5);
        BitSet bitSet2 = new BitSet(5);

        bitSet1.set(0,3,true);
        bitSet2.set(2,4,true);
        bitSet1.and(bitSet2);
        assertEquals("00110", bitSet1.toString());

        bitSet1.set(0,4,false);
        bitSet2.set(4,false);
        assertEquals("00110", bitSet2.toString());
        bitSet2.and(bitSet1);
        assertEquals("00000", bitSet2.toString());
    }

    @Test (expected = Exception.class)
    public void or() throws Exception {
        BitSet bitSet1 = new BitSet(5);
        BitSet bitSet2 = new BitSet(5);

        bitSet1.set(0,3,true);
        bitSet2.set(2,3,true);
        bitSet1.or(bitSet2);
        assertEquals("11110", bitSet1.toString());

        bitSet1.set(1,2,false);
        bitSet1.or(new BitSet(5));
        assertEquals("10010", bitSet1.toString());

        BitSet bitSet3 = new BitSet(3);
        bitSet1.or(bitSet3);
    }

    @Test
    public void not() {
        BitSet bitSet1 = new BitSet(5);

        bitSet1.set(0,3,true);
        bitSet1.not();
        assertEquals("00001", bitSet1.toString());

        bitSet1.set(0,true);
        bitSet1.set(4,false);
        bitSet1.not();
        assertEquals("01111",bitSet1.toString());
    }

    @Test
    public void iterator() {
        BitSet bitSet1 = new BitSet(5);
        bitSet1.set(1,true);
        Iterator<Integer> iterator = bitSet1.iterator();

        assertEquals((Integer) 0, iterator.next());
        assertEquals((Integer) 1, iterator.next());
        assertTrue(iterator.hasNext());
    }

    @Test
    public void operations() throws Exception {

        BitSet bitSet1 = new BitSet(5);
        BitSet bitSet2 = new BitSet(5);

        bitSet1.set(2,4,true);
        bitSet2.or(bitSet1);
        assertEquals(1, bitSet2.get(2));
        assertEquals("00111", bitSet2.toString());

        bitSet1.or(bitSet1);
        assertEquals("00111", bitSet1.toString());

        bitSet2.set(4,false);
        bitSet2.not();
        assertEquals(bitSet2.toString(), "11001");
    }
}
