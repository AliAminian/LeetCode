package solution.NearestExitfromEntranceinMaze;

import java.util.*;
/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //int min = sol.nearestExit();
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        maze[entrance[0]][entrance[1]] = '+';

        Queue<int[]> bfsQueue = new LinkedList<>();
        // triple of (x, y, steps)
        bfsQueue.offer(new int[]{entrance[0], entrance[1], -1});

        int res = -1;

        while(!bfsQueue.isEmpty()) {
            int[] p = bfsQueue.poll();
            int x = p[0];
            int y = p[1];
            res = p[2];

            // Check if the cell is an exit cell
            if (!(entrance[0] == x && entrance[1] == y) &&
                    (x ==0 || x == maze.length-1 || y == 0 || y == maze[0].length-1))
                return res+1;

            int[][] neighboursDistances = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

            for (int[] d: neighboursDistances) {
                int newX = x+d[0];
                int newY = y+d[1];

                // Check if new point is navigatable
                if( 0 <= newX && newX < maze.length &&
                        0 <= newY && newY < maze[0].length &&
                        maze[newX][newY] == '.'
                ){
                    bfsQueue.offer(new int[]{ newX, newY, res+1 });
                    maze[newX][newY] = '+';
                }
            }
        }
        return -1;
    }
}
