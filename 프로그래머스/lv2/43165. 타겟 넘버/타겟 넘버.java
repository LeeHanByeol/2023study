class Solution {
    public int solution(int[] numbers, int target) {
        return recursion(numbers, 0, target, 0);
    }

    public int recursion(int[] numbers, int idx, int target, int sum){
        if(idx == numbers.length){
            return (sum==target) ? 1 : 0;
        }
        
        return recursion(numbers, idx+1, target, sum + numbers[idx]) 
            + recursion(numbers, idx+1, target, sum - numbers[idx]);        
    }
}