# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Imagine you play puzzle when move a piece on a tray, when it meets the obstacle, you can't not do the movement. So instead of seeing it falling down by gravity, just move it from left to right.

# Approach
<!-- Describe your approach to solving the problem. -->
First, interact with `boxGrid`. Set a `ground` variable as m-1, then move to left, if meet stone, then swap stone and ground position, remember to descrease the ground because its position now occupies by a stone. If meet obstacle, just move ground to obstacle and descrease it.

Then just simply transform the `boxGrid` to another m*n grid and return the result. 
# Complexity
- Time complexity: O(m*n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(m*n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] res = new char[m][n];
        char STONE = '#';
        char OB = '*';
        for(int i = n-1; i>=0; i--)
        {
            int ground = m-1;
            for(int j = m-1; j>=0; j--)
            {
                if(boxGrid[i][j] == STONE)
                {
                    boxGrid[i][j] = boxGrid[i][ground];
                    boxGrid[i][ground] = STONE;
                    ground--;
                }
                else if (boxGrid[i][j] == OB)
                {
                    ground = j-1;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                res[j][n-1-i] = boxGrid[i][j];
            }
        }
        return res;
    }
}
```