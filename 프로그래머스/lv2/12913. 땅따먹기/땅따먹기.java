import java.util.*;

class Solution {
    
    int solution(int[][] land) {
        int answer = 0;
        
        int[][] memory = new int[land.length][4];
        memory[0] = land[0];
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                switch(j){
                    case 0 :
                        memory[i][j] += max(memory[i-1][1], memory[i-1][2], memory[i-1][3]);
                        break;
                    case 1 :
                        memory[i][j] += max(memory[i-1][0], memory[i-1][2], memory[i-1][3]);
                        break;
                    case 2 :
                        memory[i][j] += max(memory[i-1][1], memory[i-1][0], memory[i-1][3]);
                        break;
                    case 3:
                        memory[i][j] += max(memory[i-1][1], memory[i-1][2], memory[i-1][0]);
                        break;
                }
                memory[i][j] += land[i][j];
            }
        }
        
        Arrays.sort(memory[land.length-1]);
        return memory[land.length-1][3];

    }
    
    public static int max(int a, int b, int c){        
        int max = a;
        max = max < b ? b : max;
        max = max < c ? c : max;
        return max;
    }
}