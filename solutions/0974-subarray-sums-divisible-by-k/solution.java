class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int[] remainderCount = new int[k];
        remainderCount[0] = 1;
        
        for (int num : nums) {
            sum += num;
            int remainder = (sum % k + k) % k;
            count += remainderCount[remainder];
            remainderCount[remainder]++;
        }
        
        return count;
    }
}
