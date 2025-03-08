public class q2379 {

    // You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.

    // You are also given an integer k, which is the desired number of consecutive black blocks.

    // In one operation, you can recolor a white block such that it becomes a black block.

    // Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.



    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int countB = 0, ans = 100;
    
            for(int i =0;i<blocks.length();i++){
                if (i - k >= 0 && blocks.charAt(i - k) == 'B') countB--;
                if (blocks.charAt(i) == 'B') countB++;
                ans = Math.min(ans, k - countB);
            }
            return ans;
        }
    }
}
