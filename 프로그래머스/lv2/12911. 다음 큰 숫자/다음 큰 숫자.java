//Bit 연산
//가장 마지막에 등장하는 '01'을 '10'으로 바꿔주고, 이후 등장하는 숫자들은 000...111 순서로 정렬해야한다

class Solution {
    
    public int solution(int n) {
        //ex) n = 0100 1110
        
        //n&(-n) = 가장 오른쪽의 '1' bit
        // n = 0100 1110
        //-n = 1001 0010
        int rightmost = n&(-n); //0000 0010
        
        //n에 rightmost를 더해주면
        //가장 마지막에 등장하는 '01' -> '10', 그 이후로는 0
        int change = n + rightmost;             //0101 0000
        
        //n과 change의 XOR 연산 => '10'부터 가장 오른쪽 '1'이었던 곳까지 true
        //n^change = 0001 1110
        //상관없는 뒷자리 0은 밀어버린다; 0000 1111
        //'10' 변한 것도 계산했으니까 두칸 밀어버린다; 0000 0011
        int lastBit = ((n^change) / rightmost)>>2;
        
        //합쳐준다
        int answer = change | lastBit;
        
        return answer;
    }
}