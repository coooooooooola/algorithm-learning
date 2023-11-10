package matrix;

/**
 * 矩阵置零
 * https://leetcode.cn/problems/set-matrix-zeroes/description/
 */
public class setZeros {
    /**
     * 申请m+n的空间记录行和列是否有0
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rowFlag = new int[row];
        int[] colFlag = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = 1;
                    colFlag[j] = 1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            if (rowFlag[i] == 1) {
                for (int c = 0; c < col; c++) {
                    matrix[i][c] = 0;
                }
            }
        }

        for (int i = 0; i < col; i++) {
            if (colFlag[i] == 1) {
                for (int c = 0; c < row; c++) {
                    matrix[c][i] = 0;
                }
            }
        }
    }
}
