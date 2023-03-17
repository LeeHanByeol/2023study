class Solution {
    
    static int[] mem = new int[2001];
    
    public long solution(int n) {
        long answer = jump(n);
        return answer;
    }
    
    public int jump(int n){
        if(n<=1){
            return 1;
        }
        if(mem[n] != 0){
            return mem[n];
        }
        mem[n] = (jump(n-1) + jump(n-2))%1234567;
        return mem[n];
    }
}