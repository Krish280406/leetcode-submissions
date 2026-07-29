import java.util.PriorityQueue;

class Solution {
    public int findClosestNumber(int[] nums) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        
        for (int num : nums) {
            maxHeap.offer(new int[]{num, Math.abs(num)});
            if (maxHeap.size() > 1) {
                maxHeap.poll();
            }
        }
        
        return maxHeap.peek()[0];
    }
}
