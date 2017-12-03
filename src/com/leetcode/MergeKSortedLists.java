package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args){
        MergeKSortedLists mksl = new MergeKSortedLists();
        ListNode[] ls = new ListNode[3];
        ListNode n  = new ListNode(-1);
        ls[0] = n;
        n.next = new ListNode(1);
        /*n = n.next;
        n.next = new ListNode(15);
        n = n.next;
        n.next = new ListNode(159);
        n = n.next;
        n.next = new ListNode(188);
        */
        n  = new ListNode(-3);
        ls[1] = n;
        n.next = new ListNode(1);
        n = n.next;
        n.next = new ListNode(4);
        /*n = n.next;
        n.next = new ListNode(109);
        n = n.next;
        n.next = new ListNode(300);
        n = n.next;
        n.next = new ListNode(434);
        n = n.next;
        n.next = new ListNode(520);
        n = n.next;
        n.next = new ListNode(914);
        */
        n  = new ListNode(-2);
        ls[2] = n;
        n.next = new ListNode(-1);
        n = n.next;
        n.next = new ListNode(0);
        n = n.next;
        n.next = new ListNode(2);
        /*n = n.next;
        n.next = new ListNode(1320);
        n = n.next;
        n.next = new ListNode(1434);
        n = n.next;
        n.next = new ListNode(1520);
        n = n.next;
        n.next = new ListNode(1914);
*/
        ListNode res = mksl.mergeKListsWithHeap(ls);
        System.out.println("\nMerged list:");
        while(res != null){
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || lists.length <= 0) return null;
        ListNode[] curs = new ListNode[lists.length];
        for(int i = 0; i < lists.length; i++){
            curs[i] = lists[i];
        }

        ListNode resHead = null;
        ListNode resCur = null;
        while (true){
            int curMin = Integer.MAX_VALUE;
            int idMin = -1;
            for(int i = 0; i < curs.length; i++){
                if(curs[i] != null && curs[i].val < curMin) {
                    curMin = curs[i].val;
                    idMin = i;
                }
            }
            if(idMin >= 0){
                if(null == resHead){
                    resHead = curs[idMin];
                    resCur = resHead;
                }else{
                    resCur.next = curs[idMin];
                    resCur = resCur.next;
                }
                curs[idMin] = curs[idMin].next;
            }else{
                return resHead;
            }
        }
    }

    public ListNode mergeKListsWithHeap(ListNode[] lists) {
        if(null == lists || lists.length <= 0) return null;
        HeapSort heapSort = new HeapSort(lists);
        heapSort.sort();

        ListNode resHead = null;
        ListNode resCur = null;
        while (true){
            ListNode minNode = heapSort.getMin();
            if(null == minNode) return resHead;
            else {
                heapSort.updateMin();
                if(null == resHead){
                    resHead = minNode;
                    resCur = resHead;
                }else{
                    resCur.next = minNode;
                    resCur = resCur.next;
                }
            }
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class HeapSort {
        private List<ListNode> nodes;

        HeapSort(ListNode[] ns){
            nodes = new ArrayList<>();
            for(ListNode n : ns){
                if(null != n) nodes.add(n);
            }
        }

        void sort(){
            for(int i = 1; i < nodes.size(); i++){
                heapAdd(i);
            }
            System.out.println("\nSorted in hearp");
            for(int i = 0; i < nodes.size(); i++){
                System.out.print("" +
                        (null != nodes.get(i) ? nodes.get(i).val : "NA")
                        + ", ");
            }
        }

        void updateMin(){
            ListNode min = getMin();
            if(null == min) return;
            nodes.set(0, min.next);
            if(nodes.get(0) == null) {
                swap(0, nodes.size() - 1);
                nodes.remove(nodes.size() - 1);
            }
            heapify();
            System.out.println("\nUpdated in heap");
            for(int i = 0; i < nodes.size(); i++){
                System.out.print("" +
                        (null != nodes.get(i) ? nodes.get(i).val : "NA")
                        + ", ");
            }
        }

        ListNode getMin(){
            if(nodes.size() > 0)
                return nodes.get(0);
            else return null;
        }

        private void heapAdd(int i){
            if(i <= 0) return;
            int p = (i - 1)/2;
            while(p >= 0 && i != p){
                if(nodes.get(0) != null &&
                        (null == nodes.get(p) || nodes.get(i).val < nodes.get(p).val)){
                    swap(i, p);
                    i = p;
                    p = (i - 1)/2;
                }else break;
            }
        }

        private void heapify(){
            int i = 0;
            while(i < nodes.size()) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int thisValue = nodes.get(i).val;
                int leftValue = left < nodes.size() ? nodes.get(left).val : Integer.MAX_VALUE;
                int rightValue = right < nodes.size()? nodes.get(right).val : Integer.MAX_VALUE;

                if(leftValue <= rightValue && leftValue < thisValue){
                    swap(i, left);
                    i = left;
                }else if(rightValue < leftValue && rightValue < thisValue){
                    swap(i, right);
                    i = right;
                }else break;
            }
        }

        private void swap(int i, int j){
            if(i != j){
                ListNode ni = nodes.get(i);
                nodes.set(i, nodes.get(j));
                nodes.set(j, ni);
            }
        }
    }

}
