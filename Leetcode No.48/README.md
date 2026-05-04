# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
I think about folding a paper and then see it throught a mirror.
# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: O(N^2)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse_row(matrix);
    }

    public void transpose(int[][] matrix)
    {
        int n = matrix.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1; j<n; j++)
            {
                //do swap
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public void reverse_row(int[][] matrix)
    {
        int n = matrix.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n/2;j++)
            {
                //do swap
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }
}
```