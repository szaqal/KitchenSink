package szaqal.alg.demo.search;

public class BinarySearch {

    public static boolean find(int[] values, int target, int low, int high) {
        if (low > high) {
            return false;
        }
        int midIdx = (int) (double) ( (low + high) / 2);
        if (values[midIdx] == target) {
            return true;
        } else if (values[midIdx] > target) {
            return find(values, target, low, midIdx - 1);
        } else if (values[midIdx] < target) {
            return find(values, target, midIdx + 1, high);
        }
        return false;
    }
}
