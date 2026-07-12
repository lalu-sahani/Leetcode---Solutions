class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    //up
                    if(i==0 || grid[i-1][j] == 0){
                        perimeter ++;
                    }
                    // down
                    if(i == grid.length - 1 || grid[i + 1][j] == 0){
                        perimeter ++;
                    }
                    // left check
                    if(j == 0 || grid[i][j-1] == 0){
                        perimeter ++;
                    }
                    //right check
                    if(j == grid[0].length-1 || grid[i][j + 1] == 0){
                        perimeter ++;
                    }
                }
            }
        }
        return perimeter;
    }
}