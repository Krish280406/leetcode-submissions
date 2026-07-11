import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int[][] combined = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            combined[i] = intervals[i];
        }
        combined[intervals.length] = newInterval;
        
        
        Arrays.sort(combined, (x, y) -> Integer.compare(x[0], y[0]));
        
        List<int[]> res = new ArrayList<>();
        int start1 = combined[0][0];
        int end1 = combined[0][1];
        
       
        for (int i = 0; i < combined.length; i++) {
            int start2 = combined[i][0];
            int end2 = combined[i][1];
            
            if (end1 >= start2) {
                
                end1 = Math.max(end1, end2);
                continue;
            }
            
            res.add(new int[]{start1, end1});
            start1 = start2;
            end1 = end2;
        }
      
        res.add(new int[]{start1, end1});
        
        return res.toArray(new int[0][]);
    }
}
