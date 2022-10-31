import java.util.*;
import java.util.stream.Collectors;

public class RandomizedSet {

    Random random;
    List<Integer> nums;
    Map<Integer, Integer> index;

    public RandomizedSet() {
        random = new Random();
        nums = new ArrayList<>();
        index = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!index.containsKey(val)) {
            index.put(val, nums.size());
            nums.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (index.containsKey(val)) {
            int itemIndex = index.get(val);
            int swapNum = nums.get(nums.size() - 1);
            nums.set(itemIndex, swapNum);
            nums.remove(nums.size() - 1);
            index.put(swapNum, itemIndex);
            index.remove(val);
            return true;
        }
        return false;
    }

    //只使用set不是O(1)
    public int getRandom() {
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
    }
}
