import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        int answer = 1;
        
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            
            while(arr[i] != 1){
                for(int j = 2; j <= arr[i]; j++){
                    if(arr[i] % j == 0){
                        divide(i, arr, j);
                        answer *= j;
                        break;
                    }
                }    
            }
            
        }
        return answer;
    }
    
    public void divide(int startIdx, int[] arr, int divisor){
        for(int i = startIdx; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                arr[i] /= divisor;
            }
        }
    }
}