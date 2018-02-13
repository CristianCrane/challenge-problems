import java.util.Stack;
class IsPalindrome<T> extends LinkedList<T> {

   // method to check if the list is a palindrome
   public boolean isPalindrome() {
      if (size == 0) return false; // assuming empty means its not a palindrome

      Stack<Node<T>> s = new Stack<Node<T>>();
      Node<T> n = getFirstNode();

      // push all the nodes onto a stack (reverse em)
      while (n != null) {
         s.push(n);
         n = n.next;
      }

      // compare the reversed order nodes to the list and see if theyre all equal
      n = getFirstNode();
      while (n != null) {
         if (n.data != s.pop().data) return false;
         n = n.next;
      }
      return true;
   }

   // main method to test
   public static void main(String[] args) {
      IsPalindrome<Integer> list = new IsPalindrome<Integer>();
      list.append(1);
      list.append(2);
      list.append(3);
      list.append(2);
      list.append(1);

      System.out.println(list);
      System.out.println((list.isPalindrome())?"It's a palindrome!":"It's not a palindrome.");

      IsPalindrome<Integer> list2 = new IsPalindrome<Integer>();
      list2.append(1);
      list2.append(2);
      list2.append(3);
      list2.append(1);
      list2.append(1);

      System.out.println(list2);
      System.out.println((list2.isPalindrome())?"It's a palindrome!":"It's not a palindrome.");
   }
}
