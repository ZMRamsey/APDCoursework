package unaryPredicate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsOddTest {

    private IsOdd predicate = new IsOdd();

    @Test
    void testOne(){assertTrue(predicate.test(1));}

    @Test
    void testTwo(){assertFalse(predicate.test(2));}

    @Test
    void testMinusThree(){assertTrue(predicate.test(-3));}

    @Test
    void testBigOdd(){assertTrue(predicate.test(2*((Integer.MAX_VALUE-1)/2) - 1));}

}
