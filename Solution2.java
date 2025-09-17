/*
    * Problem Statement: https://leetcode.com/problems/add-two-numbers/
    * Given : 1) Linked List 1 = l1
    *         2) Linked List 2 = l2
    *         L1 & L2 = Non empty Linked list (+Ve Integers (Numbers)) 1) Traverse both linked list
    *         Digits Sorted in Reverse order
    *         Nodes = Single digit
    *         Return : SUM of L1 & L2 = Linked list
    *         Note : Carry will be there if sum of digit > 9
   *          Example Walkthrough : l1 = [2,4,3], l2 = [5,6,4]
    *               - Add corresponding digits = 2 + 5 = 7 (no carry)
    *               - Add corresponding digits 4 + 6 = 10 (carry 1)
    *               - Add corresponding digits with previous carry 3 + 4 + 1 (carry 0)
    *               - Result = [7,0,8] (Linked List)
    *           Explanation : 342 + 465 = 807
    Approach :
    1) Dummy head node se result list start karo
    2) Carry variable lo (0 se start)
    3) Jab tak l1, l2, ya carry hai:
       * l1 aur l2 se value lo (nahi ho toh 0)
       * Sum = val1 + val2 + carry
       * Naya node banao (sum % 10)
       * Carry update karo (sum // 10)
       * urrent pointer ko next node pe le jao
       * l1, l2 ko aage badhao
    4) Loop ke baad bhi agar carry hai toh ek extra node banao
    5) Dummy head ke next ko return karo (yeh result hai)
    Time: O(max(m, n)), Space: O(max(m, n))
    6) Edge cases:
      * Lists different length
      * Final carry
      * Dummy head use for easy implementation
  */
import java.util.*;
public class Solution2 {
    public ListNode addListNodeNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy head for result list
        ListNode current = dummyHead; // Pointer to build the result list
        int carry = 0; // Initialize carry to 0
        // While for traversing both lists and carry
        while (l1 != null || l2 != null || carry != 0) {
            // Get values from l1 and l2, if null use 0
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate sum and carry
            int sum = val1 + val2 + carry;
            // Update carry for next iteration
            carry = sum / 10;
            // Create new node with the digit value (sum % 10)
            current.next = new ListNode(sum % 10);
            // Move current pointer to next
            current = current.next;
            // Move l1 and l2 pointers to next nodes if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // Return the next of dummy head as the result list
        return dummyHead.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution2 solution = new Solution2();

        // Dummy1 and Dummy2 = starting points
        // tail1 and tail2 = next insertion point
        ListNode dummy1 = new ListNode(0),  dummy2 = new ListNode(0);
        ListNode tail1 = dummy1,  tail2 = dummy2;

        // Input for first linked list
        System.out.print(" Length of l1 : ");
        int n = sc.nextInt(); // length of l1
        System.out.print(" Input digits for l1 : ");
        for (int i = 0; i < n; i++) {
            tail1.next = new ListNode(sc.nextInt());
            tail1 = tail1.next;
        }  
        ListNode l1 = dummy1.next; // Head of first linked list

        // Input for second linked list
        System.out.print(" Length of l2 : ");
        int m = sc.nextInt(); // length of l2
        System.out.print(" Input digits for l2 : ");
        for (int i = 0; i < m; i++) {
            tail2.next = new ListNode(sc.nextInt());
            tail2 = tail2.next;
        }  
        ListNode l2 = dummy2.next; // Head of second linked list
        
        ListNode result = solution.addListNodeNumbers(l1, l2);
        // Print the result linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        sc.close();
    }
}

// Creating List Nodes
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {this.val = x;}
}
