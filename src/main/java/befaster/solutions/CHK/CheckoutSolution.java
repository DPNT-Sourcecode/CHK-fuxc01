package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Map<Character, Integer> priceMap = new HashMap<>();
        priceMap.put('A', 50);
        priceMap.put('B', 30);
        priceMap.put('C', 20);
        priceMap.put('D', 15);
        Map<Character, Integer> counter = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < skus.length(); i++) {
            Character sku = skus.charAt(i);
            if (priceMap.containsKey(sku)) {
                counter.put(sku, counter.getOrDefault(sku, 0) + 1);
                sum += priceMap.get(sku);
            }
        }

        // discount for A
        sum -= (counter.getOrDefault('A', 0) / 3) * 20;

        //discount for B
        sum -= (counter.getOrDefault('B', 0) / 2) * 15;

        return sum;
    }
}
