package utils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Helpers.
 * @author Juho Hautala
 */
public class HelpersTest {

    @Test
    public void swapShouldSwapElementsInGivenAryAtGivenIndices() {
        int ary[] = {99, 77, 44, 11, 66};
        int expected[] = {11, 44, 77, 66, 99};
        Helpers.swap(ary, 0, 3); // -> {11, 77, 44, 99, 66}
        Helpers.swap(ary, 1, 2); // -> {11, 44, 77, 99, 66}
        Helpers.swap(ary, 3, 4); // -> {11, 44, 77, 66, 99}
        assertArrayEquals(expected, ary);
    }

    @Test
    public void swapShouldSwapElementsWhenGivenIndicesInDifferentOrder() {
        int ary[] = {99, 77, 44, 11, 66};
        int expected[] = {11, 44, 77, 66, 99};
        Helpers.swap(ary, 3, 0); // -> {11, 77, 44, 99, 66}
        Helpers.swap(ary, 2, 1); // -> {11, 44, 77, 99, 66}
        Helpers.swap(ary, 4, 3); // -> {11, 44, 77, 66, 99}
        assertArrayEquals(expected, ary);
    }

    @Test
    public void swapShouldSwapElementsWhenGivenIndicesInDifferentOrderII() {
        Integer ary[] = {99, 77, 44, 11, 66};
        Integer expected[] = {11, 44, 77, 66, 99};
        Helpers.swap(ary, 3, 0); // -> {11, 77, 44, 99, 66}
        Helpers.swap(ary, 2, 1); // -> {11, 44, 77, 99, 66}
        Helpers.swap(ary, 4, 3); // -> {11, 44, 77, 66, 99}
        assertArrayEquals(expected, ary);
    }

}
