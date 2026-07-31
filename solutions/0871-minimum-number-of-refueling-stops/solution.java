import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        int n = stations.length;
        int stops = 0;

        while (startFuel < target) {

            while (i < n && stations[i][0] <= startFuel) {
                maxHeap.offer(stations[i][1]);
                i++;
            }

            if (maxHeap.isEmpty()) {
                return -1;
            }

            startFuel += maxHeap.poll();
            stops++;
        }

        return stops;
    }
}
