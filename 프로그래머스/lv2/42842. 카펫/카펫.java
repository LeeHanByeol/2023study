class Solution {
    public int[] solution(int brown, int yellow) {

        
        int row = yellow;
        int col = 1;

        while(true){
            while(yellow % row != 0){
                row--;
            }
            col = yellow / row;
            
            if((row + col)<<1 == (brown - 4)){
                break;
            }
            else{
                row--;
            }
        }
        
        return new int[]{row+2, col+2};
    }
}