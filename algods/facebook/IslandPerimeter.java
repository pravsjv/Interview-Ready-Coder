package algods.facebook;
/**
 * https://leetcode.com/problems/island-perimeter/description/
 * Leetcode: 463
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if(grid == null)
            throw new IllegalArgumentException("Input cannot be null.");

        int result = 0;
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
                if(grid[row][col] == 1){
                    result += 4;

                    if(row > 0 && grid[row-1][col] == 1)
                        result -= 2;

                    if(col > 0 && grid[row][col-1] == 1)
                        result -= 2;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};

        IslandPerimeter obj = new IslandPerimeter();
        System.out.println("The perimeter of the island perimeter is: "+obj.islandPerimeter(grid));
    }
}
