import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int idx = 0;

        Stack<Integer> idxStk = new Stack<>();
        for(int n : numbers){
            
            while(!idxStk.empty()){
                int idx_tmp = idxStk.peek();
                if(numbers[idx_tmp] >= n){
                    break;
                }
                answer[idx_tmp] = n;  
                idxStk.pop();
            }
            
            idxStk.push(idx++);
        }
        
        while(!idxStk.empty()){
            answer[idxStk.pop()] = -1;
        }
        
        return answer;
    } 
}