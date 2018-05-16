class Solution {
    // idea: using DFS on each '1' nodes, stop searching whenever encounters a '0' node
    private void dfs(char[][] grid, int x, int y, int width, int height) {
        if(x < 0 || y < 0 || x >= width || y >= height || grid[y][x] == '0') return;
        grid[y][x] = '0';
        dfs(grid, x+1, y, width, height);
        dfs(grid, x-1, y, width, height);
        dfs(grid, x, y+1, width, height);
        dfs(grid, x, y-1, width, height);
    }
    
    public int numIslands(char[][] grid) {
        int height = grid.length;
        if(height == 0) return 0;
        int width = grid[0].length;
        int count = 0;
        for(int y = 0; y < height; ++y){
            for(int x = 0; x < width; ++x){
                if(grid[y][x] == '1') {
                    dfs(grid, x, y, width, height);
                    count ++;
                }
            }
        }
        return count;
    }
}
