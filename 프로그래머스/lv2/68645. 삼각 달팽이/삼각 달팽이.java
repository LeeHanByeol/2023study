class Solution {
    public int[] solution(int n) {

        
        int[][] triangle = new int[n][n];
        int r = 0, c = 0;       //현재 위치
        int num = 1;            //채워넣을 숫자
        int action = 1;         //1->왼쪽 아래 2->오른쪽 3->왼쪽 위
        for(int i = n; i > 0; i--){
            switch(action){
                case 1:                 //go down
                    for(int j = 1; j < i; j++){
                        triangle[r++][c] = num++;
                    }
                    triangle[r][c++] = num++;
                    action++;
                    break;
                case 2:                 //go right
                    for(int j = 1; j < i; j++){
                        triangle[r][c++] = num++;
                    }
                    triangle[r--][c--] = num++;
                    action++;
                    break;
                case 3:                 //go up
                    for(int j = 1; j < i; j++){
                        triangle[r--][c--] = num++;
                    }
                    triangle[r++][c] = num++;
                    action = 1;
                    break;
            }
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
    
    
}