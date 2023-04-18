import java.util.*;
class Solution {
    public String solution(int n) {
        int[] num = Arrays.stream(Integer.toString(n, 3).split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        return to124(num);
    }
    
    public String to124(int[] num){
        
        for(int i = num.length - 1; i > 0; i--){
            if(num[i] <= 0){
                num[i] += 3;
                num[i-1] -= 1;
            }
        }
                
        StringBuilder stb = new StringBuilder(num.length);
        for(int a : num){
            switch(a){
                case 1:
                    stb.append(1);
                    break;
                case 2:
                    stb.append(2);
                    break;
                case 3:
                    stb.append(4);
                    break;
            }
        }
        return stb.toString();        
    }
}