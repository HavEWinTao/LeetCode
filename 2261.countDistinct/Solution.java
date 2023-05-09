import java.util.*;

public class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<Integer> num = new HashSet<>();
        for (int number : nums) {
            num.add(number);
        }
        int n = nums.length;
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] % p == 0) {
                index.add(i);
            }
        }
        int indexSize = index.size();
        Map<Integer, List<Integer[]>> subArrays = new HashMap<>();

        int leftBound;
        int rightBound;

        if (indexSize == 0) {
            leftBound = 0;
            rightBound = n - 1;
            for (int iter1 = leftBound; iter1 <= rightBound; iter1++) {
                for (int iter2 = iter1; iter2 <= rightBound; iter2++) {
                    addArray(nums, subArrays, iter1, iter2);
                }
            }
        } else if (indexSize == 1) {
            if (k >= 1) {
                leftBound = 0;
                rightBound = n - 1;
                for (int iter1 = leftBound; iter1 <= rightBound; iter1++) {
                    for (int iter2 = iter1; iter2 <= rightBound; iter2++) {
                        addArray(nums, subArrays, iter1, iter2);
                    }
                }
            } else {
                leftBound = 0;
                int midIndex = index.get(0);
                rightBound = n - 1;
                for (int iter1 = leftBound; iter1 < midIndex; iter1++) {
                    for (int iter2 = iter1; iter2 < midIndex; iter2++) {
                        addArray(nums, subArrays, iter1, iter2);
                    }
                }
                for (int iter1 = midIndex + 1; iter1 <= rightBound; iter1++) {
                    for (int iter2 = iter1; iter2 <= rightBound; iter2++) {
                        addArray(nums, subArrays, iter1, iter2);
                    }
                }
            }
        } else {
            for (int i = 1; i <= k; i++) {
                int right = indexSize - i;
                for (int j = 0; j <= right; j++) {
                    int leftIndex = j - 1 >= 0 ? index.get(j - 1) + 1 : 0;
                    leftBound = index.get(j);
                    rightBound = index.get(j + i - 1);
                    int rightIndex = j + i <= indexSize - 1 ? index.get(j + i) - 1 : n - 1;
                    for (int iter1 = leftIndex; iter1 <= leftBound; iter1++) {
                        for (int iter2 = rightIndex; iter2 >= rightBound; iter2--) {
                            addArray(nums, subArrays, iter1, iter2);
                        }
                    }
                }
            }
            for (int j=0;j<=indexSize-2;j++) {
                leftBound = index.get(j) + 1;
                rightBound = index.get(j + 1) - 1;
                for (int iter1 = leftBound; iter1 <= rightBound; iter1++) {
                    for (int iter2 = iter1; iter2 <= rightBound; iter2++) {
                        addArray(nums, subArrays, iter1, iter2);
                    }
                }
            }
            leftBound = 0;
            rightBound = index.get(0) - 1;
            for (int iter1 = leftBound; iter1 <= rightBound; iter1++) {
                for (int iter2 = iter1; iter2 <= rightBound; iter2++) {
                    addArray(nums, subArrays, iter1, iter2);
                }
            }
            leftBound = index.get(indexSize - 1) + 1;
            rightBound = n - 1;
            for (int iter1 = leftBound; iter1 <= rightBound; iter1++) {
                for (int iter2 = iter1; iter2 <= rightBound; iter2++) {
                    addArray(nums, subArrays, iter1, iter2);
                }
            }
        }

        int sum = 0;
        Set<Integer> keys = subArrays.keySet();
        for (int key : keys) {
            List<Integer[]> temp = subArrays.get(key);
            for (int i = 0; i < temp.size() - 1; i++) {
                for (int j = i + 1; j < temp.size(); j++) {
                    Integer[] a = temp.get(i);
                    Integer[] b = temp.get(j);
                    if (Objects.equals(a[key], b[key])) {
                        if (isSame(a, b)) {
                            temp.remove(j);
                            j--;
                        }
                    }
                }
            }
            sum += temp.size();
        }
        return sum;
    }

    private void addArray(int[] nums, Map<Integer, List<Integer[]>> subArrays, int iter1, int iter2) {
        int sum = 0;
        Integer[] subarray = new Integer[iter2 - iter1 + 2];
        for (int it = iter1; it <= iter2; it++) {
            sum += nums[it];
            subarray[it - iter1] = nums[it];
        }
        subarray[iter2 - iter1 + 1] = sum;
        List<Integer[]> arrays;
        if (subArrays.containsKey(iter2 - iter1 + 1)) {
            arrays = subArrays.get(iter2 - iter1 + 1);
        } else {
            arrays = new ArrayList<>();
        }
        arrays.add(subarray);
        subArrays.put(iter2 - iter1 + 1, arrays);
    }

    private boolean isSame(Integer[] a, Integer[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (!Objects.equals(a[i], b[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{10, 2, 17, 7, 20};
        System.out.println(solution.countDistinct(nums, 1, 10));
    }
}
