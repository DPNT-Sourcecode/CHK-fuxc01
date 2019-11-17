package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

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
        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < skus.length(); i++) {
            Character sku = skus.charAt(i);
            if (priceMap.containsKey(sku)) {
                counter.put(sku, counter.getOrDefault(sku, 0) + 1);
            } else {
                return -1;
            }
        }

        // discount for E & B
        if (counter.containsKey('B')) {
            int freeBs = counter.getOrDefault('E', 0) / 2;
            counter.put('B', Math.max(0, counter.get('B') - freeBs));
        }

        int sum = counter.entrySet().stream()
                .mapToInt(e -> priceMap.get(e.getKey()) * e.getValue())
                .sum();

        // discount for A
        if (counter.containsKey('A')) {
            sum -= (counter.get('A') / 5) * 50;
            sum -= ((counter.get('A') % 5) / 3) * 20;
        }

            //discount for B
        sum -= (counter.getOrDefault('B', 0) / 2) * 15;
        return sum;
    }
}

