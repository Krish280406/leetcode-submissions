class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevLeft = dummy;
        ListNode left = head;
        
        while (left != null) {
            ListNode right = left;
            
            for (int i = 0; i < (k - 1); i++) {
                if (right != null) {
                    right = right.next;
                }
            }
            
            if (right == null) {
                break;
            }
            
            ListNode nextLeft = right.next;
            
            ListNode prev = null;
            ListNode curr = left;
            for (int i = 0; i < k; i++) {
                ListNode nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }
            
            prevLeft.next = right;
            left.next = nextLeft;  
            
            prevLeft = left; 
            left = nextLeft;       
        }
        
        return dummy.next;
    }
}
