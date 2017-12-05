package com.leetcode;

public class ReverseSingleLinkedList {
    public static void main(String[] args){
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h = new ReverseSingleLinkedList().reverseList(h);
        while(null != h){
            System.out.print(String.valueOf(h.val) + ", ");
            h = h.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(null == head) return null;
        ListNode p = head;
        ListNode c = p.next;
        p.next = null; // [important] !!!
        while(null != c){
            ListNode cn = c.next;
            c.next = p;
            p = c;
            c = cn;
        }
        return p;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
