import java.util.HashSet;
import java.util.Stack;

// just a quick homebrew linked list class that I'll use to solve problems
class LinkedList<T> {

   protected Node<T> head, tail;
   protected int size;

   // list constructor
   public LinkedList() {
      head = new Node<T>();
      tail = head;
      size = 0;
   }

   // simple append data
   public void append(T val) {
      Node<T> n = new Node<T>(val);
      tail.next = n;
      tail = n;
      size++;
   }

   // gets the first node in the list, returns null if list is empty
   public Node<T> getFirstNode() {
      if (size == 0) return null;
      return head.next;
   }

   // prints the LinkedList
   @Override
   public String toString() {
      Node<T> n = head.next;
      StringBuilder s = new StringBuilder();
      while (n != null) {
         s.append("(" + n.data + ")-->");
         n = n.next;
      }
      return s.toString();
   }

   // internal node class
   protected static class Node<T> {
      T data;
      Node<T> next;

      Node() {
         data = null;
         next = null;
      }

      Node(T data) {
         this.data = data;
         this.next = null;
      }
   }
}
