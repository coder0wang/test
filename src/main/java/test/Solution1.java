package test;

public class Solution1 {
	/*public static void main(String[] args) {
		String str = "hi,hello world! ";
String reverseStr = new StringBuilder(str).reverse().toString();
StringBuilder rs = new StringBuilder();
		for(int i=str.length()-1;i>-1;i--){
			rs.append(str.charAt(i));
		}
		System.out.println(reverseStr);
		System.out.println(rs);
	}
*/
	public int solution(int[] A) {
	    int result = 0;
	    int N = A.length;
	    int [] prefix = new int [N+1];
	    for (int i = 1; i < prefix.length; i++) {
	        prefix[i] = prefix[i-1] + A[i-1];
	    }
	    double avg = Double.MAX_VALUE;
	    for (int i = 1; i < N; i++) {
	        for (int j = i+1; j <=N; j++) {
	            double temp = (double)(prefix[j]-prefix[i-1]) /(double)(j-i+1);
	            if (temp < avg) {
	                avg = temp;
	                result = i-1;
	            }
	        }
	    }
	    return result;
	}
	public static void main(String[] args) {
//		int A[] = {4,5,1,1,1,1,4,3,1};
//		Solution solution = new Solution();
//		System.out.println(solution.solution(A));
		System.out.println((int) (Math.random() * 20));
	}
}

