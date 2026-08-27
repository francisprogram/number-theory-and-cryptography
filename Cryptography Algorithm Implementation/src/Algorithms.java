import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algorithms {

    public static int gcd(int a, int b){

        // We start by initialising a and b, the absolute values of both are taken in order to handle negatives.
        a = Math.abs(a);
        b = Math.abs(b);
        int temp;


        // While loop begins, ending when b = 0, because gcd(x, 0) will always be x (every number divides 0)
        while(b != 0){

            // First calculate (a mod b), replace a with b then replace b with (a mod b).
            // This is gcd(a, b) -> gcd(b, a mod b) and so on
            temp = a % b;

            a = b;
            b = temp;

        }

        return a; // Here, a = g where g divides a and b and is the greatest divisor that does.

    }

    public static List<Integer> sieve(int n){

        if (n < 2){ // If n is less than 2, there are no primes to locate, so we return an empty list.
            return new ArrayList<>();
        }

        List<Boolean> integers = new ArrayList<>(Collections.nCopies(n + 1, true));// Creating an ArrayList from 0 to n + 1, using only indexes 2 up to and including n.
                                                                                        // Includes n + 1 to account for n itself.
        ArrayList<Integer> primes = new ArrayList<Integer>(); // Empty ArrayList we will populate with primes and return as the output.

        double base = 0; // Base variable to track the current base to find multiples of.
        // Using and updating a base variable makes the algorithm simpler and easier to understand.


        for(int i = 2; i < Math.sqrt(n); i++) { // Iterating through bases starting from 2 up to √n, using each to eliminate multiples.

            if (integers.get(i)) { // Check this current integer is not cancelled, if not cancelled, can be used as a base.
                base = Math.pow(i, 2); // Using i² as the base to find multiples from this.

                // Inner loop below used to find multiples. The multiples of i are found by doing:
                // i² + ij where j is an integer > 1 multiplied by i to form a multiple of i.
                // So the loop is implementing the sequence of multiples: i², i² + i, i² + 2i...
                for (double j = 0; base + (i * j) < n + 1; j++) {


                    integers.set((int) (base + (i * j)), false); // Index i² + ij is a multiple of i, therefore, it is toggled to false.

                }
            }
        }

        for(int i = 2; i < n + 1; i++){ // This loop aggregates all the uncancelled numbers from 2 till n, i.e, all the prime numbers.

            if (integers.get(i)) { // If the value at the index is true, we store the value of the index into primes.
                primes.add(i);
            }
        }


        return primes; // Now we can return primes, a collection of primes less than or equal to n.



        }

    public static int modExp(int base, int exp, int mod){

        if (mod <= 0){return -1;} // If m = 0, we get an undefined result due to division by 0.
        if (mod == 1){return 0;} // If m = 1, this is a trivial case that is always equal to 0.
        if (mod > 46340){System.out.println("Unable to compute using int"); return -1;} // When m > 46340, this implementation cannot compute the problem, due to the numerical storage limit of 2^31 - 1 on the int datatype.

        int result = 1; // By default, result is initialised to 1, this is the lowest initial value we can achieve
                        // before the algorithm has executed for the first time because each contribution to the running total
                        // is multiplicative.

        base = base % mod; // base is base^(2^0), the numerical value of the first bit of the exponent and the first possible
                        // element in the sequence of multiplications for base^(exp) mod m. We may not multiply base mod m into
                        // result, however, it is our starting point for base

        while (exp > 0) { // When exp reaches 0, there are no more bits to work with, therefore, we will have fully checked all bits.

            if (exp % 2 == 1){ // exp % 2 checks the least significant bit of the binary representation of exp. If it is 1, we know
                            // the least significant bit is active (1). If it is 0, we know the least significant bit is inactive (0).
                            // The reason exp % 2 does this is because of even or oddness of exp at the time of the check.
                            // When the least significant bit is active, we know it is an even number + 1, meaning odd.
                            // When inactive, we know it is an even number + 0, meaning 0.
                            // We can use this information to know if this bit is active or not

                result = (result * base) % mod; // The current (active) bit is multiplied into our running total.
                                                // This line is performing (a x b) % mod using the identity:
                                                // (a % mod)(b % mod) % mod, where a = result and b = base
            }

            exp = exp / 2; // The least significant bit is then removed by doing a right shift by 1 bit (half the previous value).
                            // If not for '/' performing integer division, we would have to floor exp / 2 in order to discard the bit
                            // that is moving into the fractional part of exp's binary representation, however, it is done already under the hood.

            base = (base * base) % mod; // base is then squared in order to represent the next least significant place in binary
                                        // the modulus is taken in line with the identity (a % mod)(b % mod) % mod.

        }

        return result; // We then return result, the remainder value of base^(exp) % mod where exp can be very large.

    }

    public static int computeSharedSecret(int publicBase, int privateKey, int publicMod){
        return modExp(publicBase,privateKey, publicMod);
    }

}
