package lists;

/**
 * Created by swapn on 12/31/2016.
 */
public class AddTwoNumber {
    private static class ListNode {
           int val;
           ListNode next;
           ListNode(int x) { val = x; }
        }

    public static void main(String[] args){
        AddTwoNumber a  = new AddTwoNumber();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        //ListNode ans = a.addTwoNumbers(l1,l2);

        ListNode ll = new ListNode(1);
        ll.next = new ListNode(4);
        ll.next.next = new ListNode(3);
        ll.next.next.next = new ListNode(2);
        ll.next.next.next.next = new ListNode(5);
        ll.next.next.next.next.next = new ListNode(2);

        ListNode ans = a.partition(ll, 3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode fakeFront = new ListNode(0);
        ListNode front = fakeFront;

        ListNode fakeBack = new ListNode(0);
        ListNode back = fakeBack;

        while(head != null){
            if(head.val < x){
                front.next = new ListNode(head.val);
                front = front.next;
            }else{
                back.next = new ListNode(head.val);
                back = back.next;
            }
            head = head.next;
        }

        front.next = fakeBack.next;
        return fakeFront.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(l1 != null || l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int sum = carry + l1.val;
            carry = sum / 10;
            temp = new ListNode(sum%10);
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = carry + l2.val;
            carry = sum / 10;
            temp = new ListNode(sum%10);
            temp = temp.next;
            l2 = l2.next;
        }

        return dummy.next;
    }
}
