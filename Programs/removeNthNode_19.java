class removeNthNode_19 {
    public static void main(String[] args) {
        removeNthNode_19 rnn = new removeNthNode_19();
        ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);

        ListNode temp = rnn.removeNthFromEnd(head, 1);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        ListNode start = head;
        int diff = n+1;
        while (end.next != null) {
            end = end.next;
            diff--;
            if (diff <= 0) {
                start = start.next;
            }
        }

        if(start.next == null ) {
            start = null;
        }
        else if(start.next.next == null) {
            start.next = null;
        }
        else 
            start.next.next = null;
        return head;
    }
}