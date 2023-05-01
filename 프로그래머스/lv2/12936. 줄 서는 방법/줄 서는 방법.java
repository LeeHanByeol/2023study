import java.util.*;
class Solution {
    
    long[] fac = new long[20];
    
    public int[] solution(int n, long k) {
        
        fac[1] = 1;
        
        //자리 배정을 받지 않은 사람의 번호(1~n)
        ArrayList<Integer> num = new ArrayList<>(n);         
        for(int i = 1; i <= n; i++){
            num.add(i);
        }

        //k번째 방법
        int[] answer = new int[n];
        int idx = 0;
        
        //(a-1)! < k <= a!인 a를 찾는다
        int a = 0;
        for(int i = n; i > 0; i--){
            if(factorial(i-1) < k && k <= factorial(i)){
                a = i;
                break;
            }
            answer[idx++] = num.remove(0);
        }
        
        while(a != 1){
            int q = (int)(k / factorial(a-1));     //quotient
            k = k % factorial(a-1);     //remainder
            if(k == 0){
                q -= 1;
                k += factorial(a-1);
            }
            answer[idx++] = num.remove(q);
            a--;
        }
        answer[idx] = num.remove(0);
        
        return answer;
    }
    
    public long factorial(int n){
        if(fac[n] != 0){
            return fac[n];
        }
        fac[n] = n * factorial(n-1);
        return fac[n];
    }
}