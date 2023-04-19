class Solution {
    public int[] solution(int n) {

        int[][] triangle = new int[n][n];
        int r = -1, c = 0;       //현재 위치
        int num = 1;            //채워넣을 숫자
        int action = 0;         //0->왼쪽 아래 1->오른쪽 2->왼쪽 위
        for(int i = n; i > 0; i--){
            for(int j = 0; j < i; j++){
                r = move_r(action, r);
                c = move_c(action, c);
                triangle[r][c] = num++;
            }
            action = (++action) % 3;
        }

        //정답 채우기
        int[] answer = new int[(n*(n+1))>>1];        //칸의 개수: n(n+1)/2        
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[idx++] = triangle[i][j];
            }
        }
        
        return answer;
    }

    
    public int move_r(int action, int r){
        if(action == 0){
            return ++r;
        }
        if(action == 1){
            return r;
        }
        if(action == 2){
            return --r;
        }
        System.out.println("error");
        return -1;
    }
    
    public int move_c(int action, int c){
        if(action == 0){
            return c;
        }
        if(action == 1){
            return ++c;
        }
        if(action == 2){
            return --c;
        }
        System.out.println("error");
        return -1;        
    }
    
    
}