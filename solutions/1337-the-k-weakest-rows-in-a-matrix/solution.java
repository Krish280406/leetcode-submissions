import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
              if (a[0] == b[0]) {
            return a[1] - b[1];
          }
           return a[0] - b[0];
         });
        
          for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int val : mat[i]) count += val;
            pq.offer(new int[]{count, i});
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[1];
        }
        
        return res;
    }
}
