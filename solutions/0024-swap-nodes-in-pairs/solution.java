class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevLeft = dummy;
        ListNode left = head;
        
        while (left != null) {
            ListNode right = left;
            
            
            for (int i = 0; i < (2 - 1); i++) {
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
            for (int i = 0; i < 2; i++) {
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
