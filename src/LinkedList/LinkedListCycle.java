package LinkedList;

import java.util.HashSet;
import java.util.Set;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
    Input: head = [1,2], pos = 0
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
    Input: head = [1], pos = -1
    Output: false
    Explanation: There is no cycle in the linked list.

        Algorithm:
        1. use the while loop to loop through all the node, stop when current node is null, return false
        2. store the node in the hashset, if hashset check don't have the same node, and check next one
        3. if it detects same node, means there is a cycle, return true
                    *store node not val since might have duplicate value

        Complexity:
        Time: O(n)
 */

public class LinkedListCycle {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> check = new HashSet();
            ListNode current = head;

            while(current != null) {
                if(check.contains(current)) {
                    return true;
                } else {
                    check.add(current);
                    current = current.next;
                }
            }

            return false;
        }

}
