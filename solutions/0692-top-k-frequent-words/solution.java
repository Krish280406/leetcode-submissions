import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word using a HashMap
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            // If word exists, increment its count; otherwise, add it with count 1
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        // Step 2: Create a Min-Heap (PriorityQueue) to keep the top K elements
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            // Rule 1: If frequencies are the same, tie-break alphabetically (descending)
            // This ensures alphabetically later words get evicted first
            if (freq.get(a).equals(freq.get(b))) {
                return b.compareTo(a);
            }
            // Rule 2: If frequencies differ, order by frequency (ascending)
            // This ensures lower frequency words get evicted first
            return freq.get(a) - freq.get(b);
        });
        
        // Step 3: Add unique words to the heap
        for (String word : freq.keySet()) {
            pq.offer(word);
            // Maintain heap size of exactly k by removing the top element
            if (pq.size() > k) {
                pq.poll(); // Evicts lowest frequency or alphabetically later word
            }
        }
        
        // Step 4: Extract the results from the heap
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll()); // Pulls out lowest frequencies first
        }
        
        // Step 5: Reverse the list because we need highest frequency first
        Collections.reverse(result);
        return result;
    }
}
