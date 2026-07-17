class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        
        ListNode dummy = new ListNode(0, head);
        ListNode before = dummy;
        
        // 1. Move 'before' to the node immediately preceding 'left'
        for (int i = 1; i < left; i++) {
            before = before.next;
        }
        
        // 2. Set up for standard reversal
        ListNode tail = before.next; // The first node of sublist becomes the tail
        ListNode prev = null;
        ListNode curr = before.next;
        
        // 3. Standard reverse using prev and curr
        for (int i = 0; i <= right - left; i++) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        
        // 4. Reconnect the reversed sublist back into the main list
        before.next = prev; 
        tail.next = curr;   
        
        return dummy.next;
    }
}
