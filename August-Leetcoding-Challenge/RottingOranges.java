/*
* In a given grid, each cell can have one of three values:
    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.
* Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
* Return the minimum number of minutes that must elapse until no cell has a fresh orange.
* If this is impossible, return -1 instead.
* Example 1:
    Input: [[2,1,1],[1,1,0],[0,1,1]]
    Output: 4
* Example 2:
    Input: [[2,1,1],[0,1,1],[1,0,1]]
    Output: -1
    Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
* Example 3:
    Input: [[0,2]]
    Output: 0
    Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
* Note:
    1 <= grid.length <= 10
    1 <= grid[0].length <= 10
    grid[i][j] is only 0, 1, or 2.
* */

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque();
        int freshOranges = 0;
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                if (grid[r][c] == 2) {
                    queue.offer(new Pair(r, c));
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
        if (freshOranges==0) {
            return 0;
        }
        int minutesElapsed = -1;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size=queue.size();
            while (size-->0) {
                Pair<Integer, Integer> p = queue.poll();
                int row = p.getKey();
                int col = p.getValue();
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if (neighborRow >= 0 && neighborRow < ROWS &&
                            neighborCol >= 0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            queue.offer(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }

            minutesElapsed++;
        }
        return freshOranges == 0 ? minutesElapsed : -1;
    }
}
