package genericMethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SwapTest {

    @Test
    void testInt()
    {
        Integer[] testArray = new Integer[3];
        testArray[0] = 1;
        testArray[1] = 2;
        testArray[2] = 3;
        Swap.swap(testArray, 0, 2);
        assertEquals(testArray[0], 3);

    }
}
