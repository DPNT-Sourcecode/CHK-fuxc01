package befaster.solutions.CHK;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutSolutionTest {

    @Test
    public void checkout() {
        int sum = new CheckoutSolution().checkout("AAA");
        assertEquals(130, sum);
    }
}