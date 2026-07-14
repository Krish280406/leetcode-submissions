import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        Deque<Integer> stack = new ArrayDeque<>();
        
       
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;
            
            
            while (!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {
                int indexOfSmallerElement = stack.pop();
                result[indexOfSmallerElement] = nums[currentIndex];
            }
            
            // Push the current index onto the stack during the first pass
            if (i < n) {
                stack.push(currentIndex);
            }
        }
        
        return result;
    }
}
