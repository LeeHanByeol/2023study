import java.util.*;
class Solution {
    
    int[][] matrix;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;
        
        
        //matrix 만들기
        matrix = new int[rows+1][columns+1];    //편의상 1행1열부터 시작하도록
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                matrix[i][j] = (i-1)*columns + j;
            }
        }        
        
        //회전
        for(int[] rotInform : queries){
            answer[idx++] = rotate(rotInform);
        }
        
        return answer;
    }
    
    public int rotate(int[] rotInform){
        
        int min = 10000;
        
        Queue<Integer> queue = new LinkedList<>();
        int x1= rotInform[0], y1 = rotInform[1];
        int x2= rotInform[2], y2 = rotInform[3];
        queue.add(10000);
        
        //go right
        for(int i = y1; i < y2; i++){
            if(min > matrix[x1][i]){
                min = matrix[x1][i];
            }
            queue.add(matrix[x1][i]);
            matrix[x1][i] = queue.poll();
        }
        //go down
        for(int i = x1; i < x2; i++){
            if(min > matrix[i][y2]){
                min = matrix[i][y2];
            }
            queue.add(matrix[i][y2]);
            matrix[i][y2] = queue.poll();
        }
        //go left
        for(int i = y2; i > y1; i--){
            if(min > matrix[x2][i]){
                min = matrix[x2][i];
            }
            queue.add(matrix[x2][i]);
            matrix[x2][i] = queue.poll();
        }        
        //go up
        for(int i = x2; i >= x1; i--){
            if(min > matrix[i][y1]){
                min = matrix[i][y1];
            }
            queue.add(matrix[i][y1]);
            matrix[i][y1] = queue.poll();
        }        
     
        return min;
    }    
}