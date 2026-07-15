import java.util.ArrayDeque;
import java.util.Deque;

class Pair {
    char letter;
    int count;

    public Pair(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().letter == c) {
                if (stack.peek().count == k - 1) {
                    stack.pop(); 
                } else {
                    stack.peek().count++; 
                }
            } else {
                stack.push(new Pair(c, 1));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            for (int i = 0; i < top.count; i++) {
                sb.append(top.letter);
            }
        }
        
        return sb.reverse().toString();
    }
}
