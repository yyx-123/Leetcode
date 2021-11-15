package editor.cn;
//给定一个二维矩阵 matrix，以下类型的多个请求： 
//
// 
// 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
// 
//
// 实现 NumMatrix 类： 
//
// 
// NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化 
// int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角
// (row2, col2) 的子矩阵的元素总和。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: 
//["NumMatrix","sumRegion","sumRegion","sumRegion"]
//[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,
//1,2,2],[1,2,2,4]]
//输出: 
//[null, 8, 11, 12]
//
//解释:
//NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,
//0,1,7],[1,0,3,0,5]]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// -105 <= matrix[i][j] <= 105 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// 最多调用 104 次 sumRegion 方法 
// 
//
// 
//
// 注意：本题与主站 304 题相同： https://leetcode-cn.com/problems/range-sum-query-2d-immutab
//le/ 
// Related Topics 设计 数组 矩阵 前缀和 
// 👍 11 👎 0
	

//2021-11-13 15:23:41
public class Offer013{
    public static void main(String[] args) {
        Offer013 offer013 = new Offer013();
        // TO TEST
        int[][] matrix = {{3,0,1,4,2},
                          {5,6,3,2,1},
                          {1,2,0,1,5},
                          {4,1,0,1,7},
                          {1,0,3,0,5},
        };

        NumMatrix numMatrix = offer013.new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2,1,4,3));
        System.out.println(numMatrix.sumRegion(1,1,2,2));
        System.out.println(numMatrix.sumRegion(1,2,2,4));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 计算每一行的前缀和（本质还是多次计算一维前缀和）
     */
    /*class NumMatrix {
        private int rowCnt;
        private int colCnt;
        private int[][] rowSum;

        public NumMatrix(int[][] matrix) {
            rowCnt = matrix.length;
            colCnt = matrix[0].length;
            rowSum = new int[rowCnt][colCnt];

            for (int i = 0; i < rowCnt; i++) {
                rowSum[i][0] = matrix[i][0];
                for (int j = 1; j < colCnt; j++) {
                    rowSum[i][j] = rowSum[i][j - 1] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                if (col1 == 0){
                    sum += rowSum[i][col2];
                }else{
                    sum += rowSum[i][col2] - rowSum[i][col1 - 1];
                }
            }
            return sum;
        }
    }*/

    /**
     * 二维前缀和。在实现的过程中还是用到了每一行的前缀和。在初始化的时候比较慢不过查询时比一维的前缀和快。受限于初始化时二维前缀和的计算速度，总体而言还是比较慢的
     */
    /*class NumMatrix {
        private int rowCnt;
        private int colCnt;
        private int[][] rowSum; // 每一行的前缀和
        private int[][] Sum;    // 每一个元素到[0,0]的二位前缀和

        public NumMatrix(int[][] matrix) {
            rowCnt = matrix.length;
            colCnt = matrix[0].length;
            rowSum = new int[rowCnt][colCnt];
            Sum = new int[rowCnt][colCnt];

            // 先计算每行的前缀和
            for (int i = 0; i < rowCnt; i++) {
                rowSum[i][0] = matrix[i][0];
                for (int j = 1; j < colCnt; j++) {
                    rowSum[i][j] = rowSum[i][j - 1] + matrix[i][j];
                }
            }

            // 再计算[i,j]到[0,0]的矩阵块的和S[i,j]
            for (int i = 0; i < rowCnt; i++) {
                for (int j = 0; j < colCnt; j++) {
                    for (int k = 0; k <= i; k++) {
                        Sum[i][j] += rowSum[k][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) return Sum[row2][col2];
            else if (row1 == 0) return Sum[row2][col2] - Sum[row2][col1 - 1];
            else if (col1 == 0) return Sum[row2][col2] - Sum[row1 - 1][col2];
            else return Sum[row2][col2] - Sum[row1 - 1][col2] - Sum[row2][col1 - 1] + Sum[row1 - 1][col1 - 1];
        }
    }*/

    /**
     * 二维前缀和。脱离了单行前缀和的限制，用二维前缀和来递推计算二维前缀和，初始化速度快。且二维前缀和的特性也使得查询速度较快。
     */
    class NumMatrix {
        private int rowCnt;
        private int colCnt;
        private int[][] Sum;    // 每一个元素到[0,0]的二位前缀和

        public NumMatrix(int[][] matrix) {
            rowCnt = matrix.length;
            colCnt = matrix[0].length;
            Sum = new int[rowCnt + 1][colCnt + 1];

            // 再计算[i,j]到[0,0]的矩阵块的和S[i,j]
            for (int i = 1; i <= rowCnt; i++) {
                for (int j = 1; j <= colCnt; j++) {
                    Sum[i][j] = Sum[i - 1][j] + Sum[i][j - 1] - Sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) return Sum[row2 + 1][col2 + 1];
            else if (row1 == 0) return Sum[row2 + 1][col2 + 1] - Sum[row2 + 1][col1];
            else if (col1 == 0) return Sum[row2 + 1][col2 + 1] - Sum[row1][col2 + 1];
            else return Sum[row2 + 1][col2 + 1] - Sum[row1][col2 + 1] - Sum[row2 + 1][col1] + Sum[row1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
