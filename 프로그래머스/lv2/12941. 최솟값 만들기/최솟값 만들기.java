import java.util.*;
import java.lang.Object.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        //오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        //정렬 조건(내림차순...etc) 추가는 wrapper class만 가능하다.
        //Arrays.sort(arr, Comparator)
        //정렬 범위 지정 가능
        //Arrays.sort(arr, int from, int to) -> from~to-1까지 정렬
        
        int answer = 0;
        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[A.length-i-1];
        }
        
        return answer;
    }
}



