import java.util.PriorityQueue;

class Solution {
    public int maxProduct(int[] nums) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > 2) {
                minHeap.poll();   
            }
        }

        int first = minHeap.poll();   
        int second = minHeap.poll();  

        return (first - 1) * (second - 1);
    }
}
