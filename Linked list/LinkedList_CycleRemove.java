package LinkedList;

public class LinkedList_CycleRemove {
    public static void main(String[] args) {
        SingleList<Integer> list = new SingleList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        
        // Adding cycle 
        list.last.next = list.head;
        // list.printList(); ---> Infinity loop
        removeLoop(list.head);
        list.printList();
        
    }
    public static void removeLoop(Node head){
        if(head.next == null) return;
        Node fast = head.next.next;
        Node slow = head.next;
        
        // Finding out the loop
        while(fast != slow){
            if(fast.next == null || fast.next.next == null) return;
            fast = fast.next.next;
            slow = slow.next;
        }
        // If slow starts at head and fast starts from previus match point of loop
        // Then both pointer will always meet at the starting point of loop
        slow = head;
        if(slow != fast){
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
        }
        // Moving fast pointer in the starting-1 poisition of the loop
        while(fast.next != slow) 
            fast = fast.next;
        // Breaking the pointer that is responsible for loop
        fast.next = null;
    }
}