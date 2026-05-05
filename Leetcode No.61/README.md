# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
I see the problem like the snake game in Nokia phone. So instead of treating the List as an array, I think of a circle. And then, when rotate k, we just travel inside circle. So the biggest rotate will be always smaller than the number of nodes.
# Approach
<!-- Describe your approach to solving the problem. -->
The step is `k`%`node` and we will cut the circle at the step's node.

# Complexity
- Time complexity: O(N)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        int steps = k % length;
        if (steps == 0) {
            return head;
        }

        tail.next = head;

        int newTailPosition = length - steps;
        ListNode newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
```