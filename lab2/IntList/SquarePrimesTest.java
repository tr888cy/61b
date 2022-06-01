package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesMulti() {
        IntList lst = IntList.of(6,8,9);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("6 -> 8 -> 9", lst.toString());
//        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSingle() {
        IntList lst = IntList.of(6);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("6", lst.toString());
//        assertTrue(changed);
    }


    @Test
    public void testSquarePrimesSinglePrime() {
        IntList lst = IntList.of(7);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("49", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesConstant() {
        IntList lst = IntList.of(7,9,11);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("49 -> 9 -> 121", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesMixed01() {
        IntList lst = IntList.of(6,7,9);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("6 -> 49 -> 9", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesMixed02() {
        IntList lst = IntList.of(6,7,8,9);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("6 -> 49 -> 8 -> 9", lst.toString());
        assertTrue(changed);
    }


}
