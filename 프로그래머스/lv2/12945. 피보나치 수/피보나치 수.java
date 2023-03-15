class Solution {
    
    //전역변수
    static int[] mem = new int[100001];
    int MOD = 1234567;
        
    public int solution(int n) {    
        //mem 초기화 <= 함수 밖에서는 배열 초기화가 되지 않는다.
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 1;
        for(int i = 3; i < mem.length; i++){
            mem[i] = -1;
        }

        //F(n) 계산
        int answer = fibo(n);
        return answer;
    }
    
    public int fibo(int n){
        //저장해둔 값이 있다면 불러옴
        if(mem[n] != -1){
            return mem[n];
        }
        
        //없으면 계산해서 저장
        mem[n] = (fibo(n-1)%MOD + fibo(n-2)%MOD)%MOD;
        return mem[n];   
    }
}