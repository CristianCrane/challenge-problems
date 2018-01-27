import java.util.HashSet;
class LinkedList<T> {

   private Node<T> head, tail;
   private int size;

   public static void main(String[] args) {
      LinkedList<Integer> list = new LinkedList<Integer>();
      for (int i = 0; i < 5; i++) {
         list.append(i%3);
      }

      System.out.println("Original List:");
      System.out.println(list);

      System.out.println("Removing duplicates..");
      list.removeDuplicates();
      System.out.println(list);

      System.out.println("Adding more duplicates..");
      for (int i = 0; i < 5; i++) {
         list.append(i%3);
      }
      System.out.println(list);

      System.out.println("Removing duplicates again..");
      list.removeDuplicates();
      System.out.println(list);
   }

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

   /*
      Method to remove all duplicates from the list.
      O(n) time, O(n) space.
   */
   public void removeDuplicates() {
      Node<T> n = head.next, p = null;
      HashSet<T> seenVals = new HashSet<T>();
      while (n != null) {
         if (seenVals.contains(n.data)) {
            p.next = n.next;
            if (n == tail) tail = p;
            size--;
         } else {
            seenVals.add(n.data);
            p = n;
         }
         n = n.next;
      }
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
   private class Node<T> {
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
