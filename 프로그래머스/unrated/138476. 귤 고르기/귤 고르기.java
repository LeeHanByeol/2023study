import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Arrays.sort(tangerine);
        
        //귤 크기별 개수 저장하기: O(n)
        int[] numBySize = new int[tangerine.length];
        int size_index = 0;
        int current = tangerine[0];
        for(int i = 0; i < tangerine.length; i++){
            
            if(numBySize[size_index] >= k){
                return 1;
            }
            
            if(current == tangerine[i]){
                numBySize[size_index]++;
            }
            else{
                current = tangerine[i];
                numBySize[++size_index] += 1;
            }
        }
                
        //
        Arrays.sort(numBySize, 0, size_index+1);
        int answer = 0;
        while(k > 0){
            k -= numBySize[size_index--];
            answer++;
        }
        
        
        return answer;
    }
}