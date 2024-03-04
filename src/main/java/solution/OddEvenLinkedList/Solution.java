package solution.OddEvenLinkedList;

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}


public class Solution {
    public Node getOddEvenList(Node head) {
        if (head == null || head.next == null) return head;

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public String linkedListToString(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" -> ");
            head = head.next;
        }
        sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(4);
        list1.next.next.next.next = new Node(5);
        System.out.println("Test case 1:");
        System.out.println(solution.linkedListToString(solution.getOddEvenList(list1)));
    }
}
