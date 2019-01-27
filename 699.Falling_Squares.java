class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int[] qans = new int[positions.length];
        
        for (int i = 0; i < positions.length; ++i) {
            int l = positions[i][0];
            int s = positions[i][1];
            int r = l + s;
            qans[i] += s;
            
            for (int j = i + 1; j < positions.length; ++j) {
                int left = positions[j][0];
                int size = positions[j][1];
                int right = left + size;
                
                // intersects
                if (left < r && l < right) {
                    qans[j] = Math.max(qans[j], qans[i]);
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int cur = -1;
        
        // compute a running max
        for (int x : qans) {
            cur = Math.max(cur, x);
            result.add(cur);
        }
        return result;
    }
}

