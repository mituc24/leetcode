# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
First, I have an instant solution that we use an extra array and three pointer. For each iteration, compare two elements of two array, choose one which smaller and add to the extra array. Finally, we just copy extra array to `nums1`.

# Approach
<!-- Describe your approach to solving the problem. -->
But I want to optimize the space complexity so I have another solution. Instead of sorting ascending, we can use the space at the end of `nums1` to add element descending. And we don't have to use an extra array.

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(m+n)
- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(1)
# Code
```java []
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p=m+n-1;

        while(p1>=0 && p2>=0)
        {
            if(nums1[p1] > nums2[p2])
            {
                nums1[p] = nums1[p1];
                p1--;
            }
            else
            {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        if(p2 >=0)
        {
            for(int t=p2; t>=0; t--)
            {
                nums1[p] = nums2[t];
                p--;
            }
        }
    }
}
```