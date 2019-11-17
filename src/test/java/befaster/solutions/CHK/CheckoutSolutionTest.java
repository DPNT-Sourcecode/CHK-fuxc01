package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutSolutionTest {

    private CheckoutSolution solution;

    @Before
    public void setUp() {
        solution = new CheckoutSolution();
    }

    @Test
    public void AAATest() {
        int sum = solution.checkout("AAA");
        assertEquals(130, sum);
    }

    @Test
    public void BBTest() {
        int sum = solution.checkout("BB");
        assertEquals(45, sum);
    }


    @Test
    public void ABCDTest() {
        int sum = solution.checkout("ABCD");
        assertEquals(115, sum);
    }

    @Test
    public void AAAABCDTest() {
        int sum = solution.checkout("AAAABCD");
        assertEquals(245, sum);
    }

    @Test
    public void emptyTest() {
        int sum = solution.checkout("");
        assertEquals(0, sum);
    }

    @Test
    public void nullTest() {
        int sum = solution.checkout(null);
        assertEquals(0, sum);
    }

    @Test
    public void invalidTest() {
        int sum = solution.checkout("a");
        assertEquals(-1, sum);
        sum = solution.checkout("-");
        assertEquals(-1, sum);
    }

    @Test
    public void buy2ETest() {
        int sum = solution.checkout("EEB");
        assertEquals(80, sum);
    }

    @Test
    public void EEBBTest() {
        int sum = solution.checkout("EEBB");
        assertEquals(110, sum);
    }

    @Test
    public void A5Test() {
        int sum = solution.checkout("AAAAA");
        assertEquals(200, sum);
        sum = solution.checkout("AAAAAA");
        assertEquals(250, sum);
        sum = solution.checkout("AAAAAAA");
        assertEquals(300, sum);
        sum = solution.checkout("AAAAAAAA");
        assertEquals(330, sum);
    }

    @Test
    public void FFFTest() {
        int sum = solution.checkout("FFF");
        assertEquals(20, sum);
        sum = solution.checkout("FF");
        assertEquals(20, sum);
        sum = solution.checkout("FFFF");
        assertEquals(30, sum);
    }
}