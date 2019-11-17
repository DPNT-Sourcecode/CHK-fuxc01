package befaster.solutions.CHK;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupDiscounter {

    private final List<Character> items;
    private int quantity;
    private int price;

    public GroupDiscounter(List<Character> items) {
        this.items = items;
    }

    public int getTotalPrice(Map<Character, Integer> counter, Map<Character, Integer> priceMap) {
        List<Character> sortedItems = items.stream()
                .sorted(Comparator.comparingInt(priceMap::get).reversed())
                .collect(Collectors.toList());
        int residualItems = 0;
        int regularPriceSum = 0;
        int total = 0;
        for (Character item: sortedItems) {
            total += (counter.getOrDefault(item, 0) / quantity) *
        }
        return total;
    }
}

