package com.ponagayba.linkedlist;


public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        System.out.println("Linked list 1:");
        printList(l1);
        System.out.println("Linked list 2:");
        printList(l2);
        ListNode sum = addTwoNumbers(l1, l2);
        System.out.println("Sum:");
        printList(sum);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int add) {
        int sum = l1.value + l2.value + add;
        add = 0;
        if (sum > 9) {
            sum -= 10;
            add = 1;
        }
        ListNode result = new ListNode(sum);
        if (l1.next == null && l2.next == null && add == 0)
            return result;
        if (l1.next == null)
            l1.next = new ListNode(0);
        if (l2.next == null)
            l2.next = new ListNode(0);
        result.next = addTwoNumbers(l1.next, l2.next, add);
        return result;
    }

    public static void printList(ListNode root) {
        ListNode current = root;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
