class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (feasible(nums, m, mid)) {
                right = mid; 
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean feasible(int[] nums, int m, int threshold) {
        int count = 1;
        int total = 0;
        
        for (int num : nums) {
            total += num;
            if (total > threshold) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
