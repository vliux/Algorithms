package com.vliux;

import com.vliux.util.SingleLinkedNode;

/**
 * Created by vliux on 1/7/17.
 */
public class ReverseSingleLinkedList {
    public static void main(){
        SingleLinkedNode n1 = new SingleLinkedNode(1);
        SingleLinkedNode n2 = new SingleLinkedNode(2);
        SingleLinkedNode n3 = new SingleLinkedNode(3);
        SingleLinkedNode n4 = new SingleLinkedNode(4);
        SingleLinkedNode n5 = new SingleLinkedNode(5);
        SingleLinkedNode n6 = new SingleLinkedNode(6);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;

        SingleLinkedNode rl = reverse(n1);
        while(null != rl){
            System.out.print(rl.value + " -> ");
            rl = rl.next;
        }
    }

    public static SingleLinkedNode reverse(final SingleLinkedNode root){
        SingleLinkedNode n = root.next;
        SingleLinkedNode rl = root;
        root.next = null;
        while(null != n){
            final SingleLinkedNode nn = n.next;
            n.next = rl;
            rl = n;
            n = nn;
        }
        return rl;
    }
}
