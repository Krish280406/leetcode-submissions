import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        int row = intervals.length;
        int[][] ans = new int[row][2];
        int index = 0;
        
        for (int i = 1; i < row; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];
            
            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
            } else {
                ans[index][0] = start1;
                ans[index][1] = end1;
                start1 = start2;
                end1 = end2;
                index++;
            }
        }
        
        ans[index][0] = start1;
        ans[index][1] = end1;

        return Arrays.copyOf(ans, index + 1);
    }
}
