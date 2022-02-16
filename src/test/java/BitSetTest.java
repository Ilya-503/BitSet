
import org.junit.Test;
import static org.junit.Assert.*;

public class BitSetTest {

    @Test
    public void contains() throws Exception {
        BitSet<String> bitSet = new BitSet<>(4, new String[] {"1","2","1"});
        bitSet.remove("1");
        assertFalse(bitSet.contains("1"));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get() throws Exception {
        BitSet<String> bitSet = new BitSet<>(4);
        bitSet.add("Hello");
        bitSet.add("world");
        bitSet.add("!");
        assertNotEquals(bitSet.get(2),"World");
        bitSet.get(4);
    }

    @Test
    public void intersection() throws Exception {
         BitSet<Integer> bitSet1 = new BitSet<>(4, new Integer[] {1,2,3,4});
         BitSet<Integer> bitSet2 = new BitSet<>(6, new Integer[] {2,4,6,8,10,12});
         assertEquals(bitSet1.intersection(bitSet2), new BitSet<Integer>(2, new Integer[]{2,4}));
    }

    @Test
    public void unification() throws Exception {
        BitSet<String> bitSet1 = new BitSet<>(5,new String[] {"1","2","3","4","5"});
        BitSet<String> bitSet2 = new BitSet<>(5,new String[] {"3","4","5","6","7"});
        assertEquals(bitSet1.unification(bitSet2), new BitSet<>(7,new String[]{"1","2","3","4","5","6","7"}));

        BitSet<String> bitSet3 = new BitSet<>(0,new String[] {});
        BitSet<String> bitSet4 = new BitSet<>(5,new String[] {"Hello","mister!"});
        assertEquals(bitSet3.unification(bitSet4), new BitSet<>(2,new String[] {"Hello","mister!"}));
    }

    @Test
    public void complement() throws Exception {
        BitSet<String> bitSet1 = new BitSet<>(5,new String[] {"1","2","3","4","5"});
        BitSet<String> bitSet2 = new BitSet<>(5,new String[] {"3","4","5","6","7"});
        assertEquals(bitSet1.complement(bitSet2), new BitSet<>(2,new String[]{"1","2"}));
    }

    @Test
    public void iterator() throws Exception {
        BitSet<Character> bitSet = new BitSet<>(4, new Character[]{'j','o','h','n'});
        assertEquals(bitSet.next(), 'j');
        assertEquals(bitSet.next(), 'o');
        assertTrue(bitSet.hasNext());
    }



}
