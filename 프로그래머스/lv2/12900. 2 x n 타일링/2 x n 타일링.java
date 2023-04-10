class Solution {
    
    static int CONSTANT = 1000000007;
    
    public int solution(int n) {
        
        //DP
        int[] memory = new int[n+1];
        for(int i = 0; i <= n; i++){     //initialize
            memory[i] = -1;         
        }
        
        return fill(n, memory);
    }
    
    public int fill(int n, int[] memory){
        
        if(memory[n] != -1){
            return memory[n];
        }
        
        if(n == 0 || n == 1) return 1;
        if(n < 0) return 0;
        
        int answer = ((fill(n-1, memory) % CONSTANT)  + (fill(n-2, memory) % CONSTANT)) % CONSTANT;
        memory[n] = answer;
        return answer;
    }
}