package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        if (skus == null) {
            return 0;
        }
        Map<Character, Integer> priceMap = new HashMap<>();
        priceMap.put('A', 50);
        priceMap.put('B', 30);
        priceMap.put('C', 20);
        priceMap.put('D', 15);
        priceMap.put('E', 40);
        priceMap.put('F', 10);
        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < skus.length(); i++) {
            Character sku = skus.charAt(i);
            if (priceMap.containsKey(sku)) {
                counter.put(sku, counter.getOrDefault(sku, 0) + 1);
            } else {
                return -1;
            }
        }

        discountE(counter);

        int sum = counter.entrySet().stream()
                .mapToInt(e -> priceMap.get(e.getKey()) * e.getValue())
                .sum();

        sum -= discountA(counter);
        sum -= discountB(counter);
        sum -= discountF(counter);
        return sum;
    }

    private int discountB(Map<Character, Integer> counter) {
        return (counter.getOrDefault('B', 0) / 2) * 15;
    }

    private int discountF(Map<Character, Integer> counter) {
        BundleDiscounter discounter = new BundleDiscounter('F', asList(3), asList(10));
        return discounter.getDiscount(counter);
    }

    private void discountE(Map<Character, Integer> counter) {
        if (counter.containsKey('B')) {
            int freeBs = counter.getOrDefault('E', 0) / 2;
            counter.put('B', Math.max(0, counter.get('B') - freeBs));
        }
    }

    private int discountA(Map<Character, Integer> counter) {
        BundleDiscounter discounter = new BundleDiscounter('A', asList(5, 3), asList(50, 20));
        return discounter.getDiscount(counter);
    }

}


