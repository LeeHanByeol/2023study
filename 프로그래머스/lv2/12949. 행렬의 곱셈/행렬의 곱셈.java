class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int r = 0; r < arr1.length; r++){
            for(int c = 0; c < arr2[0].length; c++){
                int sum = 0;
                for(int idx = 0; idx < arr2.length; idx++){
                    sum += arr1[r][idx] * arr2[idx][c];
                }
                answer[r][c] = sum;
            }
            
        }

        return answer;
    }
}