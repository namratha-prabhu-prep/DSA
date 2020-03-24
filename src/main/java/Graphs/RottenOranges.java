package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
994. Rotting Oranges
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Eg: Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Eg: Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 */
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int gridLength = grid.length, gridColLength = grid[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        int freshOrangeCount = 0;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        // Loop through grid to
        // 1. add index of rotten oranges to the queue
        // 2. Count the number of fresh oranges
        for(int i = 0; i < gridLength; i++) {
            for(int j = 0; j < gridColLength; j++) {
                // fulfilling point 1 above
                if(grid[i][j] == 2) {
                    int rottenIndex = (i*gridColLength) + j;
                    queue.add(rottenIndex);
                } else if(grid[i][j] == 1) {
                    // fulfilling point 2 above
                    freshOrangeCount++;
                }
            }
        }

        // Depth is used to calculate the max depth this graph goes in to rotten all neighboring fresh oranges
        int depth = 0;

        // loop through until the freshOrangeCount is zero or queue is empty and find the neighboring indices of rotten index
        while(freshOrangeCount != 0 && !queue.isEmpty()) {
            // finding out queue size here because we want to increment the depth at every step
            // where the rotten index spoils to the neighboring indices. Because one rotten index
            // can spoil multiple (upto 4) fresh indices
            int qSize = queue.size();

            for(int i = 0; i < qSize; i++) {
                int rottenIndex = queue.poll();
                int rottenIndRow = rottenIndex/gridColLength;
                int rottenIndCol = rottenIndex%gridColLength;

                for(int[] dir : dirs) {
                    int neighRow = dir[0] + rottenIndRow;
                    int neighCol = dir[1] + rottenIndCol;
                    if(neighRow < 0 || neighRow >= gridLength
                            || neighCol < 0 | neighCol >= gridColLength
                            || grid[neighRow][neighCol] != 1) {
                        continue;
                    }
                    // else decrement the freshOrangeCount because we are about to rotten it
                    grid[neighRow][neighCol] = 2;
                    freshOrangeCount--;
                    // add this rotten index to the queue
                    queue.add(neighRow*gridColLength + neighCol);
                }
            }
            // after rotting the oranges for the rottenIndices in the queue increase depth as the neighbors are now rotten
            depth++;
        }
        return freshOrangeCount == 0 ? depth : -1;
    }

    /*
    TC: O(N), where N is the number of cells in the grid.
    SC: O(N), uses a queue to store rottenIndexes and in worst case all the elements might be rotten
     */
}
