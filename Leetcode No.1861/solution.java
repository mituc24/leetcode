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