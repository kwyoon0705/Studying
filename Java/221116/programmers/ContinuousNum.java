package programmers;

public class ContinuousNum {
	public int[] solution(int num, int total) {
		int[] answer = new int[num];
		if(num%2==0) {
			for(int i=0;i<answer.length;i++) {
				answer[i]=total/num;
			}
		}else {
			
		}
		
		return answer;
	}
}
