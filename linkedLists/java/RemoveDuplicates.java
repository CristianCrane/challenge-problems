import java.util.HashSet;
class RemoveDuplicates<T> extends LinkedList<T> {
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

   // main method to test
   public static void main(String[] args) {
      RemoveDuplicates<Integer> list = new RemoveDuplicates<Integer>();

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

}
