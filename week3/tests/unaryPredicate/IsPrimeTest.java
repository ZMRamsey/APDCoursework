package unaryPredicate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPrimeTest {

    private IsPrime predicate = new IsPrime();

    @Test
    void testOne(){assertFalse(predicate.test(1));}

    @Test
    void testTwo(){assertTrue(predicate.test(2));}

    @Test
    void testThree(){assertTrue(predicate.test(3));}

    @Test
    void testTwenty(){assertFalse(predicate.test(20));}

    @Test
    void testSeventyThree(){assertTrue(predicate.test(73));}

    @Test
    void testSixThreeOne(){assertTrue(predicate.test(631));}

    @Test
    void testMinusFive(){assertFalse(predicate.test(-5));}
}
