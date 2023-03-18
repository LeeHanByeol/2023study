class Solution {
    public int[] solution(int brown, int yellow) {

        
        //전체 카펫의 가로길이 w, 세로길이 h
        int w, h;

        // 2*(w+h) = brown + 4
        int add = (brown+4)>>1;
        // 넓이w*h = yellow+brown
        int mul = yellow + brown;
        // (w-h)^2 = (w+h)^2 - 4wh
        int sub = (int)Math.sqrt(Math.pow(add, 2) - 4*mul);
        
        w = (add+sub)>>1;
        h = (add-sub)>>1;
        
        return new int[]{w, h};
    }
}