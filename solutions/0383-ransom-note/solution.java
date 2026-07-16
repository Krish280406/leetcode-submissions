import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();
        
        for (char c : ransomNote.toCharArray()) {
            ransomMap.put(c, ransomMap.getOrDefault(c, 0) + 1);
        }
        
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }
        
        for (char c : ransomMap.keySet()) {
            if (ransomMap.get(c) > magazineMap.getOrDefault(c, 0)) {
                return false;
            }
        }
        
        return true;
    }
}
