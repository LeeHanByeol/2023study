class Solution {
    
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            if(divide(n, i)){
                answer++;
            }
        }
        
        return answer;
    }
    public boolean divide(int n, int start){
        int sum = 0;
        while(sum < n){
            sum += start;
            start++;
        }
        if(sum == n){
            return true;
        }
        else{
            return false;
        }
    }
}