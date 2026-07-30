import java.util.PriorityQueue;

class Solution {
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                maxHeap.offer(new int[]{i + 'a', counts[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= 2) {
            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();

            sb.append((char) first[0]);
            sb.append((char) second[0]);

            first[1]--;
            second[1]--;

            if (first[1] > 0) {
                maxHeap.offer(first);
            }
            if (second[1] > 0) {
                maxHeap.offer(second);
            }
        }

        if (!maxHeap.isEmpty()) {
            int[] last = maxHeap.poll();
            if (last[1] > 1) {
                return "";
            }
            sb.append((char) last[0]);
        }

        return sb.toString();
    }
}
