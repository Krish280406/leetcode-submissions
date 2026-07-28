import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{getDistance(points[i]), i});
        }
        
        for (int i = k; i < points.length; i++) {
            maxHeap.offer(new int[]{getDistance(points[i]), i});
            maxHeap.poll();
        }
        
        int[][] result = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            result[index++] = points[maxHeap.poll()[1]];
        }
        
        return result;
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
