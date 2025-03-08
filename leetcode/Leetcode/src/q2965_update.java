class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int[] arr = new int[grid.length*grid.length];
        int[] cntArr = new int[arr.length];
        int temp = 0;
        for(int i = 0; i<grid.length;i++){
            for(int j=0; j<grid.length;j++){
                arr[temp] = grid[i][j];
                temp++;
            }
        }
        for(int i = 1; i<= arr.length;i++){
            for(int j: arr){
                if(i==j){
                    cntArr[i-1]++;
                }
            }
        }
        for(int i = 0; i< arr.length;i++){
            if(cntArr[i] >1){
                ans[0] = i+1;
            }else if(cntArr[i] <1){
                ans[1] = i+1;
            }
        }
        return ans;
    }
}
