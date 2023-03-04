package LinkedList;


import java.util.*;
public class LinkedList_Double {
    public static void main(String[] args) {
        
        DoubleList<String> list = new DoubleList<>();
        list.addFirst("Apple");
        list.addLast("Banana");
        list.addFirst("Coconut");
        list.addLast("Grape");
        list.addFirst("Orange");
        list.addLast("Lemon");
        list.printList();
        list.printReversedList();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.popFirst());
        System.out.println(list.popFirst());
        System.out.println(list.popLast());
        
    }
}
// SINGLE LINKED LIST
class DoubleList <T>{
    // Two pointers for pointing at head and the finishing node
    Node head = null;
    Node last = null;

    // INSERTION
    // Adds a new item into the end
    void addLast(T value){
        Node n = new Node(value);
        if(last == null){
            last = n;
            head = last;
        }
        else{
            last.next = n;
            n.prev = last;
            last = last.next;
        }
    }

    // Adds a new item into the beginning
    void addFirst(T value){
        Node n = new Node(value);
        if(last == null){
            last = n;
            head = last;
        }
        else{
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    // Returns the first item of list
    Object getFirst(){
        return head.value;
    }

    // Returns the last item of list
    Object getLast(){
        return last.value;
    }

    // DELETION
    // Remove first item
    Object popFirst(){
        if(head == null) return null;
        Object item = getFirst();
        head = head.next;
        return item;
    }

    // Remove last item
    Object popLast(){
        if(head == null) return null;
        Object item = getLast();
        if(head.next == null){
            head = null;
        }
        else{
            Node n = head;
            while(n.next.next != null){
                n = n.next;
            }
            item = n.next.value;
            n.next = null;
        }
        return item;
    }

    // TRAVERSAL
    // Print the list
    void printList(){
        Node n = head;
        System.out.print("[ ");
        while(n != null){
            System.out.print(n.value);
            if(n.next != null) System.out.print(", ");
            n = n.next;
        }
        System.out.println(" ]");
    }

    // Print in reverse order
    void printReversedList(){
        Node n = last;
        System.out.print("[ ");
        while(n != null){
            System.out.print(n.value);
            if(n.prev != null) System.out.print(", ");
            n = n.prev;
        }
        System.out.println(" ]");
    }
    // List node
    class Node <T>{
        T value;
        Node(T value){
            this.value = value;
        }
        Node next;
        Node prev;
    }
}

