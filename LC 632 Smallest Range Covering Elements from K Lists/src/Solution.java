import java.text.CollationElementIterator;
import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // space complexity: n = nums.size() (pq)
        // time complexity: mnlogn (sorting)
        int[] ans = new int[2];
        int max = Integer.MIN_VALUE;
        int pq_range = Integer.MAX_VALUE;
        //pq: number, list number, list index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[] {nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (pq_range != 0) {
            int[] iterator = pq.poll();
            if (max - iterator[0] < pq_range) {
                pq_range = max - iterator[0];
                ans[0] = iterator[0];
                ans[1] = max;
            }
            if (nums.get(iterator[1]).size() == (iterator[2] + 1)) {
                break;
            }
            int[] next = new int[] {nums.get(iterator[1]).get(iterator[2] + 1), iterator[1], iterator[2] + 1};
            max = Math.max(max, next[0]);
            pq.offer(next);

        }

        return ans;


//        HashMap<Integer, Integer> map = new HashMap<>(); //each number -> list
//        HashMap<Integer, Integer> window = new HashMap<>(); // list -> how many list
//        List<Integer> pq = new LinkedList<>();
//        int size = nums.size();
//        int[] ans = new int[2];
//        for (int i = 0; i < nums.size(); i++) {
//            for (Integer eachNumber: nums.get(i)) {
//                map.put(eachNumber, i);
//                pq.add(eachNumber);
//            }
//        }
//        Collections.sort(pq, (a,b) -> (a - b));
//        int left = 0;
//        int right = 0;
//        int count = 0;
//        int diff = 0;
//        while (count < size) {
//            if (map.containsKey(right)) {
//                if (!window.containsKey(map.get(right))) {
//                    count++;
//                }
//                window.put(map.get(right), window.getOrDefault(map.get(right), 0) + 1);
//            }
//            diff++;
//            right++;
//        }
//        diff--;
//        right--;
//        ans[0] = left;
//        ans[1] = right;
//        while (right < pq.get(pq.size() - 1)) {
//            while ((map.containsKey(left) && window.get(map.get(left)) > 1) || (!map.containsKey(left))) {
//                left++;
//                if (map.containsKey(left) && window.get(map.get(left)) > 1) {
//                    window.put(map.get(left), window.get(map.get(left)) - 1);
//                }
//            }
//            diff = right - left;
//            if (diff < ans[1] - ans[0]) {
//                ans[0] = left;
//                ans[1] = right;
//            }
//            right++;
//            if (map.containsKey(right)) {
//                window.put(map.get(right), window.get(map.get(right)) + 1);
//            }
//        }
//
//        return ans;
    }
}