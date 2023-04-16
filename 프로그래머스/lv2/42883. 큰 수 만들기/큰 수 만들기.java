import java.util.*;
class Solution {
    public String solution(String number, int k) {
        
        StringBuilder stb = new StringBuilder(number);
        
        //앞에 최대 k개가 있는 수 중, 가장 큰 수의 index(start) 골라내기
        int max = 0;
        int start = 0;
        for(int i = 0; i < k; i++){
            if(stb.charAt(i) > max){
                max = stb.charAt(i);
                start = i;
            }
        }
        //start 앞의 수는 모두 제거
        stb.delete(0, start);
        k-= start;
        
        //다음 숫자보다 작으면 제거
        for(int i = 0; i < stb.length() - 1; i++){
            if(k == 0){
                break;
            }
            if(stb.charAt(i) < stb.charAt(i+1)){
                stb.deleteCharAt(i);
                k--;
                i -= 2;
            }
        }
        
        //뒤에서부터 제거
        stb.delete(stb.length()-k, stb.length());

        String answer = stb.toString();
        return answer;
    }
}