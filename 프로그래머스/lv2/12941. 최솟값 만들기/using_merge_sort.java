class Solution
{
    public int solution(int []A, int []B)
    {
        //mergeSort는 오름차순 정렬
        mergeSort(A, A.length);
        mergeSort(B, B.length);        
        
        
        int answer = 0;
        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[A.length-i-1];
        }

        return answer;
    }
    
    public static void mergeSort(int[] a, int len)
    {
        //divide
        if(len < 2){
            return;
        }
        
        int mid = len/2;
        int[] l = new int[mid];
        int[] r = new int[len-mid];
        
        for(int i = 0; i < mid; i++){
            l[i] = a[i];
        }
        for(int i = 0; i < len-mid; i++){
            r[i] = a[mid + i];
        }
        mergeSort(l, mid);
        mergeSort(r, len-mid);
        
        //conquer
        merge(a, l, mid, r, len-mid);
    }
    
    public static void merge(int[] a, int[] l, int l_len, int[] r, int r_len)
    {
        int i = 0, j = 0, k = 0;
        while(i < l_len && j < r_len){
            if(l[i] < r[j]){
                a[k++] = l[i++];
            }
            else{
                a[k++] = r[j++];
            }
        }
        while(i < l_len){
            a[k++] = l[i++];
        }
        while(j < r_len){
            a[k++] = r[j++];
        }
    }
}


