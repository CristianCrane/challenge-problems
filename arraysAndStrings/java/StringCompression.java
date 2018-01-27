/*
   String Compression: Implement a method to perform basic string compression
   using the counts of repeated characters.

   For example, the string aabcccccaaa would become a2b1c5a3. If the compressed
   string would not become smaller than the original string, your method should
   return the original string. You can assume the string has only uppercase and
   lowercase letters (a-z);

   Written by Cristian Crane
*/

class StringCompression {

   public static String compressString(String s) {
      char cc = s.charAt(0); // current char
      int count = 0; // count of consecutive characters
      StringBuilder sb = new StringBuilder(); // the compressed String

      for (char c : s.toCharArray()) {
         if (c == cc) count++;
         else {
            sb.append(cc);
            sb.append(count);
            cc = c;
            count = 1;
         }
      }

      // flush last current char and its count to the string
      sb.append(cc);
      sb.append(count);

      String compressedString = sb.toString();
      return (compressedString.length() >= s.length()) ? s : compressedString;
   }

   public static void main (String[] args) {
      String test = "abcd";
      System.out.println(compressString(test));
   }
}
