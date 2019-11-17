package befaster.solutions.CHK;

import java.util.*;
import java.util.stream.Collectors;

public class GroupDiscounter {

    private final Set<Character> items;
    private final int quantity;
    private final int bundlePrice;

    public GroupDiscounter(List<Character> items, int quantity, int bundlePrice) {
        this.items = new HashSet<>(items);
        this.quantity = quantity;
        this.bundlePrice = bundlePrice;
    }

    public int getTotalPrice(Map<Character, Integer> counter, Map<Character, Integer> priceMap) {
        List<Character> sortedItems = items.stream()
                .filter(priceMap::containsKey)
                .sorted(Comparator.comparingInt(priceMap::get).reversed())
                .collect(Collectors.toList());
        int residualItems = 0;
        int total = 0;
        for (Character item : sortedItems) {
            int numItems = residualItems + counter.getOrDefault(item, 0);
            total += (numItems / quantity) * bundlePrice;
            residualItems = numItems % quantity;
        }

        int regularPrices = 0;
        for (int i = sortedItems.size() - 1; i >= 0; i++) {
            Character product = sortedItems.get(i);
            int productCount = counter.getOrDefault(product, 0);
            regularPrices += priceMap.get(product) * Math.min(residualItems, productCount);
            residualItems -= productCount;
            if (residualItems <= 0) {
                break;
            }
        }
        return total + regularPrices;
    }

    public boolean isInGroup(Character product) {
        return items.contains(product);
    }
}
