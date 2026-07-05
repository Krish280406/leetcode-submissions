class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        
        int left = 0, right = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, startIndex = 0;
        
        while (right < s.length()) {
            if (map[s.charAt(right++)]-- > 0) {
                count--;
            }
            
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }
                
                if (map[s.charAt(left++)]++ == 0) {
                    count++;
                }
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
