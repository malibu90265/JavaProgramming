import java.util.ArrayList;
import java.util.Scanner;

public class Routing {
	private double[] dist;//�� ������ �ִ� ���
	private ArrayList<Integer> visited;//�湮�� ���� ����
	private int start, end; //���� �� ��� ��
	
	Routing(int start, int end){
		dist = new double[7];
		for(double d : dist)
			d = 0.0;
		visited = new ArrayList<Integer>();
		this.start = start;
		this.end = end;
		dist[start] = 1;
		visited.add(start);
	}
	
	public static void main(String[] args){
		//��ü ���
		double[][] map = { {0, 1.3, 1.1, 1.24, -1, -1, -1},
							{1.3, 0, 1.26, 2, 1.11, 1.37, -1},
							{1.1, 1.26, 0, -1, -1, -1, 1.2},
							{1.24, 2, -1, 0, 1.17, 1.24, -1},
							{-1, 1.11, -1, 1.17, 0, 1.24, 1.77},
							{-1, 1.37, 01, 1.24, 1.24, 0, 1.11},
							{-1, -1, 1.2, -1, 1.77, 1.11, 0}};
		
		Scanner s = new Scanner(System.in);
		System.out.println("��: �� 7��. 0~6���� ����");
		System.out.print("���, ���� �� �Է�(��: 1 6)>>");
		int start = s.nextInt();
		int end = s.nextInt();
		
		Routing r = new Routing(start, end);
		r.findRoute(map);
		
		
	}
	
	public void findRoute(double[][] map){
		//���� ���� �ٴٶ��� ���
		if (start == end) {
			for (int v : visited)
				System.out.print(v + " -> ");
			System.out.println("�ִܰŸ�>>" + dist[start]);
			return;
		}
		
		int minIdx = -1;
		double minDist = 3.0;
		for (int j = 0; j < 7; j++) {
			//������ ���� �߿��� �������� ���� ���� ���
			if ( !isVisited(j) && map[start][j] >= 1.0) {
				if (dist[j]==0)
					dist[j] = dist[start] * map[start][j];
				//���� �湮�� ���� �������� �ƴϰ�, �̹� dist[j]�� ������ update�� ���� �ִ� ���
				else if(dist[j] > (dist[start] * map[start][j])){
					dist[j] = dist[start] * map[start][j];
					
				}
				if (minDist > dist[start] * map[start][j]){
					minDist = dist[start] * map[start][j];
					minIdx = j;
				}
			}
		}
		start = minIdx;
		visited.add(start);
		findRoute(map);
		
	}
	//�̹� ������ ������ Ȯ��
	public boolean isVisited(int r){
		for(int v : visited)
			if(v == r)
				return true;
		return false;
	}
	
}
