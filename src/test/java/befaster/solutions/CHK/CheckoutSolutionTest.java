package befaster.solutions.CHK;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutSolutionTest {

    @Test
    public void AAATest() {
        int sum = new CheckoutSolution().checkout("AAA");
        assertEquals(130, sum);
    }

    @Test
    public void BBTest() {
        int sum = new CheckoutSolution().checkout("BB");
        assertEquals(45, sum);
    }


    @Test
    public void ABCDTest() {
        int sum = new CheckoutSolution().checkout("ABCD");
        assertEquals(115, sum);
    }
    @Test
    public void AAAABCDTest() {
        int sum = new CheckoutSolution().checkout("AAAABCD");
        assertEquals(245, sum);
    }

    @Test
    public void emptyTest() {
        int sum = new CheckoutSolution().checkout("");
        assertEquals(0, sum);
    }
    @Test
    public void nullTest() {
        int sum = new CheckoutSolution().checkout(null);
        assertEquals(0, sum);
    }
}