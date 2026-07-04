class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[128];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            freq[rightChar]++;
            
            if (freq[rightChar] > maxFreq) {
                maxFreq = freq[rightChar];
            }

            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                freq[leftChar]--;
                left++;
            }

            int currentLen = right - left + 1;
            if (currentLen > maxLength) {
                maxLength = currentLen;
            }
        }

        return maxLength;
    }
}
