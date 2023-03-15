class Solution {
    
    public int solution(int n) {
        
        //n&(-n) = 가장 오른쪽의 '1' bit
        int rightmost = n&(-n);
        
        //
        int change = n + rightmost;
        int lastBit = ((n^change) / rightmost)>>2;
        int answer = change | lastBit;
        
        return answer;
    }
}