class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        
        // Expand the window with the right pointer
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            // Shrink the window from the left while the condition is met
            while (currentSum >= target) {
                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                }
                
                // Subtract the element leaving the window and move left pointer
                currentSum -= nums[left];
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
