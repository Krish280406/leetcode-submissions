class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        ListNode last = head;
        int n = 1;
        while (last.next != null) {
            last = last.next;
            n++;
        }
        
        last.next = head;
        
        k = k % n;
        int stepsToNewTail = n - k;
        
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}
