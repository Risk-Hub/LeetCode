class Solution {
    public int maximum69Number (int num) {
        int temp = num;
        int size = 0;
        while (temp > 0){
            temp /= 10;
            size++;
        }
        // System.out.println(size);
        temp = num;
        int ans = 0;
        boolean flag = false;
        for(int i = size-1;i >= 0;i--){
            int rem = (int) (temp / Math.pow(10,i));
            temp %= (int)Math.pow(10,i);
            if(rem == 6 && !flag){
                ans += Math.pow(10,i) * 9;
                flag = true;
            }
            else {
                ans += Math.pow(10,i) * rem;
            }
        }
        return ans;
    }
}