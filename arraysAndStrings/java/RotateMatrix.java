/*
   Rotate Matrix: Given an image represented by an NxN matrix, where each pixel
   in the image is 4 bytes, write a method to rotate the image by 90 degrees.
   Can you do this in place?
*/

class RotateMatrix {

   public static void main(String[] args) {
      int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
      System.out.println("Original Matrix:");
      printMatrix(matrix);
      System.out.println("Rotated Matrix:");
      // printMatrix(rotateMatrix(matrix));
      rotateMatrixInPlace(matrix);
      printMatrix(matrix);

   }

   // rotates matrix using O(1) space
   public static void rotateMatrixInPlace(int[][] matrix) {
      int N = matrix.length;
      int numRings = N/2;

      // for each ring
      for (int ring = 0; ring < numRings; ring++) {
         // for each swap pos in ring
         int endRing = N-1-ring;
         for (int i = ring; i < N-1-ring; i++) {
            int temp = matrix[ring][ring+i]; //save top left
            matrix[ring][ring+i] = matrix[endRing-i][ring]; // topleft = bottomleft
            matrix[endRing-i][ring] = matrix[endRing][endRing-i]; // bottomleft = bottomright
            matrix[endRing][endRing-i] = matrix[ring+i][endRing]; // bottomright = topright
            matrix[ring+i][endRing] = temp; // topright = topleft
         }
      }
   }

   // rotates the matrix with O(n^2) space
   public static int[][] rotateMatrix(int[][] matrix) {
      int N = matrix.length;
      int[][] newMatrix = new int[N][N];

      // for each row starting from last row
      for (int r = N-1; r >= 0; r--) {
         // copy it to the appropriate column of the new matrix
         int copyCol = N-1-r;
         for (int c = 0; c < N; c++)
            newMatrix[c][copyCol] = matrix[r][c];
      }
      return newMatrix;
   }

   public static void printMatrix(int[][] matrix) {
      for (int[] row : matrix) {
         for (int i : row) {
            if (i < 10) System.out.print(" ");
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
}
