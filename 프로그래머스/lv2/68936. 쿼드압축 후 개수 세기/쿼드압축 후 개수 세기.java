class Solution {
    
    int[][] whole;
    int[] answer = new int[2];  //int[0] -> num of 0, int[1] -> num of 1   

    public int[] solution(int[][] arr) {
        
        whole = arr;
        check(0, 0, arr.length);
        return answer;
    }
    
    public void check(int r_idx, int c_idx, int n){
        
        if(n==1 || compress(r_idx, c_idx, n)){  //최소단위 or 압축 가능
            answer[whole[r_idx][c_idx]]++;
            return;
        }
        
        //4개로 쪼개기
        n = n>>1;
        check(r_idx, c_idx, n);     //1번째 조각
        check(r_idx+n, c_idx, n);   //2번째 조각
        check(r_idx, c_idx+n, n);   //3번째 조각
        check(r_idx+n, c_idx+n, n); //4번째 조각
    }
    
    public boolean compress(int r_idx, int c_idx, int n){
        
        int criterion = whole[r_idx][c_idx];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(criterion != whole[r_idx+i][c_idx+j])
                    return false;
            }
        }
        return true;
    }
}