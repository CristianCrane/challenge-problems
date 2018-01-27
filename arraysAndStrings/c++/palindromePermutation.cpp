/*
   Given a string, write a function to check if it is a permutation of a palindrome.
   A palindrome is a word or phrase that is the same forwards and backwards.
   A permutation is a rearrangement of letters. The palindrome does not need to be
   limited to just dictionary words.

   Written by Cristian Crane
*/

#include<iostream>
using namespace std;

bool isPalindromePermutation(string s) {
   // take inventory of characters
   int charCounts[128] = {};
   for (char c : s) charCounts[c]++;

   // check the counts
   int oddCount = 0;
   for (int i : charCounts)
      if (i%2 != 0) oddCount++;

   return (s.length()%2 == 0) ? (oddCount == 0) : (oddCount == 1);
}

int main() {
   string s = "tactcoa";
   string result = (isPalindromePermutation(s)) ? "is" : "isn't";
   cout << s << " " << result << " a permutation of a palindrome.\n";
   return 0;
}
