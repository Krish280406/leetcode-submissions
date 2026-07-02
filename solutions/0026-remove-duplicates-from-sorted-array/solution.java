class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: if the array is empty, there are 0 unique elements
        if (nums.length == 0) {
            return 1;
        }
        
        int slow = 0; // Tracks the position of the last unique element found
        
        // fast pointer scans ahead starting from the second element
        for (int fast = 1; fast < nums.length; fast++) {
            // If we find a value different from the last unique element
            if (nums[fast] != nums[slow]) {
                slow++;                 // Move slow forward to the next empty slot
                nums[slow] = nums[fast]; // Copy the unique value into place
            }
        }
        
        // The total number of unique elements is index + 1
        return slow + 1;
    }
}
