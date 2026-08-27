void main() {
    /// Algorithm 1, The Euclidean Algorithm

    // TEST 1, 2 REGULAR NUMBERS
    System.out.println(Algorithms.gcd(105, 42));

    // TEST 2, 2 PRIME NUMBERS
    System.out.println(Algorithms.gcd(23, 13));

    // TEST 3, 2 MULTIPLES
    System.out.println(Algorithms.gcd(16, 8));

    // TEST 4, 2 REGULAR NUMBERS
    System.out.println(Algorithms.gcd(64, 24));

    /// Algorithm 2, The Sieve of Eratosthenes

    // TEST 1, n = 10
    System.out.println(Algorithms.sieve(10));

    // TEST 2, n = 50
    System.out.println(Algorithms.sieve(50));

    // TEST 3, n = 100
    System.out.println(Algorithms.sieve(100));

    /// Algorithm 3, Modular Exponentiation

    // TEST 1, 3^13 mod 50
    System.out.println(Algorithms.modExp(3, 13, 50));

    /// Algorithm 4, Diffie-Hellman Exchange

    // TEST SCENARIO, ALICE AND BOB SHARE A SECRET

    // Firstly, both parties agree on and transmit a base and a prime over a public channel.

    int p = 46340; // Our prime modulus. Our secret will take on values between 1 and p - 1. Largest modulus we can use is 46340
    int g = 250000; // Our shared, public base g, a large number

    // Both parties now choose some secret, large exponents

    int a = 300000; // Alice's secret exponent a, a large number
    int b = 200000; // Bob's secret exponent b, a large number

    // Both parties calculate and transmit their own values of g^(secret exponent) mod p

    int A = Algorithms.computeSharedSecret(g,a, p); // Alice calculates her value g^(a) mod p
    int B = Algorithms.computeSharedSecret(g,b, p); // Bob calculates his own value g^(b) mod p

    System.out.println("A = " + A + " (Public)");
    System.out.println("B = " + B +" (Public)");

    // Both have received one another's values and will now compute the secret given by:
    // (g^(secret exponent) mod p)^(secret exponent) mod p

    int s1 = Algorithms.computeSharedSecret(B, a, p); // secret 1 = B^(a) mod p
    int s2 = Algorithms.computeSharedSecret(A, b, p); // secret 2 = A^(b) mod p

    // Alice and Bob have now shared a secret value.
    // So the values s1 and s2 must be equal:
    System.out.println("Secret 1 = " + s1);
    System.out.println("Secret 2 = " + s2);
    System.out.println(Objects.equals(s1,s2));


}
