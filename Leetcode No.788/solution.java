class Solution {
    
    public int rotatedDigits(int n) {
        int res = 0;
        for(int i=1;i<=n;i++)
        {
            if(isValid(i)) res++;
        }
        return res;
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