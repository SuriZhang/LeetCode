class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if(row == 0 || matrix == null) return new ArrayList<Integer>();
        int col = matrix[0].length;
        List<Integer> res = new ArrayList();
        int rowStart = 0;
        int rowEnd = row-1;
        int colStart = 0;
        int colEnd = col-1;
        while(rowStart <= rowEnd && colStart <= colEnd) {
            // first row
            for(int i = colStart; i <= colEnd; ++i) {
                res.add(matrix[rowStart][i]);
            }
            rowStart++;
            // last col
            for(int i = rowStart; i <= rowEnd; ++i) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            // last row
            if(rowEnd >= rowStart) {
                for(int i = colEnd; i >= colStart; --i) {
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            // first col;
            if(colStart <= colEnd){
                for(int i = rowEnd; i >= rowStart; --i) {
                    res.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return res;
    }
}
