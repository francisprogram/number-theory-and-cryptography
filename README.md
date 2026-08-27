# number-theory-and-cryptography - Number Theory and Cryptography Coursework

This project gives both high-level and mathematical explanations for four algorithms in number theory and cryptography. The project focusses on fully understanding the mechanics that allow each algorithm to achieve its goal both securely and importantly, more efficiently than the naïve solution. The implementation aims to build the algorithms from scratch rather than reliance on pre-existing libraries.

The project implements:
* The Euclidean Algorithm
* The Sieve of Eratosthenes
* Modular Exponentiation
* Diffie–Hellman Key Exchange

Each algorithm is implemented in Algorithms.java and run/tested in Main.java.

# Algorithms

1) The Euclidean Algorithm

The method gcd(a, b), aims to find the greatest common divisor between 2 numbers using The Euclidean Algorithm. The algorithm itself calculates the remainder between each number repeatedly until a remainder of 0 is reached.

Algorithms.gcd(105, 42);


2) The Sieve of Eratosthenes

The method sieve(n) calculates all the prime numbers up to and including n, provided n is greater than 1. The algorithm iterates through each uncancelled number squared (k^2) and cancels multiples of that number up to and including n. This leaves only the prime numbers.

Algorithms.sieve(20);


3) Modular Exponentiation

The method modExp(base, exponent, modulo) calculates the value of (b^e mod m) where b, e and m can all be very large numbers. The algorithm processes the exponent in its binary form multiplying into a result based on which bits are active.

Algorithms.modExp(5000, 2500, 600);


4) Diffie-Hellman Key Exchange

The method computeSharedSecret(g, a, p) calculates the value of g^a mod p for use in producing a Diffie-Hellman Key Exchange.

Imagine 2 parties Alice and Bob attempting to communicate a secret over an unsecure, public channel with intercepting eavesdroppers. Both agree on a public base g and prime p. They then choose their own secret numbers A and B. Each party will calculate g^(secret number) mod p and exchange that value. They will then calculate g^(secret number) mod p with the value they recieved and the result of that calculation will be a secret value they both share, but the eavesdropper does not know and cannot calculate.

Algorithms computeSharedSecret(6000, 2048, 1700);


# Requirements
* Java Development Kit (JDK)
* A Java-compatible IDE or terminal

# Running the Project

Clone the repository and navigate to the project directory.

Compile the Java files:

javac Algorithms.java Main.java

Then run the program:

java Main

Depending on the Java version being used, Main.java may require a standard Java public static void main(String[] args) entry point.

# Notes

This project is intended as an implementation and demonstration of the algorithms rather than a production-ready cryptographic library.

In particular, the Diffie–Hellman implementation is a demonstration of the mathematical key-exchange process and should not be used as a secure cryptographic implementation for real-world applications.

The modular exponentiation implementation currently uses Java int values, which limits the range of values that can be processed.

# Author

University coursework project implemented in Java by Francis Obioha Agwanihu.

