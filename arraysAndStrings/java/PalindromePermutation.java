import java.util.HashMap;

import javax.swing.JOptionPane;

/* 	
 	PROBLEM:
 	given a string, write a function to check if it is a permutation of a palindrome.
 	The palindrome does not need to be limited to just dictionary words.
*/

/*
 	SOLUTION:
	A palindrome must be symmetric. This means that any letter in the given string must come in pairs.
	This entails that the count of each character must be even, with the exception of one character in
	the middle only if the total length of the string is odd. If the string is even length then it must
	be the case that all characters have an even count.

	The problem thus reduces to counting the number of times each character appears and then checking whether these constraints are met.
	The following solution is O(n), which is the lower bound for a problem of this nature.
 */

class PalindromePermutation {


	/**
	 * Helper function that populates and returns a hashmap with the character counts of a given word.
	 * @param word The word to count the characters from.
	 * @return A hashmap containing a mapping of each character to the number of times this character appeared in the given word.
	 */
	private static HashMap<Character,Integer> countCharsInWord(String word) {
		HashMap<Character,Integer> charCounts = new HashMap<Character,Integer>();
		for (Character c : word.toCharArray()) {
			// if its not already in the map, put it in
			if (!charCounts.containsKey(c))
				charCounts.put(c, 0);
			charCounts.put(c, charCounts.get(c) + 1);
		}

		System.out.println(charCounts);
		return charCounts;
	}

	/**
	 * Determines whether a string is a permutation of a palindrome.
	 * @param testWord The word to test.
	 * @return True if the given word is a permutation of a palindrome, false if it is not.
	 */
	public static boolean isPalindromePermutation(String testWord) {
		// clean up the word a bit, remove spaces and make all lower case
		testWord = testWord.replaceAll(" ","");
		testWord = testWord.toLowerCase();

		// populate hashMap with charCounts
		HashMap<Character, Integer> charCounts = countCharsInWord(testWord);

		//
		int oddCount = 0;
		for (Character c : testWord.toCharArray()) {
			if (charCounts.get(c) % 2 == 1) oddCount++;
		}

		// ensure constraints are met
		if (testWord.length() % 2 == 0 && oddCount > 0)
			return false;
		else if (testWord.length() % 2 == 1 && oddCount > 1)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {

		while (true) {
			String testWord = JOptionPane.showInputDialog("Enter a string to determine if it is a permutation of a palindrome.\nType quit to quit.");
			if (testWord.equalsIgnoreCase("quit")) break;
			String isOrIsNot = ((isPalindromePermutation(testWord)) ? " is " : " is not " );
			JOptionPane.showMessageDialog(null, testWord + isOrIsNot + "a palindrome.");
		}
	}
}
