package befaster.solutions.CHK;

import java.util.Map;

public class QuantityDiscounter {

    private final char toReduce;
    private final char toBuy;
    private final int quantity;

    public QuantityDiscounter(char toBuy, char toReduce, int quantity) {
        this.toReduce = toReduce;
        this.toBuy = toBuy;
        this.quantity = quantity;
    }

    public void computeUpdatedCounter(Map<Character, Integer> counter) {
        if (counter.containsKey(toReduce)) {
            int freeBs = counter.getOrDefault(toBuy, 0) / quantity;
            counter.put(toReduce, Math.max(0, counter.get(toReduce) - freeBs));
        }
    }
}

