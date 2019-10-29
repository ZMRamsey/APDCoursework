package unaryPredicate;

/**
 * An alternate version of IsEven
 *
 * IsOdd implements an integer version of Unary Predicate
 *
 * test returns whether an integer is odd
 */

public class IsOdd implements UnaryPredicate<Integer> {

    /**
     *
     * @param n the number to be tested
     * @return true if object is odd
     */
    @Override
    public boolean test(Integer n) { return n % 2 != 0; }
}
