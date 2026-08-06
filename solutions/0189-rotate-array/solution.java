class Solution {
    public void rotate(int[] nums, int k) {

        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;

        k = k % n;

      
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }

       
        int i = 0;
        int j = k - 1;

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }

        int low = k;
        int high = n - 1;

        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;

            low++;
            high--;
        }
    }
}


