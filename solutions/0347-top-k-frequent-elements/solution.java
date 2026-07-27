import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        Map<Integer,Integer> freq = new HashMap<>();
        for (int n : nums)
            freq.put(n, freq.getOrDefault(n,0)+1);

        
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a,b) -> freq.get(a)-freq.get(b));

        for (int key : freq.keySet()) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i=k-1; i>=0; i--) res[i] = pq.poll();
        return res;
    }
}
