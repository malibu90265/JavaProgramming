import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemF {
	public static void main(String[] args) throws FileNotFoundException {
		int test;// 입력 데이터의 수
		
		Scanner s = new Scanner(new FileInputStream("input.txt"));
		test = s.nextInt();
		
		for (int i = 0; i < test; i++) {
			int n = s.nextInt(); //팀의 개수
			int k = s.nextInt(); //문제의 개수
			int t = s.nextInt(); //팀의 ID
			int m = s.nextInt(); // 로그 엔트리
			
			if(n<3 || k<0 || k>100 || t<1 || t>n || m<3 || m>10000)
				return;
			
			int[][] score = new int[n][k];
			int[] finalScore = new int[n];
			int[] cnt = new int[n];
			
			for(int j=0; j<n; j++){
				for(int pp=0; pp<n; pp++){
					score[j][pp] = 0;
				}
				finalScore[i] = 0;
				cnt[i] = 0;
			}
			
			for(int j=0; j<m; j++){
				
				int tm_id = s.nextInt();		//팀 ID
				int q_id	 = s.nextInt();		//문제 번호
				int sc = s.nextInt();			//점수
				
				if(score[tm_id-1][q_id-1]<=sc){
					score[tm_id-1][q_id-1] = sc;
					finalScore[tm_id-1] += sc;
					cnt[tm_id-1]++;
				}
			}
			
			int rank = 1; // 나의 팀이 1위라고 가정
			for(int j=0; j<n; j++){
				if(j!=t){
					if(finalScore[t-1]<finalScore[j]){
						rank++;
					}
					else if(finalScore[t-1] == finalScore[j] && cnt[t-1] > cnt[j]){
						rank++;
					}
					//마지막 풀이의 제출 시간이 더 빠른 경우--> 이해 못함ㅠㅠ
				}
				
			}
			
			
			System.out.println(rank);
			
			
			
		}
	}
}
