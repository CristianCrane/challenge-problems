/*
   Given an array a that contains only numbers in the range from 1 to a.length,
   find the first duplicate number for which the second occurrence has the
   minimal index. In other words, if there are more than 1 duplicated numbers,
   return the number for which the second occurrence has a smaller index than
   the second occurrence of the other number does. If there are no such
   elements, return -1.

   Solution: create a mapping in the same array. As we pass through the array,
   mark each appropriate index as negative - indicating we've seen this value
   already.

   If as we're traversing the array we go to an index and find a negative value
   there, we have seen that value before and can return the current value.
*/

class FirstDuplicate {

   public static void main(String[] args) {
      int[] a = {1,2,3,1}, b = {1,2,3,4}, c = {5,4,3,2,2};
      System.out.println(firstDuplicate(a)); // expecting 1
      System.out.println(firstDuplicate(b)); // expecting -1
      System.out.println(firstDuplicate(c)); // expecting 2
   }

   public static int firstDuplicate(int[] a) {
      for (int i = 0; i < a.length; i++) {
         int valIndex = Math.abs(a[i])-1;
         if (a[valIndex] < 0)
            return valIndex+1;
         a[valIndex] *= -1;
      }
      return -1;
   }
}
