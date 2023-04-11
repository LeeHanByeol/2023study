import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        answer[numbers.length-1] = -1;
        for(int i = numbers.length - 1; i >= 0; i--){
            
            for(int j = i+1; j < numbers.length; j++){
                if(numbers[i] < numbers[j]){
                    answer[i] = numbers[j];
                    break;
                }
                //뒤에 있는 애보다 내가 더 크거나 같음
                if(answer[j] == -1){
                    answer[i] = -1;
                    break;
                }
                if(numbers[i] < answer[j]){
                    answer[i] = answer[j];
                    break;
                }
            }
        }
        
        return answer;
    } 
}