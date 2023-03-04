package LinkedList;

import java.util.*;

public class LinkedList_CycleDetect {
    public static void main(String[] args) {
        SingleList<Integer> list = new SingleList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        if(cycleExists(list.head)) System.out.println("Cycle exists");
        else System.out.println("Cycle doesn't exists");
        
        // Adding cycle
        list.last.next = list.head;
        
        if(cycleExists(list.head)) System.out.println("Cycle exists");
        else System.out.println("Cycle doesn't exists");
    }
    
    static boolean cycleExists(Node head){
        if(head == null) return false;
        Node fast = head.next;
        Node slow = head;
        while(true){
            // If fast and slow pointer ever meets then there is a cycle
            if(fast == slow) return true;
            // If fast pointer ever reaches the edge then there is no cycle
            if(fast.next == null || fast.next.next == null) return false;
            else fast = fast.next.next;
            slow = slow.next;
        }
    }
}
