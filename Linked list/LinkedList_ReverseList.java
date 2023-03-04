package LinkedList;

public class LinkedList_ReverseList {
    public static void main(String[] args) {
        SingleList<Integer> list = new SingleList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.printList();
        
        // ITEREATIVE APPROACH
        Node current = list.head;
        Node previus = null;
        while(current != null){
            Node next = current.next;
            current.next = previus;
            previus = current;
            current = next;
        }
        list.head = previus;
        list.printList();
        
        //RECURSIVE APPROACH
        LinkedList_ReverseList o = new LinkedList_ReverseList();
        list.head = o.reverseList(list.head);
        list.printList();
    }
    
    Node reverseList(Node n){
        if(n == null || n.next == null) return n;
        Node next = n.next;
        Node newHead = reverseList(next);
        next.next = n;
        n.next = null;
        return newHead;
    }
}