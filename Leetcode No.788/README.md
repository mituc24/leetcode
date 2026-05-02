# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
In first solution, I think very simple: traverses throght all the number, if it does not contain 3 or 4 or 7, then I will try to rotate the digit. Then check if the new number is valid or not. You can see my first approach in `isValid_notOptimized`. It pass all testcase but it too slow.
# Approach
<!-- Describe your approach to solving the problem. -->
Then I read the description carefully and see that, the number is valid if it does not contain 3 or 4 or 7 and has at least one change number (2,5,6,9). I can speed up by do module to extract digit, not need to convert to string.
# Complexity
- Time complexity: O(nlogn)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    
    public int rotatedDigits(int n) {
        int res = 0;
        for(int i=1;i<=n;i++)
        {
            if(isValid(i)) res++;
        }
        return res;
    }

    boolean isValid_notOptimized(int x)
    {
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder(s);
        //if(sb.contain())
        for(int i=0;i<sb.length();i++)
        {
            char c = sb.charAt(i);
            if(c == '3'||c =='4'||c =='7') return false;
            if(c == '2') sb.setCharAt(i,'5');
            else if(c == '5') sb.setCharAt(i,'2');
            else if(c == '6') sb.setCharAt(i,'9');
            else if(c == '9') sb.setCharAt(i,'6');
        }
        if(sb.toString().equals(s)) return false;
        return true;
    }

    boolean isValid(int x)
    {
        int digit = 0;
        boolean hasChange = false;
        while(x>0)
        {
            digit = x%10;
            if(digit == 3 || digit == 4 || digit == 7)
            return false;

            if(digit == 2 || digit == 5 || digit == 6 || digit == 9)
            hasChange = true;
            x = x/10;
        }
        return hasChange;
    }
    
}
```