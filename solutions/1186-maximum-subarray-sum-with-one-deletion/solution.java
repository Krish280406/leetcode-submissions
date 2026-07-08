class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int oneDeletion = arr[0];
        int noDeletion = arr[0];
        int maxSum = arr[0];
        
        for (int i = 1; i < n; i++) {
            oneDeletion = Math.max(oneDeletion + arr[i], noDeletion);
            
            if (oneDeletion == Integer.MIN_VALUE) {
                oneDeletion = arr[i];
            }
            
            noDeletion = Math.max(arr[i], noDeletion + arr[i]);
            maxSum = Math.max(maxSum, Math.max(oneDeletion, noDeletion));
        }
        
        return maxSum;
    }
}
