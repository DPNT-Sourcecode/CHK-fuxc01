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
        priceMap.put('G', 20);
        priceMap.put('H', 10);
        priceMap.put('I', 35);
        priceMap.put('J', 60);
        priceMap.put('K', 80);
        Map<Character, Integer> counter = new HashMap<>();

        Map<Character, Discounter> discounterMap = initDiscounterMap();

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

        // apply all discounts
        sum -= discounterMap.values().stream()
                .mapToInt(e -> e.getDiscount(counter))
                .sum();

        return sum;
    }

    private Map<Character, Discounter> initDiscounterMap() {
        Map<Character, Discounter> discounterMap = new HashMap<>();
        discounterMap.put('A', new BundleDiscounter('A', asList(5, 3), asList(50, 20)));
        discounterMap.put('B', new BundleDiscounter('B', asList(2), asList(15)));
        discounterMap.put('F', new BundleDiscounter('F', asList(3), asList(10)));
        discounterMap.put('H', new BundleDiscounter('F', asList(10, 5), asList(20, 5)));
        discounterMap.put('K', new BundleDiscounter('F', asList(2), asList(10)));
        return discounterMap;
    }

    private void discountE(Map<Character, Integer> counter) {
        if (counter.containsKey('B')) {
            int freeBs = counter.getOrDefault('E', 0) / 2;
            counter.put('B', Math.max(0, counter.get('B') - freeBs));
        }
    }
}
