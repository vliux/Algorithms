package com.leetcode;

public class SortLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        ListNode tail = null;
        ListNode curr = head;
        while (null != curr){
            tail = curr;
            curr = curr.next;
        }
        sort(head, tail);
        return head;
    }

    private void sort(ListNode head, ListNode tail){
        System.out.println();
        System.out.println("head= " + head.val + ", tail=" + tail.val);
        if(head == tail) return;
        ListNode[] ps = partition(head, tail);
        ListNode pivotl = ps[0];
        ListNode pivotr = ps[1];

        printList(head);
        if(null != pivotl) {
            System.out.println("pivot_left=" + pivotl.val);
            sort(head, pivotl);
        }

        if(null != pivotr) {
            System.out.println("pivot_right=" + pivotr.val);
            sort(pivotr != tail.next ? pivotr : tail, tail);
        }
    }

    private ListNode[] partition(ListNode head, ListNode tail){
        int pv = tail.val;
        ListNode curr = head;
        ListNode store = head;
        ListNode pivotl = null;

        while(curr != tail){
            if(curr.val < pv){
                swap(curr, store);
                pivotl = store;
                store = store.next;
            }
            curr = curr.next;
        }
        swap(store, tail);
        return new ListNode[]{pivotl, store.next};
    }

    private void swap(ListNode n1, ListNode n2) {
        if(n1 != n2){
            int val1 = n1.val;
            n1.val = n2.val;
            n2.val = val1;
        }
    }

    private static void printList(ListNode head){
        ListNode curr = head;
        while(null != curr){
            System.out.print(curr.val);
            System.out.print(", ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ListNode h = new ListNode(1);
        ListNode curr = h;

        ListNode n = new ListNode(2);
        curr.next = n;
        curr = n;

        n = new ListNode(3);
        curr.next = n;
        curr = n;

        n = new ListNode(4);
        curr.next = n;
        curr = n;

        n = new ListNode(5);
        curr.next = n;
        curr = n;

        n = new ListNode(6);
        curr.next = n;
        curr = n;

        n = new ListNode(7);
        curr.next = n;
        curr = n;

        printList(h);
        SortLinkedList sll = new SortLinkedList();
        printList(sll.sortList(h));

    }
}
