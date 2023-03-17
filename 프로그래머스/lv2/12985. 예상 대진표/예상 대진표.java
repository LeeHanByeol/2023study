class Solution
{
    public int solution(int n, int a, int b)
    {
        
        //a < b 순서로 만듦
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        
        int answer = 1;
        while(!((a + 1 == b) && (a>>1 == (b>>1)-1))){
            if(isOdd(a)){
                a = (a+1)>>1;
            }
            else{
                a = a>>1;
            }
            if(isOdd(b)){
                b = (b+1)>>1;
            }
            else{
                b = b>>1;
            }
            answer++;
        }
        
        return answer;
    }
    
    public boolean isOdd(int a){
        if(a % 2 == 0){
            return false;
        }
        return true;
    }
}