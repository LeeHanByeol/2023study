import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        //String 배열로 바꿔준다
        String[] strArr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strArr[i] = Integer.toString(numbers[i]);
        }
        
        //정렬
        Arrays.sort(strArr, (a, b) -> Integer.parseInt(b+a) - Integer.parseInt(a+b));
        
        //모두 0이라면
        if(strArr[0].equals("0")){
            return "0";
        }
        
        //string화
        return String.join("", strArr);
    }
}