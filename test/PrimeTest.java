import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @org.junit.jupiter.api.Test
    void isPrime() {
        assertFalse(Prime.isPrime(-1));
        assertFalse(Prime.isPrime(1));
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(5));
        assertTrue(Prime.isPrime(23));
        assertFalse(Prime.isPrime(27));
        assertTrue(Prime.isPrime(29));
        assertTrue(Prime.isPrime(Integer.MAX_VALUE));
        assertFalse(Prime.isPrime(Integer.MAX_VALUE-1));


    }
}