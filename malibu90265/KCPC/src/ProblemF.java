import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemF {
	public static void main(String[] args) throws FileNotFoundException {
		int test;// �Է� �������� ��
		
		Scanner s = new Scanner(new FileInputStream("input.txt"));
		test = s.nextInt();
		
		for (int i = 0; i < test; i++) {
			int n = s.nextInt(); //���� ����
			int k = s.nextInt(); //������ ����
			int t = s.nextInt(); //���� ID
			int m = s.nextInt(); // �α� ��Ʈ��
			
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
				
				int tm_id = s.nextInt();		//�� ID
				int q_id	 = s.nextInt();		//���� ��ȣ
				int sc = s.nextInt();			//����
				
				if(score[tm_id-1][q_id-1]<=sc){
					score[tm_id-1][q_id-1] = sc;
					finalScore[tm_id-1] += sc;
					cnt[tm_id-1]++;
				}
			}
			
			int rank = 1; // ���� ���� 1����� ����
			for(int j=0; j<n; j++){
				if(j!=t){
					if(finalScore[t-1]<finalScore[j]){
						rank++;
					}
					else if(finalScore[t-1] == finalScore[j] && cnt[t-1] > cnt[j]){
						rank++;
					}
					//������ Ǯ���� ���� �ð��� �� ���� ���--> ���� ���ԤФ�
				}
				
			}
			
			
			System.out.println(rank);
			
			
			
		}
	}
}
