class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int first = findFirst(tree, squirrel, nuts);
        int totalDist = 0;
        totalDist += calcDist(squirrel, nuts[first]) + calcDist(nuts[first], tree);
        
        for(int i = 0; i < nuts.length; ++i) {
            if (i != first) {
                totalDist += 2 * calcDist(nuts[i], tree);
            }
        }
        return totalDist;
    }
    
    public int calcDist(int[] item1, int[] item2) {
        return Math.abs(item1[0]-item2[0]) + Math.abs(item1[1]-item2[1]);
    }
    
    public int findFirst(int[] tree, int[] squirrel, int[][] nuts) {
        int minDist = Integer.MAX_VALUE;
        int result = -1;
        for(int i = 0; i < nuts.length; ++i) {
            int d = calcDist(squirrel, nuts[i]) - calcDist(tree, nuts[i]);
            if (d < minDist) {
                result = i;
                minDist = d;
            }
        }
        
        return result;
    }
}


