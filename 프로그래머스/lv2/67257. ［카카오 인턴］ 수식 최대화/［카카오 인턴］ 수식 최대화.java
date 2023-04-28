import java.util.*;
class Solution {
    
    //연산문자의 priority[6][3];
    char[][] priority = {{'+', '-', '*'}, {'+', '*', '-'},
                        {'-', '+', '*'}, {'-', '*', '+'},
                        {'*', '+', '-'}, {'*', '-', '+'}};
    
    public long solution(String expression) {
        
        long answer = 0;        
        
        //초기화
        List<Long> num = new ArrayList<>();
        for(String a : expression.split("[*+-]+")){
            num.add(Long.parseLong(a));
        }
        List<Character> operator = new ArrayList<>();
        for(char a : expression.replaceAll("[0-9]+", "").toCharArray()){
            operator.add(a);
        }
        
        //Brute-Force
        for(char[] prior : priority){   //적용할 우선순위
            
            //deep copy
            List<Long> temp_n = new ArrayList<>(num);
            List<Character> temp_op = new ArrayList<>(operator);
            
            for(char op : prior){       //차례가 된 연산자
                
                for(int i = 0; i < temp_op.size(); i++){    //리스트를 순회하며 연산
                    if(temp_op.get(i) == op){
                        temp_n.add(i, cal(temp_n.remove(i), op, temp_n.remove(i)));
                        temp_op.remove(i--);
                    }
                }
            }
            
            long result = temp_n.get(0);
            result = (result < 0) ? ~result+1 : result;     //abs
            answer = (answer < result) ? result : answer;
        }
        
        return answer;
    }
    
    public long cal(long num1, char op, long num2){
        
        switch(op){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
        }
        
        System.out.println("error");
        return -1;
    }
}