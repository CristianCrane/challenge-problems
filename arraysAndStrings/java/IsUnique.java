import java.util.HashSet;

/*
 * Determines whether a string has all unique characters.
 * Challenge: no additional data structures allowed.
 */
public class IsUnique {

	public static void main(String[] args) {
		String bad = "hello", good = "world";

		System.out.println((isAllUnique(bad))?"All unique.":"Not all unique.");
		System.out.println((isAllUnique(good))?"All unique.":"Not all unique.");
	}

	private static boolean isAllUnique(String theString) {
		// O(n lg n) solution but uses no additional data structures (challenge)
//		char[] chars = theString.toCharArray();
//		Arrays.sort(chars);
//		for (int i = 0; i < chars.length-1; i++)
//			if (chars[i] == chars[i+1])
//				return false;
//		return true;

		// O(n) solution
		HashSet<Character> seenChars = new HashSet<Character>();
		for (int i = 0; i < theString.length(); i++) {
			if (seenChars.contains(theString.charAt(i)))
				return false;
			seenChars.add(theString.charAt(i));
		}
		return true;
	}

}
