#include <iostream>
using namespace std;

void printMatrix(int m[][4], int numRows, int numCols) {
   for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
         cout << m[r][c];
      }
      cout << endl;
   }
}

void zeroMatrix(int m[][4], int numRows, int numCols) {
   int zeroInRow[numRows] = {}, zeroInCol[numCols] = {};

   // flag which rows and cols contain 0s
   for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
         if (m[r][c] == 0) {
            zeroInRow[r] = 1;
            zeroInCol[c] = 1;
         }
      }
   }

   // go through once more replacing with 0's where necessary
   for (int r = 0; r < numRows; r++)
      for (int c = 0; c < numCols; c++)
         if (zeroInRow[r] == 1 || zeroInCol[c] == 1)
            m[r][c] = 0;
}

int main() {
   int m[][4] = {
      {1,0,1,1},
      {1,1,1,1},
      {1,1,1,0},
      {1,1,1,1}
   };

   cout << "Original Matrix:\n";
   printMatrix(m,4,4);
   cout << endl;

   cout << "Zeroed Matrix:\n";
   zeroMatrix(m,4,4);
   printMatrix(m,4,4);
   return 0;
}
