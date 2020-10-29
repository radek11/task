package task.senior.softengineer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class DivisorsFinderTest {

    @Test
    void isDivisor() {
        DivisorsFinder divisorsFinder = new DivisorsFinder();
        assertTrue(divisorsFinder.isDivisor(1, 1));
        assertTrue(divisorsFinder.isDivisor(6, 6));
        assertTrue(divisorsFinder.isDivisor(6, 1));
        assertTrue(divisorsFinder.isDivisor(6, 3));
        assertTrue(divisorsFinder.isDivisor(6, 2));
        assertFalse(divisorsFinder.isDivisor(6, 4));
        assertFalse(divisorsFinder.isDivisor(5, 2));
        assertFalse(divisorsFinder.isDivisor(2, 5));
        assertTrue(divisorsFinder.isDivisor(-1, 1));
    }

    @Test
    void findDivisorsForNumber() {
        DivisorsFinder divisorsFinder = new DivisorsFinder();
        assertArrayEquals(new Integer[]{1}, divisorsFinder.findDivisorsForNumberInRange(1, 1, 20).boxed().toArray());
        assertArrayEquals(Arrays.asList(1, 2, 4, 5, 10, 20).toArray(), divisorsFinder.findDivisorsForNumberInRange(20, 1, 20).boxed().toArray());
        assertArrayEquals(Arrays.asList(1, 13).toArray(), divisorsFinder.findDivisorsForNumberInRange(13, 1, 20).boxed().toArray());
        assertArrayEquals(Arrays.asList(1, 3, 5, 15).toArray(), divisorsFinder.findDivisorsForNumberInRange(15, 1, 20).boxed().toArray());
        assertArrayEquals(Arrays.asList(1, 3, 5, 15).toArray(), divisorsFinder.findDivisorsForNumberInRange(15, 1, 20).boxed().toArray());
    }
}