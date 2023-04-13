import java.util.*;
class Solution {
    public String solution(int[] numbers) {

        //모두 0인가 검증
        boolean all_zero = true;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] != 0){
                all_zero = false;
                break;
            }
        }
        if(all_zero){
            return "0";
        }


        //String 배열로 바꿔준다
        String[] strArr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strArr[i] = Integer.toString(numbers[i]);
        }

        //정렬
        Arrays.sort(strArr, (a, b) -> Integer.parseInt(b+a) - Integer.parseInt(a+b));

        //string화
        return String.join("", strArr);
    }
}
