import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

class SmallestInfiniteSet {

    private int minExits;

    private TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        minExits = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        int ret;
        Integer temp = set.floor(minExits);
        if (temp != null) {
            ret = set.pollFirst();
        } else {
            ret = minExits++;
        }
        return ret;
    }

    public void addBack(int num) {
        if (num < minExits) {
            set.add(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
    }
}