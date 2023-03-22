class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        
        int idx = 0;
        for(long i = left; i <= right; i++){
            int row = (int)(i / n);
            int col = (int)(i % n);
            answer[idx++] = (row >= col) ? row+1 : col+1;
        }
        
        
        return answer;
    }
}