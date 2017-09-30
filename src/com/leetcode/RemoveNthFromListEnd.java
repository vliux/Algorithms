package com.leetcode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */
public class RemoveNthFromListEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Queue<ListNode> q = getQueue();
        int capacity = n + 1;
        ListNode cur = head;
        while(null != cur){
            enqueue(q, cur, capacity);
            cur = cur.next;
        }

        ListNode p = null; ListNode pp = null;
        if(q.size() >= capacity){
            pp = q.remove();
            p = q.remove();
        }else if(q.size() == n){
            p = q.remove();
        }

        if(null != p){
            if(null != pp){
                pp.next = p.next;
                return head;
            }else return p.next;
        }else return head;
    }

    private static Queue<ListNode> getQueue(){
        return new LinkedBlockingQueue();
    }

    private static void enqueue(Queue<ListNode> q, ListNode n, int capacity){
        while(q.size() >= capacity) q.remove();
        q.offer(n);
    }

    private static void printList(ListNode h){
        ListNode cur = h;
        while(null != cur){
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
        System.out.println();
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        RemoveNthFromListEnd proc = new RemoveNthFromListEnd();
        ListNode h = new ListNode(1);
        ListNode cur = h;
        for(int i = 2; i <= 5; i++){
            ListNode n = new ListNode(i);
            cur.next = n;
            cur = n;
        }
        printList(h);
        h = proc.removeNthFromEnd(h, 4);
        printList(h);
    }
}
