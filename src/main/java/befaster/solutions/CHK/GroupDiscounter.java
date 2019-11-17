package befaster.solutions.CHK;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupDiscounter {

    private final List<Character> items;
    private final int quantity;
    private final int bundlePrice;

    public GroupDiscounter(List<Character> items, int quantity, int bundlePrice) {
        this.items = items;
        this.quantity = quantity;
        this.bundlePrice = bundlePrice;
    }

    public int getTotalPrice(Map<Character, Integer> counter, Map<Character, Integer> priceMap) {
        List<Character> sortedItems = items.stream()
                .sorted(Comparator.comparingInt(priceMap::get).reversed())
                .collect(Collectors.toList());
        int residualItems = 0;
        int total = 0;
        for (Character item: sortedItems) {
            int numItems = residualItems + counter.getOrDefault(item, 0);
            total += (numItems / quantity) * bundlePrice;
            residualItems = numItems % quantity;
        }
        int regularPrices = 0;
        for (int i = sortedItems.size()-1; i >= 0; i++) {
            if 
        }
        return total;
    }
}
