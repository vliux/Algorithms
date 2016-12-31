package com.vliux;

/**
 * Created by vliux on 12/30/16.
 */
public class MergeLinkedLists {
    public static void main(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(6);
        Node n4 = new Node(11);
        Node n5 = new Node(39);
        Node n6 = new Node(78);
        Node n7 = new Node(1229);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        Node m1 = new Node(1);
        Node m2 = new Node(2);
        Node m3 = new Node(8);
        Node m4 = new Node(10);

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        print(merge(n1, m1));
    }

    private static void print(final Node n){
        Node k = n;
        while(null != k){
            System.out.println(k.data);
            k = k.next;
        }
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node merge(final Node head1, final Node head2){
        Node n1 = head1;
        Node n2 = head2;
        Node newRoot = null;
        Node newCurrent = null;
        while(null != n1 && null != n2){
            Node n;
            if (n1.data > n2.data) {
                n = n2;
                n2 = n2.next;
            } else {
                n = n1;
                n1 = n1.next;
            }

            if(null == newRoot) {
                newRoot = n;
            }else {
                newCurrent.next = n;
            }
            newCurrent = n;
            n = n.next;
        }

        Node left = (null == n1? n2 : n1);
        while (null != left){
            if(null == newRoot) {
                newRoot = left;
            }else {
                newCurrent.next = left;
            }
            newCurrent = left;
            left = left.next;
        }
        return newRoot;
    }

    private static void appendToNew(final Node root, final Node current, final Node next){

    }
}
