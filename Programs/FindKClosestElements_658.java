import java.util.*;

class FindKClosestElements_658 {
    public static void main(String[] args) {
        FindKClosestElements_658 f = new FindKClosestElements_658();
        System.out.println(f.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int start = 0;
        int end = arr.length - 1;
        while (end - start >= k) {
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++;
            } else {
                end--;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}