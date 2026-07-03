class Solution {
    public int totalFruit(int[] fruits) {
        int[] count = new int[fruits.length];
        int left = 0, maxFruits = 0, distinct = 0;
        
        for (int right = 0; right < fruits.length; right++) {
            if (count[fruits[right]] == 0) {
                distinct++;
            }
            count[fruits[right]]++;
            
            while (distinct > 2) {
                count[fruits[left]]--;
                if (count[fruits[left]] == 0) {
                    distinct--;
                }
                left++;
            }
            
            int currentLen = right - left + 1;
            if (currentLen > maxFruits) {
                maxFruits = currentLen;
            }
        }
        return maxFruits;
    }
}
