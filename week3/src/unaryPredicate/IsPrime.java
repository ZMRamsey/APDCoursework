package unaryPredicate;

/**
 * A unary predicate to test if a number is prime
 * Implements an integer unary predicate
 * test method returns if a number is a prime
 */
public class IsPrime implements UnaryPredicate<Integer> {

    /**
     * @param n the number to be tested
     * @return true if number is prime
     */
    @Override
    public boolean test(Integer n) {
        if (n > 0) {
            if (n <= 2) {
                return n != 1;
            } else {
                if (n % 2 != 0) {
                    for (int i = 3; i < java.lang.Math.sqrt(n); n++)
                    {
                        if (n % i == 0)
                        {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
        else { return false; }
    }
}
