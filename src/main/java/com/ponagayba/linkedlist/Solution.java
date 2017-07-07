package com.ponagayba.linkedlist;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        fillUpListRandomly(l1);
        fillUpListRandomly(l2);
        System.out.println("Linked list 1:");
        printList(l1);
        System.out.println("Linked list 2:");
        printList(l2);
        ListNode sum = addTwoNumbers(l1, l2);
        System.out.println("Sum:");
        printList(sum);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(l1.value + l2.value);
        ListNode l1Current = l1, l2Current = l2, resultCurrent = result;

        int rest = 0;
        while (l1Current.next != null && l2Current.next != null) {
            int sum = l1Current.next.value + l2Current.next.value + rest;
            if (sum < 10) {
                resultCurrent.next = new ListNode(sum);
                rest = 0;
            } else {
                sum = sum - 10;
                resultCurrent.next = new ListNode(sum);
                rest = 1;
            }
            resultCurrent = resultCurrent.next;
            l1Current = l1Current.next;
            l2Current = l2Current.next;
        }

        while (l1Current.next != null) {
            resultCurrent.next = new ListNode(l1Current.next.value + rest);
            if (rest == 1)
                rest = 0;
            resultCurrent = resultCurrent.next;
            l1Current = l1Current.next;
        }
        while (l2Current.next != null) {
            resultCurrent.next = new ListNode(l2Current.next.value + rest);
            if (rest == 1)
                rest = 0;
            resultCurrent = resultCurrent.next;
            l2Current = l2Current.next;
        }

        if (rest == 1)
            resultCurrent.next = new ListNode(rest);

        return result;
    }

    public static void fillUpListRandomly(ListNode root) {
        ListNode current = root;
        int size = ThreadLocalRandom.current().nextInt(1, 5);
        for (int i = 0; i < size; i++) {
            current.next = new ListNode(ThreadLocalRandom.current().nextInt(0, 10));

            current = current.next;
        }
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
