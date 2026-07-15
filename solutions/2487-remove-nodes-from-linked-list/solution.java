import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curr = head;
        
        while (curr != null) {
            while (!stack.isEmpty() && stack.peek().val < curr.val) {
                stack.pop();
            }
            stack.push(curr);
            curr = curr.next;
        }
        
        ListNode nxt = null;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            curr.next = nxt;
            nxt = curr;
        }
        
        return nxt;
    }
}
