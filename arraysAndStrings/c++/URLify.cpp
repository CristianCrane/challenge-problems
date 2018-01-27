/*
  URLIfy: Write a method to replace all spaces in a string with '%20'.
  You may assume that the string has sufficient space at the end to hold
  the additional characters, and that you are given the "true"
  length of the string.
*/

#include <iostream>
using namespace std;

void URLIfy(string &s, int i) {
  i--;
  int j = s.length()-1;

  while (i != j) {
    if (s[i] != ' ')
      s[j--] = s[i--];
    else {
      s[j--] = '0';
      s[j--] = '2';
      s[j--] = '%';
      i--;
    }
  }
}

int main() {
  string s = "mr john smith    ";
  URLIfy(s,13);
  cout << s << endl;
  return 0;
}
