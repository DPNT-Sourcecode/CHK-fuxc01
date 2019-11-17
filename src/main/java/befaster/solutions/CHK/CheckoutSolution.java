package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

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
        priceMap.put('L', 90);
        priceMap.put('M', 15);
        priceMap.put('N', 40);
        priceMap.put('O', 10);
        priceMap.put('P', 50);
        priceMap.put('Q', 30);
        priceMap.put('R', 50);
        priceMap.put('S', 30);
        priceMap.put('T', 20);
        priceMap.put('U', 40);
        priceMap.put('V', 50);
        priceMap.put('W', 20);
        priceMap.put('X', 90);
        priceMap.put('Y', 10);
        priceMap.put('Z', 50);
        Map<Character, Integer> counter = new HashMap<>();

        Map<Character, PriceDiscounter> priceDiscounters = initDiscounterMap();

        for (int i = 0; i < skus.length(); i++) {
            Character sku = skus.charAt(i);
            if (priceMap.containsKey(sku)) {
                counter.put(sku, counter.getOrDefault(sku, 0) + 1);
            } else {
                return -1;
            }
        }

        applyQuantityDiscounters(counter);

        int sum = counter.entrySet().stream()
                .mapToInt(e -> priceMap.get(e.getKey()) * e.getValue())
                .sum();

        // apply all discounts
        sum -= priceDiscounters.values().stream()
                .mapToInt(e -> e.getDiscount(counter))
                .sum();

        return sum;
    }

    private Map<Character, PriceDiscounter> initDiscounterMap() {
        Map<Character, PriceDiscounter> discounterMap = new HashMap<>();
        discounterMap.put('A', new PriceDiscounter('A', asList(5, 3), asList(50, 20)));
        discounterMap.put('B', new PriceDiscounter('B', asList(2), asList(15)));
        discounterMap.put('F', new PriceDiscounter('F', asList(3), asList(10)));
        discounterMap.put('H', new PriceDiscounter('H', asList(10, 5), asList(20, 5)));
        discounterMap.put('K', new PriceDiscounter('K', asList(2), asList(10)));
        discounterMap.put('P', new PriceDiscounter('P', asList(5), asList(50)));
        discounterMap.put('Q', new PriceDiscounter('Q', asList(3), asList(10)));
        discounterMap.put('U', new PriceDiscounter('U', asList(4), asList(40)));
        discounterMap.put('V', new PriceDiscounter('U', asList(3, 2), asList(20, 10)));
        return discounterMap;
    }

    private void applyQuantityDiscounters(Map<Character, Integer> counter) {
        Stream.of(
                new QuantityDiscounter('E', 'B', 2),
                new QuantityDiscounter('N', 'M', 3),
                new QuantityDiscounter('R', 'Q', 3))
                .forEach(d -> d.computeUpdatedCounter(counter));
    }
}




