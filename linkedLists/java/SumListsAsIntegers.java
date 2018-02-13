class SumListsAsIntegers<T> extends LinkedList<T> {

   // method to add two lists of single digits as integers
   public static LinkedList<Integer> sumLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
      LinkedList<Integer> newList = new LinkedList<Integer>();
      Node<Integer> cur1 = l1.getFirstNode(), cur2 = l2.getFirstNode();
      int carry = 0, val;
      while (cur1 != null || cur2 != null) {
         val = carry;
         if (cur1 != null) {
            val += cur1.data;
            cur1 = cur1.next;
         }
         if (cur2 != null) {
            val += cur2.data;
            cur2 = cur2.next;
         }
         newList.append(val%10);
         carry = val/10;
      }
      if (carry > 0) newList.append(carry);
      return newList;
   }

   // main method to test
   public static void main(String[] args) {
      LinkedList<Integer> list1 = new LinkedList<Integer>();
      list1.append(7);
      list1.append(1);
      list1.append(6);
      System.out.print("List 1: ");
      System.out.println(list1);

      LinkedList<Integer> list2 = new LinkedList<Integer>();
      list2.append(5);
      list2.append(9);
      list2.append(2);
      System.out.print("List 2: ");
      System.out.println(list2);

      System.out.print("List 1+2: ");
      System.out.println(SumListsAsIntegers.sumLists(list1,list2));
   }
}
