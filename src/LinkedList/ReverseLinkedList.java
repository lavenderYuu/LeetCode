package LinkedList;
/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

Example 2:
    Input: head = [1,2]
    Output: [2,1]

Example 3:
    Input: head = []
    Output: []

        Algorithm:
        1. use the while loop to loop through all the node, stop when current node is null
        2. let current next be the previous node
        3. after finish, set up for next node change, set prev be the current one, and current be the next
        4. in the end the prev will point to the last node, return prev

        Complexity:
        Time: O(n)
 */

public class ReverseLinkedList {
    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1,node2);

        reverseList(node1);
    }
}


