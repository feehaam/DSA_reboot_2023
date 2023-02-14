## Linked List

- Single, Traversal, insertion, deletion

```java Single list, traversal, inertion, deletion code

import java.util.*;
public class LinkedList_Single {
    public static void main(String[] args) {
        
        SingleList<Integer> list = new SingleList<>();
        list.addFirst(5);
        list.addLast(10);
        list.addFirst(15);
        list.addLast(20);
        list.addFirst(25);
        list.addLast(30);
        list.printList();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list);
        System.out.println(list.popFirst());
        System.out.println(list.popFirst());
        System.out.println(list.popLast());
        System.out.println(list);
        
    }
    
    // SINGLE LINKED LIST
    static class SingleList <T>{
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
        
        // Another way of print the list
        @Override
        public String toString(){
            Node n = head;
            String ret = "[ ";
            while(n != null){
                ret += n.value;
                if(n.next != null) ret += ", ";
                n = n.next;
            }
            ret += " ]";
            return ret;
        }
    }
    
    // List node
    static class Node <T>{
        T value;
        Node(T value){
            this.value = value;
        }
        Node next;
    }
}
```
```java Output
[ 25, 15, 5, 10, 20, 30 ]
25
30
[ 25, 15, 5, 10, 20, 30 ]
25
15
30
[ 5, 10, 20 ]
```
