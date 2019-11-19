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
                //if n is either 2 or 1, return true for 2, false for 1
                return n == 2;
            } else {
                //Check if even, if it is return false
                if (n % 2 != 0) {
                    //Run through integers from 3 to Sqrt of number to find factors
                    for (int i = 3; i < java.lang.Math.sqrt(n); i++)
                    {
                        //Check if i is a factor of n
                        if (n % i == 0)
                        {
                            return false;
                        }
                    }
                    //If no factors are found, it's prime
                    return true;
                } else {
                    //Return false if even
                    return false;
                }
            }
        }
        //Returns false if less than or equal to 0
        else { return false; }
    }
}
