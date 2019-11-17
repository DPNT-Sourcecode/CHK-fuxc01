package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PriceDiscounter {

    private final List<DiscountSteps> discountSteps = new ArrayList<>();
    private final Character product;

    public PriceDiscounter(Character product, List<Integer> quantities, List<Integer> discounts) {
        this.product = product;
        for (int i = 0; i < quantities.size(); i++) {
            discountSteps.add(new DiscountSteps(quantities.get(i), discounts.get(i)));
        }
    }

    public int getDiscount(Map<Character, Integer> counter) {
        int discount = 0;
        if (counter.containsKey(product)) {
            int quantity = counter.get(product);
            for (DiscountSteps step: discountSteps) {
                discount += (quantity / step.quantity) * step.discount;
                quantity %= step.quantity;
            }
        }
        return discount;
    }

    private static class DiscountSteps {
        final int quantity;
        final int discount;

        private DiscountSteps(int quantity, int discount) {
            this.quantity = quantity;
            this.discount = discount;
        }
    }

}
